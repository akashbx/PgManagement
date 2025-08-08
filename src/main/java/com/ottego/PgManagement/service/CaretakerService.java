package com.ottego.PgManagement.service;


import com.ottego.PgManagement.Request.CaretakerRequest;
import com.ottego.PgManagement.model.Caretaker;
import com.ottego.PgManagement.model.Pg;
import com.ottego.PgManagement.repository.CaretakerRepository;
import com.ottego.PgManagement.repository.PgRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaretakerService {

    private final CaretakerRepository caretakerRepository;
    private final PgRepository pgRepository;

    public CaretakerService(CaretakerRepository caretakerRepository, PgRepository pgRepository) {
        this.caretakerRepository = caretakerRepository;
        this.pgRepository = pgRepository;
    }

    public Caretaker addCaretaker(CaretakerRequest request) {
        Caretaker caretaker = new Caretaker();
        caretaker.setName(request.getName());
        caretaker.setPhone(request.getPhone());
        caretaker.setPassword(request.getPassword());

        if (request.getPg_id() != null) {
            Pg pg = pgRepository.findById(request.getPg_id())
                    .orElseThrow(() -> new RuntimeException("PG not found"));
            caretaker.setPg(pg);
        }

        return caretakerRepository.save(caretaker);
    }

    public Caretaker updateCaretaker(Integer id, CaretakerRequest request) {
        Caretaker caretaker = caretakerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Caretaker not found"));

        caretaker.setName(request.getName());
        caretaker.setPhone(request.getPhone());
        caretaker.setPassword(request.getPassword());

        if (request.getPg_id() != null) {
            Pg pg = pgRepository.findById(request.getPg_id())
                    .orElseThrow(() -> new RuntimeException("PG not found"));
            caretaker.setPg(pg);
        }

        return caretakerRepository.save(caretaker);
    }

    public List<Caretaker> getAllCaretakers() {
        return caretakerRepository.findAll();
    }
}
