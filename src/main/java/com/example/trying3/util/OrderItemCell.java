package com.example.trying3;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;

import java.io.IOException;

/**
 * Kelas ini bertanggung jawab untuk menampilkan satu baris data Order
 * di dalam ListView menggunakan layout dari OrderItemCell.fxml.
 */
public class OrderItemCell extends ListCell<Order> {

    @FXML private HBox rootBox;
    @FXML private Label customerNameLabel;
    @FXML private Label orderTypeLabel;
    @FXML private Label statusLabel;

    private FXMLLoader fxmlLoader;

    @Override
    protected void updateItem(Order order, boolean empty) {
        super.updateItem(order, empty);

        if (empty || order == null) {
            setText(null);
            setGraphic(null);
        } else {
            // Load FXML hanya jika belum pernah di-load untuk sel ini
            if (fxmlLoader == null) {
                fxmlLoader = new FXMLLoader(getClass().getResource("OrderItemCell.fxml"));
                fxmlLoader.setController(this); // Penting! Controller-nya adalah kelas ini sendiri
                try {
                    fxmlLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            // Set data ke elemen-elemen FXML
            customerNameLabel.setText(order.getCustomerName());
            orderTypeLabel.setText(order.getOrderType());
            statusLabel.setText(order.getStatus());

            // Set warna status secara dinamis
            String style = String.format("-fx-background-color: %s; -fx-background-radius: 15; -fx-text-fill: white; -fx-alignment: center; -fx-padding: 8 16;", order.getStatusColor());
            statusLabel.setStyle(style);

            // Tampilkan HBox yang sudah diisi data sebagai graphic untuk sel ini
            setGraphic(rootBox);
        }
    }
}
