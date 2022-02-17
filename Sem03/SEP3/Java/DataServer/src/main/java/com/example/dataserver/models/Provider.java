package com.example.dataserver.models;

import com.google.gson.annotations.SerializedName;
import networking.provider.ProviderMessage;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Table(name = "provider", schema = "sep3")
public class Provider {
    @Id
    @Column(name = "user_id")
    private int id;

    @Nullable
    @Column(name = "company_name")
    private String companyName;

    @Nullable
    @Column(name = "cvr")
    private int cvr;

    @Nullable
    @Column(name = "phone_number")
    private String phoneNumber;

    @Nullable
    @Column(name = "description")
    private String description;

    @Nullable
    @Column(name = "is_approved")
    private boolean isApproved = false;

    @Nullable
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Address address;

    @OneToOne
    @MapsId
    @PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    public Provider() {
    }

    public Provider(int id, String companyName, int cvr, String phoneNumber, String description,
                    boolean isApproved, Address address, String email, String password) {
        this.id = id;
        this.companyName = companyName;
        this.cvr = cvr;
        this.phoneNumber = phoneNumber;
        this.description = description;
        this.isApproved = isApproved;
        this.address = address;
    }

    public Provider(ProviderMessage message) {
        user = new User(message.getUser());
        companyName = message.getCompanyName();
        cvr = message.getCvr();
        phoneNumber = message.getPhoneNumber();
        description = message.getDescription();
        isApproved = message.getIsApproved();
        address = new Address(message.getAddress());
    }

    public ProviderMessage toMessage() {
        return ProviderMessage.newBuilder().setAddress(address.toMessage()).setUser(user.toMessage())
                .setCompanyName(companyName).setCvr(cvr).setPhoneNumber(phoneNumber)
                .setDescription(description).setIsApproved(isApproved).build();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(@Nullable String companyName) {
        this.companyName = companyName;
    }

    public int getCvr() {
        return cvr;
    }

    public void setCvr(int cvr) {
        this.cvr = cvr;
    }

    @Nullable
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@Nullable String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    public void setDescription(@Nullable String description) {
        this.description = description;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    @Nullable
    public Address getAddress() {
        return address;
    }

    public void setAddress(@Nullable Address address) {
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
        return "Provider{" + "id=" + id + ", companyName='" + companyName + '\'' + ", cvr=" + cvr
                + ", phoneNumber='" + phoneNumber + '\'' + ", description='" + description + '\''
                + ", isApproved=" + isApproved + ", address=" + address + '}';
    }
}
