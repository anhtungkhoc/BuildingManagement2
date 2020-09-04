package com.building.management.repository;


import com.building.management.entity.BuildingMember;
import org.springframework.data.repository.CrudRepository;

public interface BuiMemRepository extends CrudRepository<BuildingMember, String> {

}
