package org.example.controller;

import com.google.gson.Gson;

import org.example.Enums.Menus.Menus;
import org.example.model.App;
import org.example.view.RegisterMenuView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class RegisterMenuController {
    private RegisterMenuView view;
    private final String serverIP = "192.168.38.97";
    private final int serverPort = 12346;

    public void setView(RegisterMenuView view) {
        this.view = view;
    }

    public void login() {

        String username = view.getResponse("Enter your username: ");
        String password = view.getResponse("Enter your password: ");

        Map<String, String> request = new HashMap<>();
        request.put("type", "login");
        request.put("username", username);
        request.put("password", password);

        Gson gson = new Gson();
        String jsonRequest = gson.toJson(request);

        try (Socket socket = new Socket(serverIP, serverPort)) {

            PrintWriter out = new PrintWriter(socket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println(jsonRequest);

            String jsonResponse = in.readLine();
            Map response = gson.fromJson(jsonResponse, Map.class);

            if (response.get("status").equals("success")) {
                view.showMessage(username + ", Welcome to DotChat!");
                // TODO: change menu -> App.getInstance().setCurrentMenu(Menus.MAIN_MENU);
            } else {
                view.showMessage("Login failed: " + response.get("error"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void signup() {

        String username = view.getResponse("Enter your username: ");
        String password = view.getResponse("Enter your password: ");
        String email = view.getResponse("Enter your email address: ");

        Map<String, String> signupRequest = new HashMap<>();
        signupRequest.put("type", "signup");
        signupRequest.put("username", username);
        signupRequest.put("password", password);
        signupRequest.put("email", email);

        Gson gson = new Gson();
        String jsonRequest = gson.toJson(signupRequest);

        try (Socket socket = new Socket(serverIP, serverPort)) {

            PrintWriter out = new PrintWriter(socket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println(jsonRequest);

            String jsonResponse = in.readLine();
            Map response = gson.fromJson(jsonResponse, Map.class);

            if (response.get("status").equals("success")) {
                view.showMessage("User created successfully. You are now in Main menu.");
                // TODO: change menu -> App.getInstance().setCurrentMenu(Menus.MAIN_MENU);

            } else {
                view.showMessage("Signup failed: " + response.get("error"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void forgetPassword() {

        String username = view.getResponse("Enter your username: ");
        String email = view.getResponse("Enter your email address: ");

        Map<String, String> request = new HashMap<>();
        request.put("type", "forget-password");
        request.put("username", username);
        request.put("email", email);

        Gson gson = new Gson();
        String jsonRequest = gson.toJson(request);

        try (Socket socket = new Socket(serverIP, serverPort)) {

            PrintWriter out = new PrintWriter(socket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println(jsonRequest);

            String jsonResponse = in.readLine();
            Map response = gson.fromJson(jsonResponse, Map.class);

            if (response.get("status").equals("success")) {
                view.showMessage("Check your email to change your password.");
            } else {
                view.showMessage("Retrieving password failed: " + response.get("error"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public void exit() {
        App.getInstance().exit();
    }
}
