package com.loinguyen1905.realestate.converter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.loinguyen1905.realestate.entity.PermissionEntity;
import com.loinguyen1905.realestate.model.request.PermissionSearchRequest;
import com.loinguyen1905.realestate.repository.specification.CustomSpecification;

import io.jsonwebtoken.lang.Arrays;

@Component
public class PermissionConverter {
    public Specification<PermissionEntity> toPermissionSpec(PermissionSearchRequest permissionSearchRequest) {
        Field[] fields = permissionSearchRequest.getClass().getDeclaredFields();
        List<Specification<PermissionEntity>> specList = new ArrayList<>();
        Arrays.asList(fields).forEach(field -> {
            try {
                String fieldName = field.getName();
                field.setAccessible(true);
                Object value = field.get(permissionSearchRequest);
                if(value.getClass().getName().equals("java.lang.String"))
                specList.add(CustomSpecification.isValueLike((String) value, fieldName, null));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return Specification.allOf(specList);
    }
}