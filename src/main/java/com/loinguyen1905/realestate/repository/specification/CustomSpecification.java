package com.loinguyen1905.realestate.repository.specification;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.util.Pair;
import org.springframework.lang.Nullable;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class CustomSpecification<T> {

    public CustomSpecification() {}

    public static <T, F> Join<T, F> joinTable(Class<F> cls, String tableName, Root<T> root) {
        Join<T, F> joining = root.join(tableName);
        return joining;
    }

    public static <T> Specification<T> construct() {
        return (root, query, builder) -> builder.isNotNull(root.get("id"));
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