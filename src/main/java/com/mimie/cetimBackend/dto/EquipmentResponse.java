package com.mimie.cetimBackend.dto;


import java.time.LocalDate;

public record EquipmentResponse(

        Long id,
        String inventoryNo,
        String barcode,
        String designation,
        LocalDate acquisitionDate,
        String status,
        String office,
        String brand,
        String processor,
        String hardDrive,
        String ram,
        String os,
        String direction,
        String serialNumber
) {}
