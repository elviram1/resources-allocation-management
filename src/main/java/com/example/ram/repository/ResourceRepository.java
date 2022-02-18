package com.example.ram.repository;

import com.example.ram.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository <Resource, Long> {
}
