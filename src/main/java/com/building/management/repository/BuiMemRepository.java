package com.building.management.repository;


import com.building.management.entity.BuildingMember;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuiMemRepository extends CrudRepository<BuildingMember, String> {

}
