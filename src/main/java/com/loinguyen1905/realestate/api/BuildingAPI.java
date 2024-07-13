package com.loinguyen1905.realestate.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.loinguyen1905.realestate.model.dto.BuildingDTO;
import com.loinguyen1905.realestate.service.BuildingService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class BuildingAPI {

    @Autowired
    private BuildingService buildingService;

    @GetMapping("/api/buildings/")
    public List<BuildingDTO> getAllBuilding(
        @RequestParam(required = false) Map<String, Object> params, 
        @RequestParam(name = "typeCode", required = false) List<String> typeCode
    ) {
        return buildingService.findAll(params, typeCode);
    }

    @PostMapping("/api/buildings/")
    public List<BuildingDTO> createBuilding() {
        return null;
    }
    
    @PatchMapping("/api/buildings/")
    public List<BuildingDTO> updateBuilding() {
        return null;
    }
    @DeleteMapping("/api/buildings/")
    public List<BuildingDTO> deleteBuilding() {
        return null;
    }
}
