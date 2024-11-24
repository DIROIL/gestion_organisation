package com.yowyob.gestion_organisation.application.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import com.yowyob.gestion_organisation.application.dto.OrganisationRequest;
import com.yowyob.gestion_organisation.application.dto.OrganisationResponse;
import com.yowyob.gestion_organisation.domain.services.OrganisationFactory;
import com.yowyob.gestion_organisation.infrastructure.persistence.repository.OrganisationRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class OrganisationService {

    @Autowired
    private OrganisationRepository organisationRepository;

    public OrganisationResponse createOrganisation(OrganisationRequest request) {
        com.yowyob.gestion_organisation.domain.model.Organisation organisation = OrganisationFactory.create(
                request.getName(),
                request.getDescription(),
                request.isTransferable()
                );
        return organisationToOrganisationResponse(organisationRepository.save(organisation));
    }

    public OrganisationResponse getOneOrganisationById(UUID id) {
        com.yowyob.gestion_organisation.domain.model.Organisation organisation = organisationRepository.findById(id).get();
        if (organisation == null) {
            throw new NotFoundException("No such resource");
        }


        return OrganisationResponse.builder()
                .id(organisation.getId())
                .name(organisation.getName())
                .description(organisation.getDescription())
                .transferable(organisation.isTransferable())
                .build();
    }

    public List<OrganisationResponse> getAllOrganisations() {
        return organisationRepository.findAll().stream().map(this::organisationToOrganisationResponse).toList();
    }

    public OrganisationResponse updateOrganisation(UUID id, OrganisationRequest request) {
        com.yowyob.gestion_organisation.domain.model.Organisation organisation = organisationRepository.findById(id).orElse(null);
        if (organisation == null) {
            throw new NotFoundException("No such resource");
        }
        organisation.setName(request.getName());
        organisation.setDescription(request.getDescription());
        organisation.setTransferable(request.isTransferable());

        return organisationToOrganisationResponse(organisationRepository.save(organisation));
    }

    public String deleteOrganisation(UUID id) {
        com.yowyob.gestion_organisation.domain.model.Organisation organisation = organisationRepository.findById(id).orElse(null);
        if (organisation == null) {
            throw new NotFoundException("No such resource");
        }
        organisationRepository.deleteById(id);
        return "Resource deleted";
    }

    private OrganisationResponse organisationToOrganisationResponse(com.yowyob.gestion_organisation.domain.model.Organisation organisation) {
        return OrganisationResponse.builder()
                .id(organisation.getId())
                .name(organisation.getName())
                .description(organisation.getDescription())
                .transferable(organisation.isTransferable())
                .build();
    }
}
