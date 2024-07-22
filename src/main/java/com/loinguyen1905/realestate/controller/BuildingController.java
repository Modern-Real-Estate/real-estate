package com.loinguyen1905.realestate.controller;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.loinguyen1905.realestate.model.dto.BuildingDTO;
import com.loinguyen1905.realestate.model.dto.BuildingRequestDTO;
import com.loinguyen1905.realestate.service.IBuildingService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/buildings")
public class BuildingController {

    @Autowired
    private IBuildingService buildingService;

    @GetMapping("/")
    public List<BuildingDTO> getBuilding(
        @RequestParam(required = false) Map<String, Object> params, 
        @RequestParam(name = "typeCode", required = false) List<String> typeCode
    ) {
        return buildingService.findAll(params, typeCode);
    }

    @GetMapping("/{id}")
    public BuildingDTO getBuildingById(
        @PathVariable(required = true) UUID id
    ) {
        return buildingService.findBuildingById(id);
    }

    @PostMapping("/")
    public BuildingDTO createBuilding(
        @RequestBody BuildingRequestDTO buildingRequestDTO
    ) {
        return buildingService.addBuilding(buildingRequestDTO);
    }
    
    @PatchMapping("/")
    public List<BuildingDTO> updateBuilding() {
        return null;
    }

    @DeleteMapping("/{ids}")
    public Boolean deleteBuildingById(
        @PathVariable(required = true) List<UUID> ids
    ) {
        return buildingService.deleteBuildingsByIds(ids);
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
