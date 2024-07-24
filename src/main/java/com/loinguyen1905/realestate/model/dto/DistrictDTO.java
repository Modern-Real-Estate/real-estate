package com.loinguyen1905.realestate.model.dto;

import java.util.UUID;

import lombok.*;

@Setter
@Getter
@Builder
public class DistrictDTO extends AbstractDTO<DistrictDTO> {
    private UUID id;
    private String name;
    private String code;
}