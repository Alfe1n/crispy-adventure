package com.example.trying3.controller.auth;

import com.example.trying3.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private void handleLoginButton(ActionEvent e) throws IOException {
        // Load scene dashboard yang baru dan lebih efisien
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("fxml/admin/Dashboard.fxml"));
        Scene dashboardScene = new Scene(fxmlLoader.load(), 1920, 1080); // Pastikan ukuran scene konsisten

        // Dapatkan stage saat ini dari event button click
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();

        // Ganti scene ke dashboard
        stage.setScene(dashboardScene);
        stage.setResizable(false);
        stage.centerOnScreen(); // Posisikan window di tengah layar
        stage.show();
    }
}
