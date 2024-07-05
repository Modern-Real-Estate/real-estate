package com.loinguyen1905.realestate.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.loinguyen1905.realestate.entity.BuildingEntity;
import com.loinguyen1905.realestate.repository.BuildingRepository;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<BuildingEntity> findAll() {
        String sql = "SELECT * FROM building WHERE 1 = 1";
        List<BuildingEntity> listBuildings = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(BuildingEntity.class));
        return listBuildings;
    }
    
}