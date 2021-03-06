package com.building.management.controller;

import com.building.management.entity.Company;
import com.building.management.entity.CompanyBill;
import com.building.management.service.BMService;
import com.building.management.service.impl.ComBillImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController //Danh dau day la 1 API
@RequestMapping(path = "/company", produces = "application/json")
@CrossOrigin(origins = "*") //Cho phep ben ngoai goi den API bang IP mang
public class CompanyController {

    @Autowired //Goi services
    private BMService<Company> comService;
    @Autowired
    private ComBillImpl companyImpl;

    public CompanyController(BMService<Company> comService) {
        this.comService = comService;
    }

    @GetMapping("/all") //Method tra ve list model
    public Iterable<Company> getListCompany() {
        return comService.findAll();
    }

    @GetMapping("/{MA_CT}") //Method tra ve 1 model theo id
    public Company companyById(@PathVariable("MA_CT") String MA_CT) {
        Optional<Company> opCompany = comService.findById(MA_CT);
        if (opCompany.isPresent()) {
            return opCompany.get();
        }
        return null;
    }

    @GetMapping("/search")
    //url "/search?keyword={name}: name phai viet dung ky tu hoa thuong theo ten cua model de lay ra thong tin cua model chua keyword nay
    public List<Company> companyByKeyword(@RequestParam(name = "keyword", required = false, defaultValue = "") String name) {
        return comService.searchByKeyWord(name);
    }

    @PostMapping(consumes = "application/json") //Create mot model moi vao database
    @ResponseStatus(HttpStatus.CREATED)
    public Company postCompany(@RequestBody Company company) {
        return comService.save(company);
    }

    @PutMapping("/{MA_CT}")
    @ResponseStatus(HttpStatus.CREATED) //Update mot model vao database
    public Company putCompany(@RequestBody Company company) {
        return comService.save(company);
    }

    @DeleteMapping("/{MA_CT}") //Xoa mot model theo ID
    public void deleteCompany(@PathVariable("MA_CT") String MA_CT) {
        try {
            comService.deleteById(MA_CT);
        } catch (EmptyResultDataAccessException e) {
        }
    }

    @GetMapping("/bill") //Lay ra all company's bill
    public Iterable<CompanyBill> getAllBill() {
        return companyImpl.findAll();
    }

    @GetMapping("/bill/{MA_CT}") //Method tra ve 1 bill theo id
    public List<CompanyBill> comBillByKeyword(@PathVariable("MA_CT") String keyword) {
        Iterable<CompanyBill> allBill = companyImpl.findAll();
        List<CompanyBill> listBill = new ArrayList<>();
        for (CompanyBill comBill:allBill){
            if (comBill.getMA_CT().contains(keyword)){
                listBill.add(comBill);
            }
        }
        return listBill;
    }
    @GetMapping("/bill/{ngayBD}/{ngayKT}/{MA_CT}") //Method tra ve 1 bill theo id
    public List<CompanyBill> getListBillByDate(@PathVariable("ngayBD") String ngayBD,@PathVariable("ngayKT") String ngayKT,@PathVariable("MA_CT") String MA_CT){
        return companyImpl.getListCompanyBillByDate(ngayBD,ngayKT,MA_CT);
    }
}
