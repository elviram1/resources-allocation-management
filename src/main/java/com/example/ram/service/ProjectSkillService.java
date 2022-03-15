package com.example.ram.service;

import com.example.ram.model.ProjectSkill;

import com.example.ram.repository.ProjectSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectSkillService {

    @Autowired
    private ProjectSkillRepository projectSkillRepository;

    public List<ProjectSkill> getAllProjectSkill() {
        List<ProjectSkill> projectSkillList = new ArrayList<>();
        return projectSkillList = projectSkillRepository.findAll();
    }

    public void addOrUpdateProjectSkill(ProjectSkill projectSkill){
        projectSkillRepository.save(projectSkill);
    }

    public void deleteProjectSkillById(Long id){
        projectSkillRepository.deleteProjectSkill(id);
    }
}

