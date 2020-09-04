package com.building.management.repository;


import com.building.management.entity.CompanyMember;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComMemRepository extends CrudRepository<CompanyMember, String> {

}
