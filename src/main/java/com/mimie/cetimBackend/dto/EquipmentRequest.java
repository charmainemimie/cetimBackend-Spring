package com.mimie.cetimBackend.dto;


import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
    public class EquipmentRequest {

        @NotBlank
        private String inventoryNo;

        @NotBlank
        private String barcode;

        @NotBlank
        private String designation;

        private LocalDate acquisitionDate;

        private String status;
        private String office;
        private String brand;
        private String processor;
        private String hardDrive;
        private String ram;
        private String os;
        private String direction;
        private String serialNumber;
    }

