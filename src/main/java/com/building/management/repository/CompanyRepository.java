package com.building.management.repository;

import com.building.management.entity.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CompanyRepository extends CrudRepository<Company,String> {

}
