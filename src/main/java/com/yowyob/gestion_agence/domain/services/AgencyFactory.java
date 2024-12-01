package com.yowyob.gestion_agence.domain.services;

import java.util.UUID;

import com.yowyob.gestion_agence.application.dto.AgencyRequest;
import com.yowyob.gestion_agence.domain.model.Agency;

public class AgencyFactory {
      public static Agency create(AgencyRequest request , UUID domainKey) {
        return Agency.builder() 
                .name(request.getName())
                .ownerId(request.getOwnerId())
                .description(request.getDescription())
                .domainKey(domainKey)
                .build();
    }

}
