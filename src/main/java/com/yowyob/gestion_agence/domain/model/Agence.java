package com.yowyob.gestion_agence.domain.model;


import java.util.UUID;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("Agence")

public abstract class Agence implements IAgence{
   @PrimaryKey
    private UUID id;

    private String name;

    private String location;

    private UUID organisationId;

    private String description;

    private boolean transferable;

    public Agence(UUID id, String name, String location, UUID organisationId) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.organisationId = organisationId;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public UUID getOrganisationId() {
        return organisationId;
    }
    
}