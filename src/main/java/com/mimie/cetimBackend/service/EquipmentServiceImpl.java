package com.mimie.cetimBackend.service;

import com.mimie.cetimBackend.dto.EquipmentRequest;
import com.mimie.cetimBackend.dto.EquipmentResponse;
import com.mimie.cetimBackend.exception.ResourceNotFoundException;
import com.mimie.cetimBackend.model.Equipment;
import com.mimie.cetimBackend.repository.EquipmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; //allows use of create

import java.util.List;

@Service
@Transactional
public class EquipmentServiceImpl
        implements EquipmentService {

    private final EquipmentRepository repository;

    //constructor injection
    public EquipmentServiceImpl(EquipmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public EquipmentResponse create(EquipmentRequest request) {

        Equipment equipment = Equipment.builder()
                .inventoryNo(request.getInventoryNo())
                .barcode(request.getBarcode())
                .designation(request.getDesignation())
                .acquisitionDate(request.getAcquisitionDate())
                .status(request.getStatus())
                .office(request.getOffice())
                .brand(request.getBrand())
                .processor(request.getProcessor())
                .hardDrive(request.getHardDrive())
                .ram(request.getRam())
                .os(request.getOs())
                .direction(request.getDirection())
                .serialNumber(request.getSerialNumber())
                .build();

        return mapToResponse(repository.save(equipment));
    }

    private EquipmentResponse mapToResponse(Equipment equipment) {

        return new EquipmentResponse(
                equipment.getId(),
                equipment.getInventoryNo(),
                equipment.getBarcode(),
                equipment.getDesignation(),
                equipment.getAcquisitionDate(),
                equipment.getStatus(),
                equipment.getOffice(),
                equipment.getBrand(),
                equipment.getProcessor(),
                equipment.getHardDrive(),
                equipment.getRam(),
                equipment.getOs(),
                equipment.getDirection(),
                equipment.getSerialNumber()
        );
    }

    @Override
    public List<EquipmentResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public EquipmentResponse findById(Long id) {

        Equipment equipment = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Equipment not found"));

        return mapToResponse(equipment);
    }

    @Override
    public EquipmentResponse update(
            Long id,
            EquipmentRequest request) {

        Equipment equipment = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Equipment not found"));

        equipment.setDesignation(
                request.getDesignation());

        equipment.setBrand(
                request.getBrand());

        equipment.setOffice(
                request.getOffice());

        equipment.setStatus(
                request.getStatus());

        return mapToResponse(
                repository.save(equipment));
    }

    @Override
    public void delete(Long id) {

        Equipment equipment = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Equipment not found"));

        repository.delete(equipment);
    }
}
