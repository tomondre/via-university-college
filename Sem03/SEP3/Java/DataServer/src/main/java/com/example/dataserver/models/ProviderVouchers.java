package com.example.dataserver.models;

import jdk.jfr.DataAmount;
import networking.order.OrderItemMessage;
import networking.order.VoucherMessages;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ProviderVouchers {

    private String name;
    private LocalDateTime dateCreated;
    private String voucher;
    private int quantity;
    private String experienceName;

    public ProviderVouchers(String name, LocalDateTime dateCreated, String voucher, int quantity, String experienceName) {
        this.name = name;
        this.dateCreated = dateCreated;
        this.voucher = voucher;
        this.quantity = quantity;
        this.experienceName = experienceName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getExperienceName() {
        return experienceName;
    }

    public void setExperienceName(String experienceName) {
        this.experienceName = experienceName;
    }

    public ProviderVouchers(VoucherMessages item) {
        DateTimeFormatter formatter = DateTimeFormatter. ofPattern("yyyy-MM-dd HH:mm");
        name = item.getCustomerName();
        dateCreated = LocalDateTime.parse(item.getDate(), formatter);
        voucher = item.getVoucher();
        quantity = item.getQuantity();
        experienceName = item.getExperienceName();
    }

    public VoucherMessages toMessage() {
        return VoucherMessages.newBuilder()
                .setCustomerName(name)
                .setDate(dateCreated.toString())
                .setVoucher(voucher)
                .setQuantity(quantity)
                .setExperienceName(experienceName)
                .build();
    }

}
