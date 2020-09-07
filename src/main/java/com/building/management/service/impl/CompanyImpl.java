package com.building.management.service.impl;

import com.building.management.entity.Company;
import com.building.management.repository.CompanyRepository;
import com.building.management.service.BMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service //Danh dau day la 1 service de khi goij BMService thi Spring tra ve
public class CompanyImpl implements BMService<Company> {
    @Autowired //Goi repository de thuc hien cac chuc nang cua JPA Hibernate
    private final CompanyRepository companyRepo;

    public CompanyImpl(CompanyRepository companyRepo) {
        this.companyRepo = companyRepo;
    }

    @Override //Thuc hien viec lay danh sach model
    public Iterable<Company> findAll() {
        return companyRepo.findAll();
    }

    @Override //Thuc hien viec lay thong tin model theo ID
    public Optional<Company> findById(String id) {
        return companyRepo.findById(id);
    }

    @Override //Thuc hien xoa model theo ID
    public void deleteById(String id) {
        try {
            companyRepo.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }

    @Override //Thuc hien viec luu 1 model
    public Company save(Company company) {
        return companyRepo.save(company);
    }

    @Override //Thuc hien viec tim kiem 1 model theo keyword do nguoi dung nhap vao
    public List<Company> searchByKeyWord(String keyword) {
        Iterable<Company> lists = companyRepo.findAll();
        List<Company> result = new ArrayList<>();
        for (Company com : lists) {
            if (com.getTEN_CT().contains(keyword.toUpperCase()) || com.getTEN_CT().contains(keyword.toLowerCase())){
                result.add(com);
            }
        }
        return result;
    }

//    public List<String> getListBill(){
//        return companyRepo.listCompayHOA_DON_CTY();
//    }

}
