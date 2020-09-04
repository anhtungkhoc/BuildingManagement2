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

@Service
public class CardImpl implements BMService<Card> {
    @Autowired
    private final CardRepository cardRepo;

    public CardImpl(CardRepository cardRepo) {
        this.cardRepo = cardRepo;
    }

    private static ArrayList<Card> lists = new ArrayList<>();

    @Override
    public Iterable<Card> findAll() {
        ArrayList<Card> listCom = (ArrayList<Card>) cardRepo.findAll();
        for (Card ser : listCom) {
            lists.add(ser);
        }
        return cardRepo.findAll();
    }

    @Override
    public Optional<Card> findById(String id) {
        return cardRepo.findById(id);
    }

    @Override
    public void deleteById(String id) {
        try {
            cardRepo.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }

    @Override
    public Card save(Card card) {
        return cardRepo.save(card);
    }

    @Override
    public List<Card> searchByKeyWord(String keyword) {
        return null;
    }

}
