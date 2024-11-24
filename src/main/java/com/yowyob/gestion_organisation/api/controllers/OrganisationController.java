package com.yowyob.gestion_organisation.api.controllers;

import java.util.List;
import java.util.UUID;

import com.yowyob.gestion_organisation.application.services.OrganisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.yowyob.gestion_organisation.application.dto.OrganisationRequest;
import com.yowyob.gestion_organisation.application.dto.OrganisationResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping(path = "/api/v1/organisation")
@Tag(name = "Organisation", description = "Endpoints de gestions des Organisation")
@CrossOrigin("*")
public class OrganisationController {
    @Autowired
    private OrganisationService organisationService;

    @Operation(summary = "Créer une organisation", description = "")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public OrganisationResponse postMethodName(@RequestBody OrganisationRequest request) {
        return organisationService.createOrganisation(request);
    }

    
    @Operation(summary = "Lister toute les Agences une Organisation", description = "")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/all")
    public List<OrganisationResponse> getAllOrganisation() {
        return organisationService.getAllOrganisations();
    }

    @Operation(summary = "Obtenir une organisation", description = "")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/get_one/{id_Organisation}")
    public OrganisationResponse getMethodName(@PathVariable(name = "id_organisation") UUID id_organisation) {
        return organisationService.getOneOrganisationById(id_organisation);
    }

    @Operation(summary = "Mettre à jour une organisation", description = "")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/update/{id_organisation}")
    public OrganisationResponse updateAOrganisation(@PathVariable(name = "id_organisation") UUID id_organisation,
            @RequestBody OrganisationRequest request) {
        return organisationService.updateOrganisation(id_organisation, request);
    }

    @Operation(summary = "Supprime une organisation", description = "")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("/delete/{id_organisation}")
    public String deleteAOrganisation (@PathVariable(name = "id_organisation") UUID id_organisation) {
        return organisationService.deleteOrganisation(id_organisation);
    }
}
