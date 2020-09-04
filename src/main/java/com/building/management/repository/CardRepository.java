package com.building.management.repository;


import com.building.management.entity.Card;
import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends CrudRepository<Card, String> {

}
