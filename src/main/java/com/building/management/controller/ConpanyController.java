package com.building.management.controller;

import com.building.management.entity.Company;
import com.building.management.service.BMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/company", produces = "application/json")
@CrossOrigin(origins = "*")
public class ConpanyController {


    @Autowired
    private BMService<Company> comService;

    public ConpanyController(BMService<Company> comService) {
        this.comService = comService;
    }

    @GetMapping("/all")
    public Iterable<Company> getListCompany(){
        return comService.findAll();
    }

    @GetMapping("/{MA_CT}")
    public Company companyById(@PathVariable("MA_CT") String MA_CT) {
        Optional<Company> opCompany = comService.findById(MA_CT);
        if (opCompany.isPresent()) {
            return opCompany.get();
        }
        return null;
    }
    @GetMapping("/search")
    public List<Company> companyByKeyword(@RequestParam("MA_CT") String MA_CT) {
        return comService.searchByKeyWord(MA_CT);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Company postCompany(@RequestBody Company company) {
        return comService.save(company);
    }

    @PutMapping("/{MA_CT}")
    @ResponseStatus(HttpStatus.CREATED)
    public Company putCompany(@RequestBody Company company) {
        return comService.save(company);
    }

    @DeleteMapping("/{MA_CT}")
    public void deleteCompany(@PathVariable("MA_CT") String MA_CT, Model model) {
        try {
            comService.deleteById(MA_CT);
        } catch (EmptyResultDataAccessException e) {
        }
    }
}
