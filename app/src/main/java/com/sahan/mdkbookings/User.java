package com.sahan.mdkbookings;

public class User {

    private int id;
    private String username;
    private String email;
    private String password;
    private USER_ROLES roles;

    public User() {
    }

    public User(int id, String username, String email, String password, USER_ROLES roles) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
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
}
