package com.yowyob.gestion_agence.application.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import com.yowyob.gestion_agence.application.dto.AgenceRequest;
import com.yowyob.gestion_agence.application.dto.AgenceResponse;
import com.yowyob.gestion_agence.domain.services.AgenceFactory;
import com.yowyob.gestion_agence.infrastructure.persistence.repository.AgenceRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class AgenceService {

    @Autowired
    private AgenceRepository agenceRepository;

    public AgenceResponse createAgence(AgenceRequest request) {
        com.yowyob.gestion_agence.domain.model.Agence agence = AgenceFactory.create(
                request.getName(),
                request.getDescription(),
                request.isTransferable()
                );
        return agenceToAgenceResponse (agenceRepository.save(agence));
    }

    public AgenceResponse  getOneAgenceById(UUID id) {
        com.yowyob.gestion_agence.domain.model.Agence agence = agenceRepository.findById(id).get();
        if (agence == null) {
            throw new NotFoundException("No such resource");
        }


        return AgenceResponse .builder()
                .id(agence.getId())
                .name(agence.getName())
                .description(agence.getDescription())
                .transferable(agence.isTransferable())
                .build();
    }

    public List<AgenceResponse > getAllAgences() {
        return agenceRepository.findAll().stream().map(this::agenceToAgenceResponse ).toList();
    }

    public AgenceResponse  updateAgence(UUID id, AgenceRequest request) {
        com.yowyob.gestion_agence.domain.model.Agence agence = agenceRepository.findById(id).orElse(null);
        if (agence == null) {
            throw new NotFoundException("No such resource");
        }
        agence.setName(request.getName());
        agence.setDescription(request.getDescription());
        agence.setTransferable(request.isTransferable());

        return agenceToAgenceResponse (agenceRepository.save(agence));
    }

    public String deleteAgence(UUID id) {
        com.yowyob.gestion_agence.domain.model.Agence agence = agenceRepository.findById(id).orElse(null);
        if (agence == null) {
            throw new NotFoundException("No such resource");
        }
        agenceRepository.deleteById(id);
        return "Resource deleted";
    }

    private AgenceResponse  agenceToAgenceResponse (com.yowyob.gestion_agence.domain.model.Agence agence) {
        return AgenceResponse .builder()
                .id(agence.getId())
                .name(agence.getName())
                .description(agence.getDescription())
                .transferable(agence.isTransferable())
                .build();
    }
}
