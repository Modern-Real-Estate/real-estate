package com.loinguyen1905.realestate.repository.custom.impl;

import java.lang.reflect.Field;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.loinguyen1905.realestate.entity.BuildingEntity;
import com.loinguyen1905.realestate.model.request.BuildingSearchRequest;
import com.loinguyen1905.realestate.repository.custom.BuildingRepositoryCustom;

import jakarta.persistence.*;

@Primary
@Repository
public class BuildingRepositoryCustomImpl implements BuildingRepositoryCustom  {
    
    @Autowired
    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;

    public static Boolean excludeFieldNameSpecial(String fieldName) {
        return 
            fieldName.equals("staffId") || 
            fieldName.equals("typeCode") || 
            fieldName.startsWith("area") || 
            fieldName.startsWith("rentPrice");
    }

    public static String toSqlSubStatement(Field field, BuildingSearchRequest buildingSearchRequest) {
        String result = "";
        try {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object x = field.get(buildingSearchRequest);
            if(x == null || !excludeFieldNameSpecial(fieldName)) result = "";
            else if(x.getClass().getName().equals("java.lang.String")) result = " or b." + field.getName() + " like '%" + x.toString() + "%' "; 
            else result = " or b." + field.getName() + " = " + x.toString() + ' ';
        } catch (Exception e) { 
            e.printStackTrace();
        }
        return result;
    }

    public static void queryNormal(StringBuilder sql, BuildingSearchRequest buildingSearchRequest) {
        Field[] fields = buildingSearchRequest.getClass().getDeclaredFields();
        String newTemplete = Arrays.asList(fields).stream().map(item -> toSqlSubStatement(item, buildingSearchRequest)).collect(Collectors.joining(""));
        sql.append(newTemplete);
    }

    public static String joinTable(BuildingSearchRequest buildingSearchRequest) {
        StringBuilder sql = new StringBuilder("select * from building ");
        if(buildingSearchRequest.getAreaFrom() != null || buildingSearchRequest.getAreaTo() != null) sql.append(" right join rent_area on rent_area.building_id = building.id");
        if(buildingSearchRequest.getDistrictId() != null) sql.append(" inner join district on building.id = district.building_id ");
        // if()
        return sql.toString();
    }

    public static void querySpecial(StringBuilder s, BuildingSearchRequest buildingSearchRequest) {
        // if(buildingSearchRequest.getRentPriceFrom() != null || buildingSearchRequest.getRentPriceTo() != null) sql
    }

    @Override
    @Transactional
    public List<BuildingEntity> findAll(BuildingSearchRequest buildingSearchRequest) {
        StringBuilder sql = new StringBuilder("select p.* from ( " + joinTable(buildingSearchRequest) + " ) as p where 1 = 1 ");
        queryNormal(sql, buildingSearchRequest);
        querySpecial(sql, buildingSearchRequest);
        Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
        return query.getResultList();
    }
}