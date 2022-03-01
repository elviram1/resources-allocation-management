package com.example.ram.service;

import com.example.ram.model.ProjectGroup;
import com.example.ram.repository.ProjectGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectGroupService {

    @Autowired
    private ProjectGroupRepository projectGroupRepository;

    public List<ProjectGroup> getAllProjectGroup(){
        List<ProjectGroup> projectGroupList = new ArrayList<>();
        return projectGroupList = projectGroupRepository.findAll();
    }

    public void addProjectGroup(ProjectGroup projectGroup){
        projectGroupRepository.save(projectGroup);
    }
/*
    public void addOrUpdateProjectGroup(long id, ProjectGroup updateProjectGroup){
        Optional<ProjectGroup> projectGroup = projectGroupRepository.findById(id);
        if(projectGroup.isPresent()){
            projectGroup.get().setAgency(updateProjectGroup.getAgency());
            projectGroup.get().setColor(updateProjectGroup.getColor());
            projectGroupRepository.save(projectGroup.get());
        }else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);*/


    public void addOrUpdateProjectGroup(ProjectGroup projectGroup){
        projectGroupRepository.save(projectGroup);

    }

    public Optional<ProjectGroup> getProjectGroupById(long id){
        if(projectGroupRepository.existsById(id)) {
            return projectGroupRepository.findById(id);
        }else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public void deleteProjectGroup(ProjectGroup projectGroup){
        projectGroupRepository.delete(projectGroup);
    }
}
