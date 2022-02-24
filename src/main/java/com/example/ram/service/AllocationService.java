package com.example.ram.service;

import com.example.ram.model.Allocation;
import com.example.ram.repository.AllocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AllocationService {

    @Autowired
    private AllocationRepository allocationRepository;

    public List<Allocation> getAllAllocation() {
        List<Allocation>  allocationList = new ArrayList<>();
        return allocationList = allocationRepository.findAll();
    }
}
