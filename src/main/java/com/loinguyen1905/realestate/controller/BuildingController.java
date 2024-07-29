package com.loinguyen1905.realestate.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.loinguyen1905.realestate.common.SystemConstant;
import com.loinguyen1905.realestate.model.dto.BuildingDTO;
import com.loinguyen1905.realestate.model.request.BuildingRequest;
import com.loinguyen1905.realestate.model.request.BuildingSearchRequest;
import com.loinguyen1905.realestate.service.IBuildingService;
import com.loinguyen1905.realestate.util.annotation.MetaMessage;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("${release.api.prefix}/buildings")
public class BuildingController {
    @Autowired
    private IBuildingService buildingService;

    @GetMapping
    @MetaMessage(message = "Fetch buildings with filter and pageable")
    public ResponseEntity<List<BuildingDTO>> getBuilding(
        @ModelAttribute(SystemConstant.MODEL)
        BuildingSearchRequest buildingSearchRequest
    ) {
        return ResponseEntity.ok().body(buildingService.handleGetBuildings(buildingSearchRequest));
    }

    @GetMapping("/{id}")
    @MetaMessage(message = "Fetch building with id")
    public ResponseEntity<BuildingDTO> getBuildingById(@PathVariable(required = true) UUID id) {
        return ResponseEntity.ok().body(buildingService.handleGetBuildingById(id));
    }

    @PostMapping
    @MetaMessage(message = "Add new building")
    public ResponseEntity<BuildingDTO> addBuilding(@RequestBody BuildingRequest buildingRequest) {
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(buildingService.handleAddOrUpdateBuilding(buildingRequest));
    }
    
    @PutMapping
    @MetaMessage(message = "Update building with new data")
    public ResponseEntity<BuildingDTO> updateBuilding(@RequestBody BuildingRequest buildingRequest) {
        return ResponseEntity.ok().body(buildingService.handleAddOrUpdateBuilding(buildingRequest));
    }

    @DeleteMapping("/{ids}")
    @MetaMessage(message = "Delete buildings with ids[]")
    public ResponseEntity<Void> deleteBuildingById(
        @PathVariable(required = true) List<UUID> ids
    ) {
        buildingService.handleDeleteBuildingByIds(ids);
        return ResponseEntity.noContent().build();
    }

    // ADMIN END-POINT

    // @GetMapping("/admin/building")
    // public String buildingList(@RequestParam String param) {
    //     return new String();
    // }
    
    // @GetMapping("/admin/building-edit")
    // public String buildingEdit(@RequestParam String param) {
    //     return new String();    
    // }
}