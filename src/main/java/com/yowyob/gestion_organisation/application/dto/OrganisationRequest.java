package com.yowyob.gestion_organisation.application.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OrganisationRequest {
    private UUID id;
    private String name;
    private String description;
    private UUID ownerId;
    private UUID domainKey;

    // List<ImageDto> images;
}
