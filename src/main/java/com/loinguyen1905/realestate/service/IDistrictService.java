package com.loinguyen1905.realestate.service;

import java.util.List;
import java.util.UUID;

import com.loinguyen1905.realestate.model.dto.DistrictDTO;

public interface IDistrictService {
    DistrictDTO handleAddDistrict(DistrictDTO districtDTO);
    DistrictDTO handleFindDistrictById(UUID id);
    List<DistrictDTO> handleGetAllDistrict();
}