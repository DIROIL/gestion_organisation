
package com.yowyob.gestion_agence.domain.services;

import com.yowyob.gestion_agence.domain.model.IAgence;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public abstract class AgencyFactory {
    private static Map<String, AgencyCreator> creators = new HashMap<>();

    public static void registerAgency(String type, AgencyCreator creator) {
        creators.put(type.toLowerCase(), creator);
    }

    public static IAgence create(String type, String name, String location, UUID organisationId) {
        AgencyCreator creator = creators.get(type.toLowerCase());
        if (creator != null) {
            return creator.create(name, location, organisationId);
        }
        throw new IllegalArgumentException("Unknown agency type: " + type);
    }

    // Functional interface for agency creation
    @FunctionalInterface
    public interface AgencyCreator {
        IAgence create(String name, String location, UUID organisationId);
    }

}



