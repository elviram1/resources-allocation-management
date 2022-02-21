package com.example.ram.service;

import com.example.ram.model.Project;
import com.example.ram.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAllProject(){
        List<Project> projectList = new ArrayList<>();
        return projectList = projectRepository.findAll();
    }
}
