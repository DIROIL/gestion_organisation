package com.yowyob.gestion_agence.application.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AgenceResponse {
    private UUID id;
    private String name;
    private String description;
    private boolean transferable;
    //private List<ImageDto> images;
}