package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User
{
  private @Id
  @GeneratedValue
  Long id;
  private String email;
  private String password;

  public User(String email,String password )
  {
    this.email = email;
    this.password = password;
  }

  public User() {}

  public Long getId()
  {
    return id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public String getPassword()
  {
    return password;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }

  @Override public String toString()
  {
    return "User{" + "id=" + id + ", email='" + email + '\'' + ", password='"
        + password + '\'' + '}';
  }
}
