package com.building.management.service.impl;

import com.building.management.entity.CompanyMember;
import com.building.management.repository.ComMemRepository;
import com.building.management.service.BMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ComMemImpl implements BMService<CompanyMember> {
    @Autowired
    private final ComMemRepository comMemRepo;

    public ComMemImpl(ComMemRepository comMemRepo) {
        this.comMemRepo = comMemRepo;
    }

    private static ArrayList<CompanyMember> lists = new ArrayList<>();

    @Override
    public Iterable<CompanyMember> findAll() {
        ArrayList<CompanyMember> listCom = (ArrayList<CompanyMember>) comMemRepo.findAll();
        for (CompanyMember ser : listCom) {
            lists.add(ser);
        }
        return comMemRepo.findAll();
    }

    @Override
    public Optional<CompanyMember> findById(String id) {
        return comMemRepo.findById(id);
    }

    @Override
    public void deleteById(String id) {
        try {
            comMemRepo.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }

    @Override
    public CompanyMember save(CompanyMember comMem) {
        return comMemRepo.save(comMem);
    }

    @Override
    public List<CompanyMember> searchByKeyWord(String keyword) {
        List<CompanyMember> result = new ArrayList<>();
        for (CompanyMember ser : lists) {
            if (ser.getTEN().contains(keyword)) {
                result.add(ser);
            }
        }
        return result;
    }

}
