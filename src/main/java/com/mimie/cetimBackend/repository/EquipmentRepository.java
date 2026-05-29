package com.mimie.cetimBackend.repository;

import com.mimie.cetimBackend.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository extends JpaRepository<Equipment,Long> {
}
