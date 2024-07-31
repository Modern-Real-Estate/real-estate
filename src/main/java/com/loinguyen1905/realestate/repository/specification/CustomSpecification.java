package com.loinguyen1905.realestate.repository.specification;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.loinguyen1905.realestate.entity.PermissionEntity;

public class CustomSpecification<T> {

    private CustomSpecification() {}

    public static <T> Specification<T> isValueLike(String stringLike, String col) {
        return (root, query, builder) -> builder.like(root.get(col), "%" + stringLike + "%");
    }

    public static <T> Specification<T> isWithinValueRange(int min, int max, String col) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get(col), min, max);
    }

    public static <T> Specification<T> isEqualValue(int value, String col) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(col), value);
    }
    
    public static <T> Specification<T> isGreaterThanOrEqual(int value, String col) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get(col), value);
    }

    public static <T> Specification<T> isLessThanOrEqual(int value, String col) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get(col), value);
    }

    // public static <T> Specification<T> isLessThanOrEqual(int value, String col) {
    //     return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get(col), value);
    // }

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
    public static Specification<PermissionEntity> isIn(List<String> cities, String col) {
        return (root, query, builder) -> root.get(col).in(cities);
    }
}