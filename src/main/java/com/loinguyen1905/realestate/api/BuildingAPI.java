package com.loinguyen1905.realestate.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RestController;

import com.loinguyen1905.realestate.model.dto.BuildingDTO;
import com.loinguyen1905.realestate.model.dto.BuildingRequestDTO;
import com.loinguyen1905.realestate.service.BuildingService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class BuildingAPI {

    @Autowired
    private BuildingService buildingService;

    @GetMapping("/api/buildings/")
    public List<BuildingDTO> getBuilding(
        @RequestParam(required = false) Map<String, Object> params, 
        @RequestParam(name = "typeCode", required = false) List<String> typeCode
    ) {
        return buildingService.findAll(params, typeCode);
    }

    @GetMapping("/api/buildings/{id}")
    public BuildingDTO getBuildingById(
        @PathVariable(required = true) Long id
    ) {
        return buildingService.findBuildingById(id);
    }

    @PostMapping("/api/buildings/")
    public BuildingDTO createBuilding(
        @RequestBody BuildingRequestDTO buildingRequestDTO
    ) {
        return buildingService.createBuilding(buildingRequestDTO);
    }
    
    @PatchMapping("/api/buildings/")
    public List<BuildingDTO> updateBuilding() {
        return null;
    }
    @DeleteMapping("/api/buildings/{ids}")
    public Boolean deleteBuildingById(
        @PathVariable(required = true) List<Long> ids
    ) {
        return buildingService.deleteBuildingsByIds(ids);
    }
}
