package com.building.management.controller;

import com.building.management.entity.Services;
import com.building.management.service.BMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //Danh dau day la 1 API
@RequestMapping(path = "/services", produces = "application/json")
@CrossOrigin(origins = "*") //Cho phep ben ngoai goi den API bang IP mang
public class ServicesController {


    @Autowired //Goi services
    private BMService<Services> serService;

    public ServicesController(BMService<Services> serService) {
        this.serService = serService;
    }

    @GetMapping("/all") //Method tra ve list model
    public Iterable<Services> getListCompany(){
        return serService.findAll();
    }

    @GetMapping("/{MA_DV}") //Method tra ve 1 model theo id
    public Services companyById(@PathVariable("MA_DV") String MA_DV) {
        Optional<Services> opCompany = serService.findById(MA_DV);
        if (opCompany.isPresent()) {
            return opCompany.get();
        }
        return null;
    }
    @GetMapping("/search") //url "/search?keyword={name}: name phai viet dung ky tu hoa thuong theo ten cua model de lay ra thong tin cua model chua keyword nay
    public List<Services> companyByKeyword(@RequestParam(name ="keyword", required = false, defaultValue = "") String name) {
        return serService.searchByKeyWord(name);
    }

    @PostMapping(consumes = "application/json") //Create mot model moi vao database
    @ResponseStatus(HttpStatus.CREATED)
    public Services postCompany(@RequestBody Services company) {
        return serService.save(company);
    }

    @PutMapping("/{MA_DV}")
    @ResponseStatus(HttpStatus.CREATED) //Update mot model vao database
    public Services putCompany(@RequestBody Services company) {
        return serService.save(company);
    }

    @DeleteMapping("/{MA_DV}") //Xoa mot model theo ID
    public void deleteCompany(@PathVariable("MA_DV") String MA_DV, Model model) {
        try {
            serService.deleteById(MA_DV);
        } catch (EmptyResultDataAccessException e) {
        }
    }
}
