package com.yowyob.gestion_agence.application.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import com.yowyob.gestion_agence.application.dto.AgencyRequest;
import com.yowyob.gestion_agence.application.dto.AgencyResponse;
import com.yowyob.gestion_agence.domain.services.AgencyFactory;
import com.yowyob.gestion_agence.infrastructure.persistence.repository.AgencyRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class AgencyService {

    @Autowired
    private AgencyRepository agencyRepository;

    public AgencyResponse createAgence(AgencyRequest request , UUID domainKey) {
        com.yowyob.gestion_agence.domain.model.Agency agency = AgencyFactory.create(request,domainKey );
        return agencyToAgencyResponse (agencyRepository.save(agency));
    }

    public AgencyResponse  getOneAgenceById(UUID id) {
        com.yowyob.gestion_agence.domain.model.Agency agency = agencyRepository.findById(id).get();
        if (agency == null) {
            throw new NotFoundException("No such resource");
        }


        return AgencyResponse .builder()
                .id(agency.getId())
                .name(agency.getName())
                .description(agency.getDescription())
                .build();
    }

    public List<AgencyResponse > getAllAgences() {
        return agencyRepository.findAll().stream().map(this::agencyToAgencyResponse ).toList();
    }

    public List<AgencyResponse > getAllAgences(UUID domainKey) {
        return agencyRepository.findByDomainKey(domainKey).stream().map(this::agencyToAgencyResponse ).toList();
    }


    public AgencyResponse  updateAgency(UUID id, AgencyRequest request) {
        com.yowyob.gestion_agence.domain.model.Agency agency = agencyRepository.findById(id).orElse(null);
        if (agency == null) {
            throw new NotFoundException("No such resource");
        }
        agency.setName(request.getName());
        agency.setDescription(request.getDescription());

        return agencyToAgencyResponse (agencyRepository.save(agency));
    }

    public String deleteAgence(UUID id) {
        com.yowyob.gestion_agence.domain.model.Agency agency = agencyRepository.findById(id).orElse(null);
        if (agency == null) {
            throw new NotFoundException("No such agency");
        }
        agencyRepository.deleteById(id);
        return "Resource deleted";
    }

    private AgencyResponse  agencyToAgencyResponse (com.yowyob.gestion_agence.domain.model.Agency agency) {
        return AgencyResponse .builder()
                .id(agency.getId())
                .name(agency.getName())
                .description(agency.getDescription())
                .build();
    }
}
