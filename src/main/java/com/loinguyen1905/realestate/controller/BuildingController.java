package com.loinguyen1905.realestate.controller;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.loinguyen1905.realestate.common.SystemConstant;
import com.loinguyen1905.realestate.model.dto.BuildingDTO;
import com.loinguyen1905.realestate.model.request.BuildingRequest;
import com.loinguyen1905.realestate.model.request.BuildingSearchRequest;
import com.loinguyen1905.realestate.service.IBuildingService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/buildings")
public class BuildingController {
    @Autowired
    private IBuildingService buildingService;

    @GetMapping("/")
    public ResponseEntity<List<BuildingDTO>> getBuilding(@ModelAttribute(SystemConstant.MODEL) BuildingSearchRequest buildingSearchRequest) {
        return ResponseEntity.ok().body(buildingService.handleGetBuildings(buildingSearchRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BuildingDTO> getBuildingById(@PathVariable(required = true) UUID id) {
        return ResponseEntity.ok().body(buildingService.handleGetBuildingById(id));
    }

    @PostMapping("/")
    public BuildingDTO createBuilding(@RequestBody BuildingRequest buildingRequest) {
        return buildingService.handleAddBuilding(buildingRequest);
    }
    
    @PutMapping("/")
    public ResponseEntity<BuildingDTO> updateBuilding(@Valid @RequestBody BuildingRequest buildingRequest) {
        return ResponseEntity.ok().body(buildingService.handleUpdateBuilding(buildingRequest));
    }

    @DeleteMapping("/{ids}")
    public Boolean deleteBuildingById(
        @PathVariable(required = true) List<UUID> ids
    ) {
        return buildingService.handleDeleteBuildingByIds(ids);
    }

    // ADMIN END-POINT

    @GetMapping("/admin/building")
    public String buildingList(@RequestParam String param) {
        return new String();
    }
    
    @GetMapping("/admin/building-edit")
    public String buildingEdit(@RequestParam String param) {
        return new String();    
    }
}