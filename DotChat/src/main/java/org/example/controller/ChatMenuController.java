package org.example.controller;

import com.google.gson.Gson;
import org.example.model.App;
import org.example.view.ChatMenuView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ChatMenuController {

    private ChatMenuView view;

    private final String serverIP = "192.168.38.97";
    private final int serverPort = 12346;

    public void setView(ChatMenuView view) {
        this.view = view;
    }

    public void sendMessage() {

        String recipient = view.getUserResponse("Enter the user you want to send message to: ");
        String content = view.getUserResponse("Enter your message:\n");

        Map<String, String> request = new HashMap<>();
        request.put("type", "send-message");
        request.put("sender", App.getInstance().getCurrentUser().getUsername());
        request.put("recipient", recipient);
        request.put("content", content);

        Gson gson = new Gson();
        String jsonRequest = gson.toJson(request);

        try (Socket socket = new Socket(serverIP, serverPort)) {

            PrintWriter out = new PrintWriter(socket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println(jsonRequest);

            String jsonResponse = in.readLine();

            Map response = gson.fromJson(jsonResponse, Map.class);

            if (response.get("status").equals("success")) {
                view.showMessage("Message sent successfully.");
            } else {
                view.showMessage("Failed to send message: " + response.get("error"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
