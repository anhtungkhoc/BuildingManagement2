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

@Service
public class CompanyImpl implements BMService<Company> {
    @Autowired
    private final CompanyRepository companyRepo;

    public CompanyImpl(CompanyRepository companyRepo) {
        this.companyRepo = companyRepo;
    }

    private static ArrayList<Company> lists = new ArrayList<>();

    @Override
    public Iterable<Company> findAll() {
        ArrayList<Company> listCom = (ArrayList<Company>) companyRepo.findAll();
        for (Company com: listCom) {
            lists.add(com);
        }
        return companyRepo.findAll();
    }

    @Override
    public Optional<Company> findById(String id) {
        return companyRepo.findById(id);
    }

    @Override
    public void deleteById(String id) {
        try {
            companyRepo.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }

    @Override
    public Company save(Company company) {
        return companyRepo.save(company);
    }

    @Override
    public List<Company> searchByKeyWord(String keyword) {
        List<Company> result = new ArrayList<>();
        for (Company com : lists) {
            if (com.getTEN_CT().contains(keyword)){
                result.add(com);
            }
        }
        return result;
    }

}
