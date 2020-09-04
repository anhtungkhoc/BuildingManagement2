package com.building.management.repository;

import org.springframework.data.repository.CrudRepository;

public interface BMRepository<T,ID> extends CrudRepository<T,ID> {
}
