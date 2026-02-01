package com.example.RoleBasedSecurity.Entities;

import jakarta.persistence.*;
import jakarta.websocket.ClientEndpoint;

@Entity
@Table
public class User {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    int userid;
    @Column
    String password;
    @Column
    String role;
    @Column
    String email;
    @Column
    String phone;
    @Column
    String username;

    public User() {
    }

    public User(int userid, String password, String role, String email, String phone, String username) {
        this.userid = userid;
        this.password = password;
        this.role = role;
        this.email = email;
        this.phone = phone;
        this.username = username;
    }

    public User(String password, String role, String email, String phone, String username) {
        this.password = password;
        this.role = role;
        this.email = email;
        this.phone = phone;
        this.username = username;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
