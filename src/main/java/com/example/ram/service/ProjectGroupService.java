package com.example.ram.service;

import com.example.ram.model.ProjectGroup;
import com.example.ram.repository.ProjectGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProjectGroupService {

    @Autowired
    private ProjectGroupRepository projectGroupRepository;

    public List<ProjectGroup> getAllProjectGroup(){
        List<ProjectGroup> projectGroupList = new ArrayList<>();
        return projectGroupList = projectGroupRepository.findAll();
    }

    public List<String> getNameProjectGroup(){
        List<ProjectGroup> projectGroupList = new ArrayList<>();
        List<String> nameProjectGroup = new ArrayList<>();
        String agency;
        projectGroupList = projectGroupRepository.findAll();
        for(int i=0; i<projectGroupList.size(); i++ ){
            agency = projectGroupList.get(i).getAgency();
            nameProjectGroup.add(agency);
        }
        return  nameProjectGroup;

    }

    public void addOrUpdateProjectGroup(ProjectGroup projectGroup){
        projectGroupRepository.save(projectGroup);

    }

    public void deleteProjectGroup(long id){
        projectGroupRepository.deleteById(id);
    }

}
