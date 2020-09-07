package com.building.management.repository;


import com.building.management.entity.InOut;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InOutRepository extends CrudRepository<InOut, String> {

}
