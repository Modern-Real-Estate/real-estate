package com.loinguyen1905.realestate.configuration;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.loinguyen1905.realestate.entity.CityEntity;
import com.loinguyen1905.realestate.entity.DistrictEntity;
import com.loinguyen1905.realestate.repository.CityRepository;
import com.loinguyen1905.realestate.repository.DistrictRepository;


@Component
public class InitialDataConfiguration implements ApplicationRunner {
    private final DistrictRepository districtRepository; 

    public InitialDataConfiguration(DistrictRepository districtRepository, CityRepository cityRepository) {
        this.districtRepository = districtRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // final DistrictEntity district = new DistrictEntity();
        // district.setCode("thu-duc");
        // district.setName("Thu Duc");
        // district.setCreatedBy("ADMINSTRATOR");
        // final CityEntity city = new CityEntity();
        // city.setName("Ho Chi Minh");
        // city.setCode("ho-chi-minh");
        // district.setCity(city);
        // districtRepository.save(district);
    }
}