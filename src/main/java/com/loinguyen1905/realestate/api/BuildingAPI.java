package com.loinguyen1905.realestate.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.loinguyen1905.realestate.model.dto.BuildingDTO;
import com.loinguyen1905.realestate.service.BuildingService;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class BuildingAPI {
    @Autowired
    private BuildingService buildingService;

    @GetMapping("/api/buildings/")
    public List<BuildingDTO> getMethodName() {
        return buildingService.findAll();
    }
    
}
