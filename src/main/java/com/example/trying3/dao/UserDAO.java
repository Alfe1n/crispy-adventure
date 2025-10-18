package com.example.trying3.dao;

import com.example.trying3.config.DatabaseConnection;
import com.example.trying3.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    // Method untuk mengambil semua user
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        String sql = "SELECT id_user, username, nama, email, id_role, status_aktif FROM user";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                User user = new User();
                user.setIdUser(rs.getInt("id_user"));
                user.setUsername(rs.getString("username"));
                user.setNama(rs.getString("nama"));
                user.setEmail(rs.getString("email"));
                user.setIdRole(rs.getInt("id_role"));
                user.setStatusAktif(rs.getInt("status_aktif"));

                userList.add(user);
            }

            System.out.println("Berhasil mengambil " + userList.size() + " user dari database");

        } catch (SQLException e) {
            System.err.println("Error saat mengambil data user!");
            e.printStackTrace();
        }

        return userList;
    }

    // Method untuk mencari user berdasarkan username
    public User getUserByUsername(String username) {
        String sql = "SELECT * FROM user WHERE username = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                User user = new User();
                user.setIdUser(rs.getInt("id_user"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setNama(rs.getString("nama"));
                user.setEmail(rs.getString("email"));
                user.setIdRole(rs.getInt("id_role"));
                user.setStatusAktif(rs.getInt("status_aktif"));
                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Method untuk menghitung total user
    public int getTotalUsers() {
        String sql = "SELECT COUNT(*) as total FROM user";
        int total = 0;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                return rs.getInt("total");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
}