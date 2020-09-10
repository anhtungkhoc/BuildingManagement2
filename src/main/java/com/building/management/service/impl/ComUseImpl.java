package com.building.management.service.impl;

import com.building.management.entity.CompanyUse;
import com.building.management.repository.ComUseRepository;
import com.building.management.service.BMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //Danh dau day la 1 service de khi goij BMService thi Spring tra ve
public class ComUseImpl implements BMService<CompanyUse> {
    @Autowired //Goi repository de thuc hien cac chuc nang cua JPA Hibernate
    private final ComUseRepository comUseRepo;

    public ComUseImpl(ComUseRepository comUseRepo) {
        this.comUseRepo = comUseRepo;
    }

    @Override //Thuc hien viec lay danh sach model
    public Iterable<CompanyUse> findAll() {
        return comUseRepo.findAll();
    }

    @Override //Thuc hien viec lay thong tin model theo ID
    public Optional<CompanyUse> findById(String id) {
        return comUseRepo.findById(Integer.parseInt(id));
    }

    @Override //Thuc hien xoa model theo ID
    public void deleteById(String id) {
    }

    @Override //Thuc hien viec luu 1 model
    public CompanyUse save(CompanyUse company) {
        return null;
    }

    @Override //Thuc hien viec tim kiem 1 model theo keyword do nguoi dung nhap vao
    public List<CompanyUse> searchByKeyWord(String keyword) {
        return null;
    }

}
