package com.example.dataserver.models;

import com.google.gson.annotations.SerializedName;
import networking.experience.ExperienceMessage;

import javax.persistence.*;

@Entity
@Table(name = "experience", schema = "sep3")
public class Experience
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "picture")
    private String picture;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "stock")
    private int stock;

    @Column(name = "description")
    private String description;

    @Column(name = "experience_Validity")
    private int experienceValidity;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Category experienceCategory;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.DETACH})
    private User experienceProvider;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private  Address address;

    public Experience()
    {
    }

    public Experience(int id, String picture, String name, double price,int stock, String description, int experienceValidity, Category experienceCategory, User experienceProvider, Address address) {
        this.id = id;
        this.picture = picture;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.description = description;
        this.experienceValidity = experienceValidity;
        this.experienceCategory = experienceCategory;
        this.experienceProvider = experienceProvider;
        this.address = address;
    }

    public Experience(ExperienceMessage e) {
        id = e.getId();
        picture = e.getPicture();
        name = e.getName();
        price = e.getPrice();
        stock = e.getStock();
        description = e.getDescription();
        experienceValidity = e.getExperienceValidity();
        experienceCategory = new Category();
        experienceCategory.setId(e.getCategoryId());
        User user = new User();
        user.setId(e.getProviderId());
        experienceProvider = user;
        address = new Address(e.getAddress());
    }

    public ExperienceMessage toMessage() {
        return ExperienceMessage.newBuilder()
                .setId(id)
                .setPicture(picture)
                .setName(name)
                .setPrice(price)
                .setStock(stock)
                .setDescription(description)
                .setExperienceValidity(experienceValidity)
                .setCategoryId(experienceCategory.getId())
                .setProviderId(experienceProvider.getId())
                .setAddress(address.toMessage())
                .build();

    }

    @Override
   public String toString() {
       return "Experience{" +
               "id=" + id +
               ", picture='" + picture + '\'' +
               ", name='" + name + '\'' +
               ", price=" + price +
               ", stock=" + stock +
               ", description='" + description + '\'' +
               ", experienceValidity='" + experienceValidity + '\'' +
               ", experienceCategory=" + experienceCategory +
               ", experienceProvider=" + experienceProvider +
               ", address=" + address +
               '}';
   }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getExperienceValidity() {
        return experienceValidity;
    }

    public void setExperienceValidity(int experienceValidity) {
        this.experienceValidity = experienceValidity;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Category getExperienceCategory() {
        return experienceCategory;
    }

    public void setExperienceCategory(Category experienceCategory) {
        this.experienceCategory = experienceCategory;
    }

    public User getExperienceProvider() {
        return experienceProvider;
    }

    public void setExperienceProvider(User experienceProvider) {
        this.experienceProvider = experienceProvider;
    }

    public int getStock()
    {
        return stock;
    }

    public void setStock(int stock)
    {
        this.stock = stock;
    }
}
