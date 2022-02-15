package com.example.dataserver.models;


public class Login {
    private String email;
    private String password;
    private String accessType;

    public Login(String email, String password, String accessType) {
        this.email = email;
        this.password = password;
        this.accessType = accessType;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAccessType() {
        return accessType;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }
}
