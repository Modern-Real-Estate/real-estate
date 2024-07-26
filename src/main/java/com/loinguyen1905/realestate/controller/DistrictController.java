package com.loinguyen1905.realestate.controller;

import org.springframework.web.bind.annotation.RestController;

import com.loinguyen1905.realestate.model.dto.DistrictDTO;
import com.loinguyen1905.realestate.service.IDistrictService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/districts")
public class DistrictController {

    @Autowired
    private IDistrictService districtService;

    @GetMapping("/")
    public ResponseEntity<List<DistrictDTO>> getAll() {
        return ResponseEntity.ok().body(districtService.handleGetAllDistrict());
    }
    
}