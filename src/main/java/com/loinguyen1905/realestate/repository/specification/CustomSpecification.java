package com.loinguyen1905.realestate.repository.specification;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.util.Pair;

import com.loinguyen1905.realestate.entity.PermissionEntity;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import lombok.val;

public class CustomSpecification<T> {

    private CustomSpecification() {}

    public static <T, F> Join<T, F> joinTable(Class<F> cls, String tableName, Root<T> root) {
        Join<T, F> joining = root.join(tableName);
        return joining;
    }

    public static <T> Specification<T> isValueLike(String stringLike, String col, Pair<Class<?>, String> tableJoin) {
        return (root, query, builder) -> builder.like(
            (tableJoin != null ? joinTable(tableJoin.getFirst(), tableJoin.getSecond(), root) : root)
            .get(col), "%" + stringLike + "%");
    }

    public static <T> Specification<T> isWithinValueRange(int min, int max, String col, Pair<Class<?>, String> tableJoin) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.between(
            (tableJoin != null ? joinTable(tableJoin.getFirst(), tableJoin.getSecond(), root) : root)
            .get(col), min, max);
    }

    public static <T> Specification<T> isEqualValue(int value, String col, Pair<Class<?>, String> tableJoin) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(
            (tableJoin != null ? joinTable(tableJoin.getFirst(), tableJoin.getSecond(), root) : root)
            .get(col), value);
    }
    
    public static <T> Specification<T> isGreaterThanOrEqual(int value, String col, Pair<Class<?>, String> tableJoin) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(
            (tableJoin != null ? joinTable(tableJoin.getFirst(), tableJoin.getSecond(), root) : root)
            .get(col), value);
    }

    public static <T> Specification<T> isLessThanOrEqual(int value, String col, Pair<Class<?>, String> tableJoin) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(
            (tableJoin != null ? joinTable(tableJoin.getFirst(), tableJoin.getSecond(), root) : root)
            .get(col), value);
    }

    public static <T, F> Specification<T> isInList(List<String> list, String col, Pair<Class<?>, String> tableJoin) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.in(
            (tableJoin != null ? joinTable(tableJoin.getFirst(), tableJoin.getSecond(), root) : root)
            .get(col)
        );
    }
    /*
        Second request parameter filter: Get PermissionEntitys that have doctors with a specific speciality.
        This will require us to first join the PermissionEntity and doctor tables (OneToMany), and then applying the filter.
        To do this One to Many join (one PermissionEntity has many doctors), we need to use the Join criteria to accomplish it
     */

    // public static Specification<PermissionEntity> hasDoctorInSpeciality(String speciality) {
    //     return (root, query, builder) -> {
    //         Join<Doctor,PermissionEntity> PermissionEntityDoctors = root.join("doctors");
    //         return builder.equal(PermissionEntityDoctors.get("speciality"), speciality);
    //     };
    // } 
    // Third request parameter filter: Get PermissionEntitys in one of the specified cities
}