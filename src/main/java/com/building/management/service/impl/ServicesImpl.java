package com.building.management.service.impl;

import com.building.management.entity.Services;
import com.building.management.repository.ServicesRepository;
import com.building.management.service.BMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service//Danh dau day la 1 service de khi goij BMService thi Spring tra ve
public class ServicesImpl implements BMService<Services> {
    @Autowired //Goi repository de thuc hien cac chuc nang cua JPA Hibernate
    private ServicesRepository servicesRepo;

    public ServicesImpl(ServicesRepository servicesRepo) {
        this.servicesRepo = servicesRepo;
    }

    @Override //Thuc hien viec lay danh sach model
    public Iterable<Services> findAll() {
        return servicesRepo.findAll();
    }

    @Override //Thuc hien viec lay thong tin model theo ID
    public Optional<Services> findById(String id) {
        return servicesRepo.findById(id);
    }

    @Override //Thuc hien xoa model theo ID
    public void deleteById(String id) {
        try {
            servicesRepo.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }

    @Override //Thuc hien viec luu 1 model
    public Services save(Services services) {
        return servicesRepo.save(services);
    }

    @Override //Thuc hien viec tim kiem 1 model theo keyword do nguoi dung nhap vao
    public List<Services> searchByKeyWord(String keyword) {
        Iterable<Services> lists = servicesRepo.findAll();
        List<Services> result = new ArrayList<>();
        for (Services ser : lists) {
            if (ser.getTEN_DV().contains(keyword.toUpperCase()) || ser.getTEN_DV().contains(keyword.toLowerCase())) {
                result.add(ser);
            }
        }
        return result;
    }

}
