package com.example.dataserver.models;

import com.google.gson.annotations.SerializedName;
import networking.customer.CustomerMessage;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Table(name = "customer", schema = "sep3")
public class Customer {

    @Id
    @Column(name = "user_id")
    private int id;

    @Nullable
    @Column(name = "first_name")
    private String firstName;

    @Nullable
    @Column(name = "last_name")
    private String lastName;

    @Nullable
    @Column(name = "phone_number")
    private String phoneNumber;

    @Nullable
    @ManyToOne(cascade = CascadeType.ALL)
    private Address address;

    @OneToOne
    @MapsId
    @PrimaryKeyJoinColumn(name = "user_id")
    private User user;

    public Customer() {

    }

    public Customer(int id, String firstName, String lastName, String phoneNumber, Address address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Customer(CustomerMessage message) {
        user = new User(message.getUser());
        firstName = message.getFirstName();
        lastName = message.getLastName();
        phoneNumber = message.getPhoneNumber();
        address = new Address(message.getAddress());
    }

    public CustomerMessage toMessage() {
        return CustomerMessage.newBuilder().setUser(user.toMessage()).setAddress(address.toMessage())
                .setFirstName(firstName).setLastName(lastName).setPhoneNumber(phoneNumber).build();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Nullable
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(@Nullable String firstName) {
        this.firstName = firstName;
    }

    @Nullable
    public String getLastName() {
        return lastName;
    }

    public void setLastName(@Nullable String lastName) {
        this.lastName = lastName;
    }

    @Nullable
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@Nullable String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", firstName='" + firstName + '\'' + ", lastName='" + lastName
                + '\'' + ", phoneNumber='" + phoneNumber + '\'' + ", address=" + address + '}';
    }
}
