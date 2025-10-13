package com.example.trying3;

public class Order {
    private String customerName;
    private String orderType;
    private String status;
    private String statusColor; // Warna hex untuk status, misal: "#2ecc71"

    public Order(String customerName, String orderType, String status, String statusColor) {
        this.customerName = customerName;
        this.orderType = orderType;
        this.status = status;
        this.statusColor = statusColor;
    }

    // Getters
    public String getCustomerName() { return customerName; }
    public String getOrderType() { return orderType; }
    public String getStatus() { return status; }
    public String getStatusColor() { return statusColor; }
}
