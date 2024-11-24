package com.yowyob.gestion_organisation.domain.model;


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
@Table("Organisation")
public class Organisation {
   @PrimaryKey
    private UUID id;

    private String name;

    private String description;

    private boolean transferable;
}