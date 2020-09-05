package com.building.management.controller;

import com.building.management.entity.BuildingMember;
import com.building.management.service.BMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //Danh dau day la 1 API
@RequestMapping(path = "/building-member", produces = "application/json")
@CrossOrigin(origins = "*") //Cho phep ben ngoai goi den API bang IP mang
public class BuiMemController {


    @Autowired //Goi BuildingMember
    private BMService<BuildingMember> buiMemService;

    public BuiMemController(BMService<BuildingMember> buiMemService) {this.buiMemService = buiMemService; }

    @GetMapping("/all") //Method tra ve list model
    public Iterable<BuildingMember> getListBuildingMember(){
        return buiMemService.findAll();
    }

    @GetMapping("/{MA_NV}") //Method tra ve 1 model theo id
    public BuildingMember buildingMemberById(@PathVariable("MA_NV") String MA_NV) {
        Optional<BuildingMember> opBuildingMember = buiMemService.findById(MA_NV);
        if (opBuildingMember.isPresent()) {
            return opBuildingMember.get();
        }
        return null;
    }
    @GetMapping("/search") //url "/search?keyword={name}: name phai viet dung ky tu hoa thuong theo ten cua model de lay ra thong tin cua model chua keyword nay
    public List<BuildingMember> buildingMemberByKeyword(@RequestParam(name ="keyword", required = false, defaultValue = "") String name) {
        return buiMemService.searchByKeyWord(name);
    }

    @PostMapping(consumes = "application/json") //Create mot model moi vao database
    @ResponseStatus(HttpStatus.CREATED)
    public BuildingMember postBuildingMember(@RequestBody BuildingMember buildingMember) {
        return buiMemService.save(buildingMember);
    }

    @PutMapping("/{MA_NV}")
    @ResponseStatus(HttpStatus.CREATED) //Update mot model vao database
    public BuildingMember putBuildingMember(@RequestBody BuildingMember buildingMember) {
        return buiMemService.save(buildingMember);
    }

    @DeleteMapping("/{MA_NV}") //Xoa mot model theo ID
    public void deleteBuildingMember(@PathVariable("MA_NV") String MA_NV, Model model) {
        try {
            buiMemService.deleteById(MA_NV);
        } catch (EmptyResultDataAccessException e) {
        }
    }
}
