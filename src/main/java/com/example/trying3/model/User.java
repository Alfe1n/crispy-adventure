package com.example.trying3.model;

import java.time.LocalDateTime;

public class User {
    private int idUser;
    private String username;
    private String password;
    private String nama;
    private String email;
    private int idRole;
    private int statusAktif;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Constructor
    public User() {}

    public User(int idUser, String username, String nama, String email, int idRole, int statusAktif) {
        this.idUser = idUser;
        this.username = username;
        this.nama = nama;
        this.email = email;
        this.idRole = idRole;
        this.statusAktif = statusAktif;
    }

    // Getters and Setters
    public int getIdUser() { return idUser; }
    public void setIdUser(int idUser) { this.idUser = idUser; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getIdRole() { return idRole; }
    public void setIdRole(int idRole) { this.idRole = idRole; }

    public int getStatusAktif() { return statusAktif; }
    public void setStatusAktif(int statusAktif) { this.statusAktif = statusAktif; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    @Override
    public String toString() {
        return "User{" +
                "id=" + idUser +
                ", username='" + username + '\'' +
                ", nama='" + nama + '\'' +
                ", email='" + email + '\'' +
                ", role=" + idRole +
                ", status=" + statusAktif +
                '}';
    }
}