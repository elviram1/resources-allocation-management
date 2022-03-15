package com.example.ram.service;

import com.example.ram.model.ResourceSkill;
import com.example.ram.repository.ResourceSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResourceSkillService {

    @Autowired
    private ResourceSkillRepository resourceSkillRepository;

    public List<ResourceSkill> getAllResourceSkill(){
        List<ResourceSkill> resourceSkillList = new ArrayList<>();
        return resourceSkillList = resourceSkillRepository.findAll();
    }

    public void addOrUpdateResourceSkill(ResourceSkill resourceSkill){
        resourceSkillRepository.save(resourceSkill);
    }

    public void deleteResourceSkill(Long id){
        resourceSkillRepository.deleteResourceSkill(id);
    }

}
