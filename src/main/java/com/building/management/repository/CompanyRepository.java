package com.building.management.repository;

import com.building.management.entity.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CompanyRepository extends CrudRepository<Company, String> {
    @Query(value = NativeSQL.HOA_DON_CTY, nativeQuery = true)
    List<String> listCompayHOA_DON_CTY();

}
