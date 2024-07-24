package com.loinguyen1905.realestate.service;

import com.loinguyen1905.realestate.model.dto.CityDTO;
import com.loinguyen1905.realestate.model.dto.DistrictDTO;

public interface ICityService {
    DistrictDTO handleAddCity(CityDTO cityDTO);
}