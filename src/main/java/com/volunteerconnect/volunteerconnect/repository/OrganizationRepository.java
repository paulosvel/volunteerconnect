package com.volunteerconnect.volunteerconnect.repository;

import com.volunteerconnect.volunteerconnect.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
  
}