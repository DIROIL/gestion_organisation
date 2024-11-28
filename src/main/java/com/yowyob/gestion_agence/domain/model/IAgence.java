package com.yowyob.gestion_agence.domain.model;

import java.util.UUID;

public interface IAgence {

    UUID getId();
    String getName();
    String getLocation();
    UUID getOrganisationId();

}
