package com.example.ram.service;

import com.example.ram.model.TechnicalSkill;
import com.example.ram.repository.TechnicalSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TechnicalSkillService {

    @Autowired
    private TechnicalSkillRepository technicalSkillRepository;

    public List<TechnicalSkill> getAllTechnicalSkill(){
        List<TechnicalSkill> technicalSkillList = new ArrayList<>();
        return technicalSkillList = technicalSkillRepository.findAll();
    }
}
