package com.yowyob.gestion_organisation.domain.services;


import java.util.UUID;

import com.yowyob.gestion_organisation.application.dto.OrganisationRequest;
import com.yowyob.gestion_organisation.domain.model.Organisation;

public class OrganisationFactory {
    public static Organisation create(OrganisationRequest request , UUID domainKey) {
        return Organisation.builder() 
                .name(request.getName())
                .ownerId(request.getOwnerId())
                .description(request.getDescription())
                .domainKey(domainKey)
                .build();
    }
}

