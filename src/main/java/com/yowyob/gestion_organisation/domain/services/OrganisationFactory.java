package com.yowyob.gestion_organisation.domain.services;

import com.yowyob.gestion_organisation.domain.model.Organisation;

public class OrganisationFactory {
    public static Organisation create(String name,
                                      String description,
                                      boolean transferable) {
        return Organisation.builder()
                .name(name)
                .description(description)
                .transferable(transferable)
                .build();
    }
}
