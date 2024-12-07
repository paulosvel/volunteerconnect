package com.volunteerconnect.volunteerconnect.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Organizations")
public class Organization {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "organizationid")
  private Long organizationId;

  @Column(name = "organizationname", nullable = false, length = 100)
  private String organizationName;

  @Column(name = "contactemail", nullable = false, length = 100)
  private String contactEmail;

  @Column(name = "contactphone", length = 15)
  private String contactPhone;

  @Column(name = "email", nullable = false, unique = true, length = 100)
  private String email;

  @Column(name = "passwordhash", nullable = false)
  private String passwordHash;

  // Constructor
  public Organization() {
  }

  // Getters and Setters
  public Long getOrganizationId() {
    return organizationId;
  }

  public void setOrganizationId(Long organizationId) {
    this.organizationId = organizationId;
  }

  public String getOrganizationName() {
    return organizationName;
  }

  public void setOrganizationName(String organizationName) {
    this.organizationName = organizationName;
  }

  public String getContactEmail() {
    return contactEmail;
  }

  public void setContactEmail(String contactEmail) {
    this.contactEmail = contactEmail;
  }

  public String getContactPhone() {
    return contactPhone;
  }

  public void setContactPhone(String contactPhone) {
    this.contactPhone = contactPhone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPasswordHash() {
    return passwordHash;
  }

  public void setPasswordHash(String passwordHash) {
    this.passwordHash = passwordHash;
  }
}