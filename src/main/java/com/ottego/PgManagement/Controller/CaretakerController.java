package com.ottego.PgManagement.Controller;

import com.ottego.PgManagement.Request.CaretakerRequest;
import com.ottego.PgManagement.model.Caretaker;
import com.ottego.PgManagement.service.CaretakerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/caretakers")
public class CaretakerController {

    private final CaretakerService caretakerService;

    public CaretakerController(CaretakerService caretakerService) {
        this.caretakerService = caretakerService;
    }

    @PostMapping
    public Caretaker addCaretaker(@RequestBody CaretakerRequest request) {
        return caretakerService.addCaretaker(request);
    }

    @PutMapping("/{id}")
    public Caretaker updateCaretaker(@PathVariable Integer id, @RequestBody CaretakerRequest request) {
        return caretakerService.updateCaretaker(id, request);
    }

    @GetMapping
    public List<Caretaker> getAllCaretakers() {
        return caretakerService.getAllCaretakers();
    }
}
