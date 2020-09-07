package com.building.management.service.impl;

import com.building.management.entity.Working;
import com.building.management.repository.WorkingRepository;
import com.building.management.service.BMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service //Danh dau day la 1 service de khi goij BMService thi Spring tra ve
public class WorkingImpl implements BMService<Working> {
    @Autowired //Goi repository de thuc hien cac chuc nang cua JPA Hibernate
    private final WorkingRepository workingRepo;

    public WorkingImpl(WorkingRepository workingRepo) {
        this.workingRepo = workingRepo;
    }

    @Override //Thuc hien viec lay danh sach model
    public Iterable<Working> findAll() {
        return workingRepo.findAll();
    }

    @Override //Thuc hien viec lay thong tin model theo ID
    public Optional<Working> findById(String id) {
        return workingRepo.findById(Integer.parseInt(id));
    }

    @Override //Thuc hien xoa model theo ID
    public void deleteById(String id) {
        try {
            workingRepo.deleteById(Integer.parseInt(id));
        } catch (EmptyResultDataAccessException e) {
        }
    }

    @Override //Thuc hien viec luu 1 model
    public Working save(Working company) {
        return workingRepo.save(company);
    }

    @Override //Thuc hien viec tim kiem 1 model theo keyword do nguoi dung nhap vao
    public List<Working> searchByKeyWord(String keyword) {
        Iterable<Working> lists = workingRepo.findAll();
        List<Working> result = new ArrayList<>();
        for (Working com : lists) {
            if (com.getMA_NV().contains(keyword.toUpperCase()) || com.getMA_NV().contains(keyword.toLowerCase())){
                result.add(com);
            }
        }
        return result;
    }
}
