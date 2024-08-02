package com.loinguyen1905.realestate.configuration;

import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.loinguyen1905.realestate.entity.CityEntity;
import com.loinguyen1905.realestate.entity.DistrictEntity;
import com.loinguyen1905.realestate.entity.PermissionEntity;
import com.loinguyen1905.realestate.entity.RoleEntity;
import com.loinguyen1905.realestate.repository.CityRepository;
import com.loinguyen1905.realestate.repository.DistrictRepository;
import com.loinguyen1905.realestate.repository.PermissionRepository;
import com.loinguyen1905.realestate.repository.RoleRepository;


@Service
public class DatabaseUnitializer implements CommandLineRunner {
    private final DistrictRepository districtRepository; 
    private final PermissionRepository permissionRepository;

    public DatabaseUnitializer(DistrictRepository districtRepository, PermissionRepository permissionRepository) {
        this.districtRepository = districtRepository;
        this.permissionRepository = permissionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        final DistrictEntity district = new DistrictEntity();
        district.setCode("thu-duc");
        district.setName("Thu Duc");
        district.setCreatedBy("ADMINSTRATOR");
        final CityEntity city = new CityEntity();
        city.setName("Ho Chi Minh");
        city.setCode("ho-chi-minh");
        district.setCity(city);
        districtRepository.save(district);

        final PermissionEntity permission = new PermissionEntity();
        permission.setApiPath("/api/v1/");
        permission.setCode("admin");
        permission.setName("Admin full role");
        permission.setMethod("GET");

        // final PermissionEntity permission2 = new PermissionEntity();
        // permission.setApiPath("/api/v1/buildings");
        // permission.setCode("building");
        // permission.setName("create building");
        // permission.setMethod("POST");

        final RoleEntity role = new RoleEntity();
        role.setCode("admin");
        role.setName("ADMIN");
        role.setPermissions(List.of(permission));
        permission.setRoles(List.of(role));
        // permission2.setRoles(List.of(role));
        this.permissionRepository.save(permission);
        // this.permissionRepository.save(permission2);
    }
}