package com.loinguyen1905.realestate.service;

import java.util.List;

import com.loinguyen1905.realestate.model.dto.BuildingDTO;

public interface BuildingService {
    List<BuildingDTO> findAll();
}