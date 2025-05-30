package org.example.controller;

import com.google.gson.Gson;
import org.example.Enums.Menus.Menus;
import org.example.model.App;
import org.example.model.User;
import org.example.view.AppView;
import org.example.view.ProfileMenuView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ProfileMenuController {

    private ProfileMenuView view;

    private final String serverIP = "192.168.38.97";
    private final int serverPort = 12346;

    public void setView(ProfileMenuView view) {
        this.view = view;
    }

    public void showProfile() {

        User currentUser = App.getInstance().getCurrentUser();

        StringBuilder profile = new StringBuilder();
        profile.append("Your Profile:\n");
        profile.append("Username: ").append(currentUser.getUsername()).append("\n");
        profile.append("Email address: ").append(currentUser.getEmailAddress()).append("\n");
        profile.append("Bio:\n").append(currentUser.getBiography()).append("\n");
        /*
        TODO: add profile pictures, bio and ...
         */

        view.showMessage(profile.toString());

    }

    public void changeUsername() {

        String newUsername = view.getUserResponse("Enter new username: ");

        Map<String, String> request = new HashMap<>();
        request.put("type", "change-username");
        request.put("old-username", App.getInstance().getCurrentUser().getUsername());
        request.put("new-username", newUsername);

        Gson gson = new Gson();
        String jsonRequest = gson.toJson(request);

        try (Socket socket = new Socket(serverIP, serverPort)) {

            PrintWriter out = new PrintWriter(socket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println(jsonRequest);

            String jsonResponse = in.readLine();
            Map response = gson.fromJson(jsonResponse, Map.class);

            if (response.get("status").equals("success")) {
                view.showMessage("Your username has been successfully changed to " + newUsername + ".");
            } else {
                view.showMessage("Failed: " + response.get("error"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void changePassword() {

        String newPassword = view.getUserResponse("Enter new password: ");

        Map<String, String> request = new HashMap<>();
        request.put("type", "change-password");
        request.put("old-password-hash", App.getInstance().getCurrentUser().getPasswordHash());
        request.put("new-password", newPassword);

        Gson gson = new Gson();
        String jsonRequest = gson.toJson(request);

        try (Socket socket = new Socket(serverIP, serverPort)) {

            PrintWriter out = new PrintWriter(socket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println(jsonRequest);

            String jsonResponse = in.readLine();
            Map response = gson.fromJson(jsonResponse, Map.class);


            if (response.get("status").equals("success")) {
                view.showMessage("Your password has been successfully changed.");
            } else {
                view.showMessage("Failed: " + response.get("error"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void changeBio() {

        String newBio = view.getUserResponse("Enter new bio: ");

        Map<String, String> request = new HashMap<>();
        request.put("type", "change-bio");
        request.put("new-bio", newBio);

        Gson gson = new Gson();
        String jsonRequest = gson.toJson(request);

        try (Socket socket = new Socket(serverIP, serverPort)) {

            PrintWriter out = new PrintWriter(socket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println(jsonRequest);

            String jsonResponse = in.readLine();

            Map response = gson.fromJson(jsonResponse, Map.class);

            if (response.get("status").equals("success")) {
                view.showMessage("Your bio has been changed successfully.");
            } else {
                view.showMessage("Failed: " + response.get("error"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void exit() {
        App.getInstance().setCurrentMenu(Menus.MAIN_MENU);
        view.showMessage("You are now in Main menu.");
    }
}
