package com.building.management.service;

import java.util.List;
import java.util.Optional;

//Su dung Generic de tao mau thiet ke cho BUilding management
public interface BMService<T>{
    public Iterable<T> findAll();
    public Optional<T> findById(String id);
    public void deleteById(String id);
    public T save(T t);
    public List<T> searchByKeyWord(String keyword);
}
