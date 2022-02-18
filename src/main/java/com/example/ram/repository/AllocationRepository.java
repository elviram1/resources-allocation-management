package com.example.ram.repository;

import com.example.ram.model.Allocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllocationRepository extends JpaRepository <Allocation, Long> {

}
