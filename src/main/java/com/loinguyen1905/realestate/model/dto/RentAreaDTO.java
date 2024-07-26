package com.loinguyen1905.realestate.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RentAreaDTO extends AbstractDTO<RentAreaDTO> {
    @NotBlank(message = "Rent area of this building not blank")
    private String value;
}