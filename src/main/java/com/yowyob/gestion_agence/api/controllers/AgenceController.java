package com.yowyob.gestion_agence.api.controllers;

import java.util.List;
import java.util.UUID;

import com.yowyob.gestion_agence.application.services.AgenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.yowyob.gestion_agence.application.dto.AgenceRequest;
import com.yowyob.gestion_agence.application.dto.AgenceResponse;

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
@RequestMapping(path = "/api/v1/Agence")
@Tag(name = "Agence", description = "Endpoints de gestions des agence")
@CrossOrigin("*")
public class AgenceController {
    @Autowired
    private AgenceService agenceService;

    @Operation(summary = "Créer une agence", description = "")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public AgenceResponse postMethodName(@RequestBody AgenceRequest request) {
        return agenceService.createAgence(request);
    }

    
    @Operation(summary = "Lister toute les Agences une Agence", description = "")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/all")
    public List<AgenceResponse> getAllAgence() {
        return agenceService.getAllAgences();
    }

    @Operation(summary = "Obtenir une agence", description = "")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/get_one/{id_Agence}")
    public AgenceResponse getMethodName(@PathVariable(name = "id_agence") UUID id_agence) {
        return agenceService.getOneAgenceById(id_agence);
    }

    @Operation(summary = "Mettre à jour une agence", description = "")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/update/{id_agence}")
    public AgenceResponse updateAgence(@PathVariable(name = "id_agence,") UUID id_agence,
            @RequestBody AgenceRequest request) {
        return agenceService.updateAgence(id_agence, request);
    }

    @Operation(summary = "Supprime une agence", description = "")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("/delete/{id_agence}")
    public String deleteAgence (@PathVariable(name = "id_agence") UUID id_agence) {
        return agenceService.deleteAgence(id_agence);
    }
}
