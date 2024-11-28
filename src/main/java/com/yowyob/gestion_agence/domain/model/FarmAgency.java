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
@Table("farm_agency")

public class FarmAgency extends Agence {

        @PrimaryKey
        private UUID id;
        private String name;

        private String location;

        private UUID organisationId;

     private String description;

        private String farmType; // Additional attribute
    
        public FarmAgency(UUID id, String name, String location, UUID organisationId, String farmType) {
            super(id, name, location, organisationId);
            this.farmType = farmType;
        }

    // Additional FarmAgency specific methods can be added here
}