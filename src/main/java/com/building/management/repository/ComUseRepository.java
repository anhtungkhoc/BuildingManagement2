package com.building.management.repository;

import com.building.management.entity.CompanyUse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComUseRepository extends CrudRepository<CompanyUse, Integer>{
}