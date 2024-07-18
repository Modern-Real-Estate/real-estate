package com.loinguyen1905.realestate.repository.custom.impl;

import java.lang.reflect.Field;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.loinguyen1905.realestate.builder.BuildingSearchBuilder;
import com.loinguyen1905.realestate.entity.BuildingEntity;
import com.loinguyen1905.realestate.repository.custom.BuildingRepositoryCustom;

import jakarta.persistence.*;

@Primary
@Repository
public class BuildingRepositoryCustomImpl implements BuildingRepositoryCustom  {
    
    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;

    public static Boolean fieldNameChecking(String fieldName) {
        return 
            fieldName.equals("staffId") || 
            fieldName.equals("typeCode") || 
            fieldName.startsWith("area") || 
            fieldName.startsWith("rentPrice");
    }

    public static String toSqlStatement(Field field, BuildingSearchBuilder buildingSearchBuilder) {
        String result = "";
        try {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object x = field.get(buildingSearchBuilder);
            if(x == null || !fieldNameChecking(fieldName)) result = "";
            else if(x.getClass().getName().equals("java.lang.String")) result = " or b." + field.getName() + " like '%" + x.toString() + "%' "; 
            else result = " or b." + field.getName() + " = " + x.toString() + ' ';
        } catch (Exception e) { 
            e.printStackTrace();
        }
        return result;
    }

    public static void queryNormal(StringBuilder sql, BuildingSearchBuilder buildingSearchBuilder) {
        Field[] fields = buildingSearchBuilder.getClass().getDeclaredFields();
        String newTemplete = Arrays.asList(fields).stream().map(item -> toSqlStatement(item, buildingSearchBuilder)).collect(Collectors.joining(""));
        sql.append(newTemplete);
    }

    public static void joinTable(StringBuilder sql, BuildingSearchBuilder buildingSearchBuilder) {

    }

    public static void querySpecial(StringBuilder s, BuildingSearchBuilder buildingSearchBuilder) {

    }

    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public List<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder) {
        StringBuilder sql = new StringBuilder("select b.* from building as b where 1 = 1");
        queryNormal(sql, buildingSearchBuilder);
        joinTable(sql, buildingSearchBuilder);
        querySpecial(sql, buildingSearchBuilder);
        Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
        return query.getResultList();
    }
}