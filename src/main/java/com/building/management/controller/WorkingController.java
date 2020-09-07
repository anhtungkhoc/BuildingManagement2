package com.building.management.controller;

import com.building.management.entity.Working;
import com.building.management.service.BMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //Danh dau day la 1 API
@RequestMapping(path = "/working", produces = "application/json")
@CrossOrigin(origins = "*") //Cho phep ben ngoai goi den API bang IP mang
public class WorkingController {


    @Autowired //Goi services
    private BMService<Working> serService;

    public WorkingController(BMService<Working> serService) {this.serService = serService; }

    @GetMapping("/all") //Method tra ve list model
    public Iterable<Working> getListWorking(){
        return serService.findAll();
    }

    @GetMapping("/{MA_LV}") //Method tra ve 1 model theo id
    public Working workingById(@PathVariable("MA_LV") String MA_LV) {
        Optional<Working> opWorking = serService.findById(MA_LV);
        if (opWorking.isPresent()) {
            return opWorking.get();
        }
        return null;
    }
    @GetMapping("/search") //url "/search?keyword={name}: name phai viet dung ky tu hoa thuong theo ten cua model de lay ra thong tin cua model chua keyword nay
    public List<Working> workingByKeyword(@RequestParam(name ="keyword", required = false, defaultValue = "") String name) {
        return serService.searchByKeyWord(name);
    }

    @PostMapping(consumes = "application/json") //Create mot model moi vao database
    @ResponseStatus(HttpStatus.CREATED)
    public Working postWorking(@RequestBody Working working) {
        return serService.save(working);
    }

    @PutMapping("/{MA_LV}")
    @ResponseStatus(HttpStatus.CREATED) //Update mot model vao database
    public Working putWorking(@RequestBody Working working) {
        return serService.save(working);
    }

    @DeleteMapping("/{MA_LV}") //Xoa mot model theo ID
    public void deleteWorking(@PathVariable("MA_LV") String MA_LV) {
        try {
            serService.deleteById(MA_LV);
        } catch (EmptyResultDataAccessException e) {
        }
    }
}
