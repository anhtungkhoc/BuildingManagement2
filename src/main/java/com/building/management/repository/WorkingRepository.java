package com.building.management.repository;

import com.building.management.entity.Working;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkingRepository extends CrudRepository<Working, Integer> {
}
