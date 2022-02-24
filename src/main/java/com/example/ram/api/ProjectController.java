package com.example.ram.api;

import com.example.ram.model.Project;
import com.example.ram.service.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RequestMapping("/projects")
@RestController
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public ModelAndView getAllProject(){
        ModelAndView mav = new ModelAndView("ProjectView");
        List<Project> projectList = projectService.getAllProject();
        mav.addObject("projects", projectList);
        return mav;
    }

}
