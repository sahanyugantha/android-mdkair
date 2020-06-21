package com.sahan.mdkbookings.model;

public class User {

    private int id;
    private String username;
    private String email;
    private String password;
    private USER_ROLES roles;
    private boolean logged_in;

    public User() {
    }

    public User(int id, String username, String email, String password, USER_ROLES roles, boolean logged_in) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.logged_in = logged_in;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public USER_ROLES getRoles() {
        return roles;
    }

    public void setRoles(USER_ROLES roles) {
        this.roles = roles;
    }

    public boolean isLogged_in() {
        return logged_in;
    }

    public void setLogged_in(boolean logged_in) {
        this.logged_in = logged_in;
    }
}
