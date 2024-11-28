package com.yowyob.gestion_agence.domain.services;

import com.yowyob.gestion_agence.domain.model.TravelAgency;
import com.yowyob.gestion_agence.domain.model.FarmAgency;
import java.util.UUID;


public class ConcreteAgencyFactory extends AgencyFactory {
    static {
        // Register existing agency types
        AgencyFactory.registerAgency("travel", (name, location, organisationId) ->
                TravelAgency.builder()
                        .id(UUID.randomUUID())
                        .name(name)
                        .location(location)
                        .organisationId(organisationId)
                        .build());

        AgencyFactory.registerAgency("farm", (name, location, organisationId) ->
                FarmAgency.builder()
                        .id(UUID.randomUUID())
                        .name(name)
                        .location(location)
                        .organisationId(organisationId)
                        .build());
    }

}