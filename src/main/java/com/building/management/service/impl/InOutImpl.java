package com.building.management.service.impl;

import com.building.management.entity.InOut;
import com.building.management.entity.InOutInfo;
import com.building.management.repository.InOutInfoRepository;
import com.building.management.repository.InOutRepository;
import com.building.management.service.BMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service//Danh dau day la 1 service de khi goij BMService thi Spring tra ve
public class InOutImpl implements BMService<InOut> {
    @Autowired //Goi repository de thuc hien cac chuc nang cua JPA Hibernate
    private InOutRepository inOutRepo;

    @Autowired
    private InOutInfoRepository infoRepository;

    public InOutImpl(InOutRepository inOutRepo) {
        this.inOutRepo = inOutRepo;
    }

    @Override //Thuc hien viec lay danh sach model
    public Iterable<InOut> findAll() {
        return inOutRepo.findAll();
    }

    @Override //Thuc hien viec lay thong tin model theo ID
    public Optional<InOut> findById(String id) {
        return inOutRepo.findById(Integer.parseInt(id));
    }

    @Override //Thuc hien xoa model theo ID
    public void deleteById(String id) {
        try {
            inOutRepo.deleteById(Integer.parseInt(id));
        } catch (EmptyResultDataAccessException e) {
        }
    }

    @Override //Thuc hien viec luu 1 model
    public InOut save(InOut inOut) {
        return inOutRepo.save(inOut);
    }

    @Override //Thuc hien viec tim kiem 1 model theo keyword do nguoi dung nhap vao
    public List<InOut> searchByKeyWord(String keyword) {
        Iterable<InOut> lists = inOutRepo.findAll();
        List<InOut> result = new ArrayList<>();
        for (InOut ser : lists) {
            if (ser.getMA_THE().contains(keyword.toUpperCase()) || ser.getMA_THE().contains(keyword.toLowerCase())) {
                result.add(ser);
            }
        }
        return result;
    }
    //Thuc hien lay ra thong tin ra vao cua tung nhan vien trong ngay
    public List<InOutInfo> getInOutInfoByCHECK_TIMEAndMA_NV(String checkTime, String maNV){
        return infoRepository.getInOutInfoByCHECK_TIMEAndMA_NV(checkTime,maNV);
    }
}
