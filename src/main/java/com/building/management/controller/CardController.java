package com.building.management.controller;

import com.building.management.entity.Card;
import com.building.management.service.BMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController //Danh dau day la 1 API
@RequestMapping(path = "/card", produces = "application/json")
@CrossOrigin(origins = "*") //Cho phep ben ngoai goi den API bang IP mang
public class CardController {


    @Autowired //Goi Card
    private BMService<Card> cardService;

    public CardController(BMService<Card> cardService) {this.cardService = cardService; }

    @GetMapping("/all") //Method tra ve list model
    public Iterable<Card> getListCard(){
        return cardService.findAll();
    }

    @GetMapping("/{MA_THE}") //Method tra ve 1 model theo id
    public Card cardById(@PathVariable("MA_THE") String MA_THE) {
        Optional<Card> opCard = cardService.findById(MA_THE);
        if (opCard.isPresent()) {
            return opCard.get();
        }
        return null;
    }

    @PostMapping(consumes = "application/json") //Create mot model moi vao database
    @ResponseStatus(HttpStatus.CREATED)
    public Card postCard(@RequestBody Card card) {
        return cardService.save(card);
    }

    @PutMapping("/{MA_THE}")
    @ResponseStatus(HttpStatus.CREATED) //Update mot model vao database
    public Card putCard(@RequestBody Card card) {
        return cardService.save(card);
    }

    @DeleteMapping("/{MA_THE}") //Xoa mot model theo ID
    public void deleteCard(@PathVariable("MA_THE") String MA_THE) {
        try {
            cardService.deleteById(MA_THE);
        } catch (EmptyResultDataAccessException e) {
        }
    }
}
