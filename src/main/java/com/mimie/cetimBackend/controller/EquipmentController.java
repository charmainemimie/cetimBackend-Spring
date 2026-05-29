package com.mimie.cetimBackend.controller;

import com.mimie.cetimBackend.dto.EquipmentRequest;
import com.mimie.cetimBackend.dto.EquipmentResponse;
import com.mimie.cetimBackend.service.EquipmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EquipmentController {

    private final EquipmentService equipmentService;

    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }
    @GetMapping("/")
    public String home(){
        return "welcome to CETIM EQUIPMENT MANAGEMENT SYSTEM";
    }

    @PostMapping("/equipment")
    public ResponseEntity<EquipmentResponse> create(
            @Valid @RequestBody EquipmentRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(equipmentService.create(request));
    }

    @GetMapping("/equipment")
    public List<EquipmentResponse> getAll() {
        return equipmentService.findAll();
    }

    @GetMapping("equipment/{id}")
    public EquipmentResponse getById(@PathVariable Long id) {

        return equipmentService.findById(id);
    }

    @PutMapping("equipment/{id}")
    public EquipmentResponse update(
            @PathVariable Long id,
            @RequestBody EquipmentRequest request) {

        return equipmentService.update(id, request);
    }

    @DeleteMapping("equipment/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        equipmentService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
