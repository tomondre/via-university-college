package com.example.dataserver.models;


import com.google.gson.annotations.SerializedName;
import networking.address.AddressMessage;

import javax.persistence.*;

@Entity
@Table(name = "address", schema = "sep3", uniqueConstraints={@UniqueConstraint(columnNames ={"id", "city", "street", "street_no", "post_code"})})
public class Address
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "street")
    private String street;

    @Column(name = "street_no")
    private String streetNumber;

    @Column(name = "post_code")
    private int postCode;

    @Column(name = "city")
    private String city;

  public Address()
  {
  }

  public Address(int id, String street, String streetNumber, int postCode, String city)
  {
    this.id = id;
    this.street = street;
    this.streetNumber = streetNumber;
    this.postCode = postCode;
    this.city = city;
  }

  public Address(AddressMessage message)
  {
    id = message.getId();
    street = message.getStreet();
    streetNumber = message.getStreetNumber();
    postCode = message.getPostCode();
    city = message.getCity();
  }

  public AddressMessage toMessage()
  {
    return AddressMessage.newBuilder().setId(id).setStreet(street).setStreetNumber(streetNumber)
        .setPostCode(postCode).setCity(city).build();
  }

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public String getStreet()
  {
    return street;
  }

  public void setStreet(String street)
  {
    this.street = street;
  }

  public String getStreetNumber()
  {
    return streetNumber;
  }

  public void setStreetNumber(String streetNumber)
  {
    this.streetNumber = streetNumber;
  }

  public int getPostCode()
  {
    return postCode;
  }

  public void setPostCode(int postCode)
  {
    this.postCode = postCode;
  }

  public String getCity()
  {
    return city;
  }

  public void setCity(String city)
  {
    this.city = city;
  }

  @Override
  public String toString()
  {
    return "Address{" + "id=" + id + ", street='" + street + '\'' + ", streetNumber='"
        + streetNumber + '\'' + ", postCode=" + postCode + ", city='" + city + '\'' + '}';
  }
}
