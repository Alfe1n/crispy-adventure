package com.example.trying3.util;

import com.example.trying3.MainApplication;
import com.example.trying3.model.Order;
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
                String fxmlPath = "fxml/admin/OrderItemCell.fxml";
                fxmlLoader = new FXMLLoader(MainApplication.class.getResource(fxmlPath));
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
            statusLabel.getStyleClass().removeAll("status-proses", "status-selesai", "status-pending", "status-batal");
            String statusStyle = switch (order.getStatus().toLowerCase()) {
                case "produksi", "proses desain" -> "status-proses";
                case "selesai" -> "status-selesai";
                case "menunggu konfirmasi" -> "status-pending";
                case "dibatalkan" -> "status-batal";
                default -> "";
            };
            if (!statusStyle.isEmpty()) {
                statusLabel.getStyleClass().add(statusStyle);
            }

            // Tampilkan HBox yang sudah diisi data sebagai graphic untuk sel ini
            setText(null);
            setGraphic(rootBox);
        }
    }
}
