package com.building.management.controller;

import com.building.management.entity.CompanyUse;
import com.building.management.service.BMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController //Danh dau day la 1 API
@RequestMapping(path = "/company-use", produces = "application/json")
@CrossOrigin(origins = "*") //Cho phep ben ngoai goi den API bang IP mang
public class ComUseController {

    @Autowired //Goi CompanyUse
    private BMService<CompanyUse> buiMemService;

    public ComUseController(BMService<CompanyUse> buiMemService) {this.buiMemService = buiMemService; }

    @GetMapping("/all") //Method tra ve list model
    public Iterable<CompanyUse> getListCompanyUse(){
        return buiMemService.findAll();
    }

    @GetMapping("/{MA_DK}") //Method tra ve 1 model theo id
    public CompanyUse companyUseById(@PathVariable("MA_DK") String MA_DK) {
        Optional<CompanyUse> opCompanyUse = buiMemService.findById(MA_DK);
        if (opCompanyUse.isPresent()) {
            return opCompanyUse.get();
        }
        return null;
    }
//    @GetMapping("/search") //url "/search?keyword={name}: name phai viet dung ky tu hoa thuong theo ten cua model de lay ra thong tin cua model chua keyword nay
//    public List<CompanyUse> CompanyUseByKeyword(@RequestParam(name ="keyword", required = false, defaultValue = "") String name) {
//        return buiMemService.searchByKeyWord(name);
//    }

    @PostMapping(consumes = "application/json") //Create mot model moi vao database
    @ResponseStatus(HttpStatus.CREATED)
    public CompanyUse postCompanyUse(@RequestBody CompanyUse CompanyUse) {
        return buiMemService.save(CompanyUse);
    }

    @PutMapping("/{MA_DK}")
    @ResponseStatus(HttpStatus.CREATED) //Update mot model vao database
    public CompanyUse putCompanyUse(@RequestBody CompanyUse CompanyUse) {
        return buiMemService.save(CompanyUse);
    }

    @DeleteMapping("/{MA_DK}") //Xoa mot model theo ID
    public void deleteCompanyUse(@PathVariable("MA_DK") String MA_DK) {
        try {
            buiMemService.deleteById(MA_DK);
        } catch (EmptyResultDataAccessException e) {
        }
    }
}
