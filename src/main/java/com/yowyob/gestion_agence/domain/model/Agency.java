package com.yowyob.gestion_agence.domain.model;


import java.util.UUID;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("agency")

public class Agency {
   @PrimaryKey
    private UUID id;

    private String name;

    private String location;

    private UUID organisationId;

    private String description;

    private UUID ownerId;

    private UUID domainKey;
}