package com.volunteerconnect.volunteerconnect.service;

import com.volunteerconnect.volunteerconnect.model.Organization;
import com.volunteerconnect.volunteerconnect.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Organization> getAllOrganizations() {
        return organizationRepository.findAll();
    }

    public Optional<Organization> getOrganizationById(Long id) {
        return organizationRepository.findById(id);
    }

    public Organization createOrganization(Organization organization) {
        // Hash the password before saving
        organization.setPasswordHash(passwordEncoder.encode(organization.getPasswordHash()));
        return organizationRepository.save(organization);
    }

    public Organization updateOrganization(Long id, Organization organizationDetails) {
        Organization organization = organizationRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Organization not found"));

        organization.setOrganizationName(organizationDetails.getOrganizationName());
        organization.setContactEmail(organizationDetails.getContactEmail());
        organization.setContactPhone(organizationDetails.getContactPhone());

        return organizationRepository.save(organization);
    }

    public void deleteOrganization(Long id) {
        Organization organization = organizationRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Organization not found"));
        organizationRepository.delete(organization);
    }
}