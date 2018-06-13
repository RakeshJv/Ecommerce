package com.ecommerce.model;

public class Login {
    // this will hold the username in program
 private   String userName;
 // this hold the password
 private   String password;
 // this will hold the serverToken
    String serverToken;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getServerToken() {
        return serverToken;
    }

    public void setServerToken(String serverToken) {
        this.serverToken = serverToken;
    }


}
