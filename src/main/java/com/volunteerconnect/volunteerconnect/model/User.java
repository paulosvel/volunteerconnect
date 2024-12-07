package com.volunteerconnect.volunteerconnect.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "userid")
  private Long userId;

  @Column(name = "fullname", nullable = false, length = 100)
  private String fullName;

  @Column(name = "email", nullable = false, unique = true, length = 100)
  private String email;

  @Column(name = "passwordhash", nullable = false)
  private String passwordHash;

  @Column(name = "roleid")
  private Integer roleId;

  @Column(name = "isapproved", nullable = false)
  private Boolean isApproved;

  @Column(name = "createdat", nullable = false, insertable = false, updatable = false,
          columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  private LocalDateTime createdAt;

  // Default constructor
  public User() {
    this.isApproved = false;
  }

  // Getters and Setters
  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
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

  public Integer getRoleId() {
    return roleId;
  }

  public void setRoleId(Integer roleId) {
    this.roleId = roleId;
  }

  public Boolean getIsApproved() {
    return isApproved;
  }

  public void setIsApproved(Boolean approved) {
    isApproved = approved;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  @Override
  public String toString() {
    return "User{" +
        "userId=" + userId +
        ", fullName='" + fullName + '\'' +
        ", email='" + email + '\'' +
        ", roleId=" + roleId +
        ", isApproved=" + isApproved +
        ", createdAt=" + createdAt +
        '}';
  }
}
