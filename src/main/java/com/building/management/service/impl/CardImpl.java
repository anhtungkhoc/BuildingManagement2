package com.building.management.service.impl;


import com.building.management.entity.Card;
import com.building.management.repository.CardRepository;
import com.building.management.service.BMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service //Danh dau day la 1 service de khi goij BMService thi Spring tra ve
public class CardImpl implements BMService<Card> {
    @Autowired //Goi repository de thuc hien cac chuc nang cua JPA Hibernate
    private final CardRepository cardRepo;

    public CardImpl(CardRepository cardRepo) {
        this.cardRepo = cardRepo;
    }

    private static ArrayList<Card> lists = new ArrayList<>();

    @Override //Thuc hien viec lay danh sach model
    public Iterable<Card> findAll() {
        ArrayList<Card> listCom = (ArrayList<Card>) cardRepo.findAll();
        for (Card ser : listCom) {
            lists.add(ser);
        }
        return cardRepo.findAll();
    }

    @Override //Thuc hien viec lay thong tin model theo ID
    public Optional<Card> findById(String id) {
        return cardRepo.findById(id);
    }

    @Override //Thuc hien xoa model theo ID
    public void deleteById(String id) {
        try {
            cardRepo.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }

    @Override //Thuc hien viec luu 1 model
    public Card save(Card card) {
        return cardRepo.save(card);
    }

    @Override //Thuc hien viec tim kiem 1 model theo keyword do nguoi dung nhap vao
    public List<Card> searchByKeyWord(String keyword) {
        return null;
    }

}
