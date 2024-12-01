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
public class OrganisationResponse {
    private UUID id;
    private String name;
    private String description;
    private UUID ownerId;

    //private List<ImageDto> images;
}
