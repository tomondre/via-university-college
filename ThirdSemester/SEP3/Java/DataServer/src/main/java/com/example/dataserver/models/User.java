package com.example.dataserver.models;

import com.google.gson.annotations.SerializedName;
import networking.customer.CustomerMessage;
import networking.provider.ProviderMessage;
import networking.user.UserMessage;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "security_type")
    private String securityType;

    @Nullable
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Provider provider;

    @Nullable
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Customer customer;

    public User() {
    }

    public User(UserMessage message) {
        id = message.getId();
        email = message.getEmail();
        password = message.getPassword();
        securityType = message.getSecurityType();
    }

    public User(ProviderMessage provider) {
        var user = provider.getUser();
        id = user.getId();
        email = user.getEmail();
        password = user.getPassword();
        securityType = user.getSecurityType();
        this.provider = new Provider(provider);
    }

    public UserMessage toMessage() {
        return UserMessage.newBuilder().setId(id).setEmail(email).setPassword(password)
                .setSecurityType(securityType).build();
    }

    public ProviderMessage toProviderMessage() {
        return ProviderMessage.newBuilder().setUser(toMessage()).setCompanyName(provider.getCompanyName()).setCvr(
                provider.getCvr()).setDescription(provider.getDescription()).setIsApproved(provider.isApproved()).setPhoneNumber(
                provider.getPhoneNumber()).setAddress(provider.getAddress().toMessage()).build();
    }

    public CustomerMessage toCustomerMessage() {
        return CustomerMessage.newBuilder().setUser(toMessage()).setFirstName(customer.getFirstName())
                .setLastName(customer.getLastName()).setPhoneNumber(customer.getPhoneNumber())
                .setAddress(customer.getAddress().toMessage()).build();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Nullable
    public Provider getProvider() {
        return provider;
    }

    public void setProvider(@Nullable Provider provider) {
        this.provider = provider;
    }

    @Nullable
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(@Nullable Customer customer) {
        this.customer = customer;
    }

    public String getSecurityType() {
        return securityType;
    }

    public void setSecurityType(String securityType) {
        this.securityType = securityType;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", email='" + email + '\'' + ", password='" + password + '\''
                + ", securityType='" + securityType + '\'' + ", provider=" + provider + ", customer="
                + customer + '}';
    }
}
