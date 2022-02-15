package com.example.dataserver.models;


import com.google.gson.annotations.SerializedName;
import networking.order.OrderItemMessage;

import javax.persistence.*;

@Entity
@Table(name = "order_item", schema = "sep3")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @JoinColumn(name="order_id", nullable=false)
    @ManyToOne
    private Order order;

    @Column(name = "picture")
    private String picture;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "description")
    private String description;

    @Column(name = "voucher")
    private String voucher;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private User provider;

    @Column(name = "quantity")
    private int quantity;

    public OrderItem(){
    }

    public OrderItem(OrderItemMessage item){
        provider = new User();
        provider.setId(item.getProviderId());
        picture = item.getPicture();
        name = item.getName();
        price = item.getPrice();
        description = item.getDescription();
        quantity = item.getQuantity();
        voucher = item.getVoucher();
    }

    public OrderItemMessage toMessage(){
        return OrderItemMessage.newBuilder()
                .setId(id)
                .setPicture(picture)
                .setName(name)
                .setPrice(price)
                .setDescription(description)
                .setQuantity(quantity)
                .setVoucher(voucher)
                .setProviderId(provider.getId())
                .build();
    }

    public String getVoucher() {
        return voucher;
    }

    public User getProvider() {
        return provider;
    }

    public void setProvider(User provider) {
        this.provider = provider;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
