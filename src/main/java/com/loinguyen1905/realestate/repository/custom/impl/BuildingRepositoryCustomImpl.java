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

@Repository
@Primary
public class BuildingRepositoryCustomImpl implements BuildingRepositoryCustom  {
    
    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;

    public static String conditionToString(Field field, BuildingSearchBuilder buildingSearchBuilder) {
        String result = "";
        try {
            field.setAccessible(true);
            Object x = field.get(buildingSearchBuilder);
            if(x == null) result = "";
            else if(x.getClass().getName().equals("java.lang.String")) result = " or b." + field.getName() + " like '%" + x.toString() + "%' "; 
            else result = " or b." + field.getName() + " = " + x.toString(); 
        } catch (IllegalArgumentException | IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public static void queryNormal(StringBuilder s, BuildingSearchBuilder buildingSearchBuilder) {
        Field[] fields = buildingSearchBuilder.getClass().getDeclaredFields();
        String newTemplete = Arrays.asList(fields).stream().map(item -> conditionToString(item, buildingSearchBuilder)).collect(Collectors.joining(" "));
        s.append(newTemplete);
    }

    public static void queryEnhance(StringBuilder s, BuildingSearchBuilder buildingSearchBuilder) {

    }

    @Override
    @Transactional
    public List<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder) {
        StringBuilder sql = new StringBuilder("select b.* from building as b where 1 = 1");
        queryNormal(sql, buildingSearchBuilder);
        Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
        return query.getResultList();
    }
}