package com.loinguyen1905.realestate.service;

import java.util.List;
import java.util.UUID;

import com.loinguyen1905.realestate.model.dto.RentAreaDTO;

public interface IRentAreaService {
    List<RentAreaDTO> handleGetRentAreaByIds(List<UUID> ids);

    public RentAreaDTO handleAddRentArea(RentAreaDTO rentAreaDTO);
}