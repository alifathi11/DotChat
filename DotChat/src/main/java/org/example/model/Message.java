package org.example.model;

import java.time.LocalDateTime;

public class Message {
    private final String id;
    private final User sender;
    private final User recipient;
    /*
    * for now, we have just 1-1 chat.
    * later we will add group chats. (chat rooms)
     */
    private String content;
    private LocalDateTime timeStamp;
    /*
     * for now, we are sending just text messages.
     * later we will add files.
     */

    public Message(User sender,
                   User recipient,
                   String content) {
        this.id = "";
        /*
        TODO: add a method for generating unique IDs.
         */
        this.sender = sender;
        this.recipient = recipient;

        this.timeStamp = LocalDateTime.now();
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public String getContent() {
        return content;
    }

    public String getId() {
        return id;
    }

    public User getRecipient() {
        return recipient;
    }

    public User getSender() {
        return sender;
    }
}
