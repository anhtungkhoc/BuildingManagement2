package com.building.management.controller;

import com.building.management.entity.Services;
import com.building.management.service.BMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //Danh dau day la 1 API
@RequestMapping(path = "/service", produces = "application/json")
@CrossOrigin(origins = "*") //Cho phep ben ngoai goi den API bang IP mang
public class ServicesController {


    @Autowired //Goi services
    private BMService<Services> serService;

    public ServicesController(BMService<Services> serService) {this.serService = serService; }

    @GetMapping("/all") //Method tra ve list model
    public Iterable<Services> getListServices(){
        return serService.findAll();
    }

    @GetMapping("/{MA_DV}") //Method tra ve 1 model theo id
    public Services servicesById(@PathVariable("MA_DV") String MA_DV) {
        Optional<Services> opServices = serService.findById(MA_DV);
        if (opServices.isPresent()) {
            return opServices.get();
        }
        return null;
    }
    @GetMapping("/search") //url "/search?keyword={name}: name phai viet dung ky tu hoa thuong theo ten cua model de lay ra thong tin cua model chua keyword nay
    public List<Services> servicesByKeyword(@RequestParam(name ="keyword", required = false, defaultValue = "") String name) {
        return serService.searchByKeyWord(name);
    }

    @PostMapping(consumes = "application/json") //Create mot model moi vao database
    @ResponseStatus(HttpStatus.CREATED)
    public Services postServices(@RequestBody Services services) {
        return serService.save(services);
    }

    @PutMapping("/{MA_DV}")
    @ResponseStatus(HttpStatus.CREATED) //Update mot model vao database
    public Services putServices(@RequestBody Services services) {

        return serService.save(services);
    }

    @DeleteMapping("/{MA_DV}") //Xoa mot model theo ID
    public void deleteServices(@PathVariable("MA_DV") String MA_DV) {
        try {
            serService.deleteById(MA_DV);
        } catch (EmptyResultDataAccessException e) {
        }
    }
}
