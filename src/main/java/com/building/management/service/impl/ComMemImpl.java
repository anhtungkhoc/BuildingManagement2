package com.building.management.service.impl;

import com.building.management.entity.ComMemSalary;
import com.building.management.entity.CompanyMember;
import com.building.management.repository.ComMemRepository;
import com.building.management.repository.ComMemSalRepository;
import com.building.management.service.BMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service //Danh dau day la 1 service de khi goij BMService thi Spring tra ve
public class ComMemImpl implements BMService<CompanyMember> {
    @Autowired //Goi repository de thuc hien cac chuc nang cua JPA Hibernate
    private final ComMemRepository comMemRepo;

    @Autowired
    private ComMemSalRepository comMemSalRepository;

    public ComMemImpl(ComMemRepository comMemRepo) {
        this.comMemRepo = comMemRepo;
    }

    @Override //Thuc hien viec lay danh sach model
    public Iterable<CompanyMember> findAll() {
        return comMemRepo.findAll();
    }

    @Override //Thuc hien viec lay thong tin model theo ID
    public Optional<CompanyMember> findById(String id) {
        return comMemRepo.findById(id);
    }

    @Override //Thuc hien xoa model theo ID
    public void deleteById(String id) {
        try {
            comMemRepo.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }

    @Override //Thuc hien viec luu 1 model
    public CompanyMember save(CompanyMember comMem) {
        return comMemRepo.save(comMem);
    }

    @Override //Thuc hien viec tim kiem 1 model theo keyword do nguoi dung nhap vao
    public List<CompanyMember> searchByKeyWord(String keyword) {
        Iterable<CompanyMember> lists = comMemRepo.findAll();
        List<CompanyMember> result = new ArrayList<>();
        for (CompanyMember ser : lists) {
            if (ser.getTEN().contains(keyword.toUpperCase()) || ser.getTEN().contains(keyword.toLowerCase())) {
                result.add(ser);
            }
        }
        return result;
    }

    //Lay ra list nhan vien cong ty cu the
    public List<CompanyMember> searchListComMemByIDCompany(String maCT) {
        Iterable<CompanyMember> lists = comMemRepo.findAll();
        List<CompanyMember> result = new ArrayList<>();
        for (CompanyMember ser : lists) {
            if (ser.getMA_CT().equals(maCT.toUpperCase()) || ser.getMA_CT().equals(maCT.toLowerCase())) {
                result.add(ser);
            }
        }
        return result;
    }

    // Lay thong tin bill company by date
    public List<ComMemSalary> getCompanyMemberByDate(String ngayBD, String ngayKT, String maNV){
        return comMemSalRepository.getCompanyMemberByDate(ngayBD,ngayKT,maNV);
    }

}
