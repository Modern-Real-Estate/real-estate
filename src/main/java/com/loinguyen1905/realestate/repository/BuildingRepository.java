package com.loinguyen1905.realestate.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.loinguyen1905.realestate.entity.BuildingEntity;
import com.loinguyen1905.realestate.repository.custom.BuildingRepositoryCustom;

@Repository
public interface BuildingRepository extends JpaRepository<BuildingEntity, UUID>, BuildingRepositoryCustom, JpaSpecificationExecutor<BuildingEntity> {
    Void deleteByIdIn(List<UUID> ids);
    Page<BuildingEntity> findAll(Specification<BuildingEntity> specification, Pageable pageable);
    String findTopNBuildingRatingSQL = """
        select j.*, rank() over(partition by j.id order by j.rating desc) as ranking from (
            select building.*, round(avg(r.value), 2) as rating from building as b 
            inner join review as r on b.id = r.building_id
            group by b.id
        ) as j
        where ranking >= ?1;
    """;
    @Query(value = findTopNBuildingRatingSQL, nativeQuery = true)
    List<BuildingEntity> findTopNBuildingRating(Integer n);
}