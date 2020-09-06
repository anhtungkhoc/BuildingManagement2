package com.building.management.service.impl;

import com.building.management.entity.CompanyBill;
import com.building.management.repository.ComBillRepository;
import com.building.management.service.BMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //Danh dau day la 1 service de khi goij BMService thi Spring tra ve
public class ComBillImpl implements BMService<CompanyBill> {
    @Autowired //Goi repository de thuc hien cac chuc nang cua JPA Hibernate
    private final ComBillRepository companyRepo;

    public ComBillImpl(ComBillRepository companyRepo) {
        this.companyRepo = companyRepo;
    }

    @Override //Thuc hien viec lay danh sach model
    public Iterable<CompanyBill> findAll() {
        return companyRepo.findAll();
    }

    @Override //Thuc hien viec lay thong tin model theo ID
    public Optional<CompanyBill> findById(String id) {
        return companyRepo.findById(id);
    }

    @Override //Thuc hien xoa model theo ID
    public void deleteById(String id) {
    }

    @Override //Thuc hien viec luu 1 model
    public CompanyBill save(CompanyBill company) {
        return null;
    }

    @Override //Thuc hien viec tim kiem 1 model theo keyword do nguoi dung nhap vao
    public List<CompanyBill> searchByKeyWord(String keyword) {
        return null;
    }

//    public List<String> getListBill(){
//        return companyRepo.listCompayHOA_DON_CTY();
//    }

}
