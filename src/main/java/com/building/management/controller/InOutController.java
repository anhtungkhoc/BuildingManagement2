package com.building.management.controller;

import com.building.management.entity.InOut;
import com.building.management.entity.InOutInfo;
import com.building.management.service.BMService;
import com.building.management.service.impl.InOutImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //Danh dau day la 1 API
@RequestMapping(path = "/in-out", produces = "application/json")
@CrossOrigin(origins = "*") //Cho phep ben ngoai goi den API bang IP mang
public class InOutController {


    @Autowired //Goi services
    private BMService<InOut> comInOut;

    @Autowired
    private InOutImpl inOutImpl;
    
    public InOutController(BMService<InOut> comInOut) {
        this.comInOut = comInOut;
    }

    @GetMapping("/all") //Method tra ve list model
    public Iterable<InOut> getListCompany() {
        return comInOut.findAll();
    }

    @GetMapping("/{MA_RV}") //Method tra ve 1 model theo id
    public InOut companyById(@PathVariable("MA_RV") String MA_RV) {
        Optional<InOut> opInOut = comInOut.findById(MA_RV);
        if (opInOut.isPresent()) {
            return opInOut.get();
        }
        return null;
    }

    @GetMapping("/search")
    //url "/search?keyword={name}: name phai viet dung ky tu hoa thuong theo ten cua model de lay ra thong tin cua model chua keyword nay
    public List<InOut> companyByKeyword(@RequestParam(name = "keyword", required = false, defaultValue = "") String name) {
        return comInOut.searchByKeyWord(name);
    }

    @PostMapping(consumes = "application/json") //Create mot model moi vao database
    @ResponseStatus(HttpStatus.CREATED)
    public InOut postInOut(@RequestBody InOut company) {
        return comInOut.save(company);
    }

    @PutMapping("/{MA_RV}")
    @ResponseStatus(HttpStatus.CREATED) //Update mot model vao database
    public InOut putInOut(@RequestBody InOut company) {
        return comInOut.save(company);
    }

    @DeleteMapping("/{MA_RV}") //Xoa mot model theo ID
    public void deleteInOut(@PathVariable("MA_RV") String MA_RV) {
        try {
            comInOut.deleteById(MA_RV);
        } catch (EmptyResultDataAccessException e) {
        }
    }

    @GetMapping("/in-out-info/{checkTime}/{MA_NV}")
    public List<InOutInfo> getInOutInfoByCHECK_TIMEAndMA_NV(@PathVariable("checkTime") String checkTime,@PathVariable("MA_NV") String MA_NV){
        return inOutImpl.getInOutInfoByCHECK_TIMEAndMA_NV(checkTime,MA_NV);
    }
}
