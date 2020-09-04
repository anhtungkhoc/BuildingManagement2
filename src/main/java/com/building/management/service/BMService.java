package com.building.management.service;

import com.building.management.entity.Company;
import com.building.management.repository.BMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BMService<T>{
    public Iterable<T> findAll();
    public Optional<T> findById(String id);
    public void deleteById(String id);
    public T save(T t);
    public List<T> searchByKeyWord(String keyword);
}
