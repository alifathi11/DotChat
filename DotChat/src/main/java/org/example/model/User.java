package org.example.model;

public class User {
    private String username;
    private String passwordHash;
    private String emailAddress;
    private String biography;
    private Statue status;

    public User(String username,
                String passwordHash,
                String emailAddress) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.emailAddress = emailAddress;
        this.biography = "";

        this.status = Statue.ONLINE;
        /*
        * When a user created, it is online.
         */
    }

    public String getUsername() {
        return username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public Statue getStatus() {
        return status;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
    public void setStatus(Statue status) {
        this.status = status;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
}

