package com.mimie.cetimBackend.service;

import com.mimie.cetimBackend.dto.EquipmentRequest;
import com.mimie.cetimBackend.dto.EquipmentResponse;

import java.util.List;

public interface EquipmentService {
    EquipmentResponse create(EquipmentRequest request);

    List<EquipmentResponse> findAll();

    EquipmentResponse findById(Long id);

    EquipmentResponse update(Long id,
                             EquipmentRequest request);

    void delete(Long id);
}
