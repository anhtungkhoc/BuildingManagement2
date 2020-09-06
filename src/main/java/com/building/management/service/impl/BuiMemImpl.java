package com.building.management.service.impl;

import com.building.management.entity.BuildingMember;
import com.building.management.repository.BuiMemRepository;
import com.building.management.service.BMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service //Danh dau day la 1 service de khi goij BMService thi Spring tra ve
public class BuiMemImpl implements BMService<BuildingMember> {
    @Autowired //Goi repository de thuc hien cac chuc nang cua JPA Hibernate
    private final BuiMemRepository buiMemRepo;

    public BuiMemImpl(BuiMemRepository buiMemRepo) {
        this.buiMemRepo = buiMemRepo;
    }

    @Override //Thuc hien viec lay danh sach model
    public Iterable<BuildingMember> findAll() {
        return buiMemRepo.findAll();
    }

    @Override //Thuc hien viec lay thong tin model theo ID
    public Optional<BuildingMember> findById(String id) {
        return buiMemRepo.findById(id);
    }

    @Override //Thuc hien xoa model theo ID
    public void deleteById(String id) {
        try {
            buiMemRepo.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }

    @Override //Thuc hien viec luu 1 model
    public BuildingMember save(BuildingMember buiMem) {
        return buiMemRepo.save(buiMem);
    }

    @Override //Thuc hien viec tim kiem 1 model theo keyword do nguoi dung nhap vao
    public List<BuildingMember> searchByKeyWord(String keyword) {
        Iterable<BuildingMember> lists = buiMemRepo.findAll();
        List<BuildingMember> result = new ArrayList<>();
        for (BuildingMember bm : lists) {
            if (bm.getTEN().contains(keyword.toUpperCase()) || bm.getTEN().contains(keyword.toLowerCase())) {
                result.add(bm);
            }
        }
        return result;
    }


}
