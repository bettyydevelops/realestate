package com.example.realestate.realestate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface RealEstateRepository extends JpaRepository<RealEstate, Long>, JpaSpecificationExecutor<RealEstate> {

  default List<RealEstate> findByCriteria(RealEstateQuery realEstateQuery) {
    Specification<RealEstate> specification = Specification.where(equalIfNotNull(realEstateQuery.city, "city"))
        .and(equalIfNotNull(realEstateQuery.district, "district"))
        .and(equalIfNotNull(realEstateQuery.type, "type"))
        .and(equalIfNotNull(realEstateQuery.meterSquare, "meterSquare"))
        .and(equalIfNotNull(realEstateQuery.roomCount, "roomCount"))
        .and(equalIfNotNull(realEstateQuery.flatFloor, "flatFloor"))
        .and(equalIfNotNull(realEstateQuery.buildingFloorCount, "buildingFloorCount"))
        .and(equalIfNotNull(realEstateQuery.forSale, "forSale"));

    return findAll(specification);
  }

  default Specification<RealEstate> equalIfNotNull(Object value, String fieldPath) {
    if(value == null)
      return null;
    return (root, query, criteriaBuilder) ->
        criteriaBuilder.in(root.get(fieldPath)).value(value);
  }

}