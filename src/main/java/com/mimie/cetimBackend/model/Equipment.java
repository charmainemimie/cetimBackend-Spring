package com.mimie.cetimBackend.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "equipment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Equipment {
//pk
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String inventoryNo;

    @Column(nullable = false, unique = true)
    private String barcode;

    @Column(nullable = false)
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

    @Column(unique = true)
    private String serialNumber;
}
