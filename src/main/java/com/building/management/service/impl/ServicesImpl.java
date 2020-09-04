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

@Service
public class ServicesImpl implements BMService<Services> {
    @Autowired
    private final ServicesRepository servicesRepo;

    public ServicesImpl(ServicesRepository servicesRepo) {
        this.servicesRepo = servicesRepo;
    }

    private static ArrayList<Services> lists = new ArrayList<>();

    @Override
    public Iterable<Services> findAll() {
        ArrayList<Services> listCom = (ArrayList<Services>) servicesRepo.findAll();
        for (Services ser : listCom) {
            lists.add(ser);
        }
        return servicesRepo.findAll();
    }

    @Override
    public Optional<Services> findById(String id) {
        return servicesRepo.findById(id);
    }

    @Override
    public void deleteById(String id) {
        try {
            servicesRepo.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }

    @Override
    public Services save(Services services) {
        return servicesRepo.save(services);
    }

    @Override
    public List<Services> searchByKeyWord(String keyword) {
        List<Services> result = new ArrayList<>();
        for (Services ser : lists) {
            if (ser.getTEN_DV().contains(keyword)) {
                result.add(ser);
            }
        }
        return result;
    }

}
