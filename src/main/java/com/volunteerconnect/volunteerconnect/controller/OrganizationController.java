package com.volunteerconnect.volunteerconnect.controller;

import com.volunteerconnect.volunteerconnect.model.Organization;
import com.volunteerconnect.volunteerconnect.service.OrganizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organizations")
public class OrganizationController {
  private static final Logger logger = LoggerFactory.getLogger(OrganizationController.class);

  @Autowired
  private OrganizationService organizationService;

  @GetMapping
  public ResponseEntity<List<Organization>> getAllOrganizations() {
    logger.info("Fetching all organizations");
    try {
      List<Organization> organizations = organizationService.getAllOrganizations();
      logger.info("Found {} organizations", organizations.size());
      return ResponseEntity.ok(organizations);
    } catch (Exception e) {
      logger.error("Error fetching organizations: ", e);
      return ResponseEntity.internalServerError().build();
    }
  }

  @GetMapping("/{id}")
  public ResponseEntity<Organization> getOrganizationById(@PathVariable Long id) {
    return organizationService.getOrganizationById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<Organization> createOrganization(@RequestBody Organization organization) {
    logger.info("Received organization creation request");
    try {
      Organization createdOrganization = organizationService.createOrganization(organization);
      return ResponseEntity.ok(createdOrganization);
    } catch (Exception e) {
      logger.error("Error creating organization: ", e);
      return ResponseEntity.badRequest().build();
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<Organization> updateOrganization(@PathVariable Long id,
      @RequestBody Organization organizationDetails) {
    try {
      Organization updatedOrganization = organizationService.updateOrganization(id, organizationDetails);
      return ResponseEntity.ok(updatedOrganization);
    } catch (RuntimeException e) {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteOrganization(@PathVariable Long id) {
    try {
      organizationService.deleteOrganization(id);
      return ResponseEntity.ok().build();
    } catch (RuntimeException e) {
      return ResponseEntity.notFound().build();
    }
  }
}