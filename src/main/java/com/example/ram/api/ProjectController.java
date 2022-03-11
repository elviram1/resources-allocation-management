package com.example.ram.api;

import com.example.ram.model.Project;
import com.example.ram.model.ProjectGroup;
import com.example.ram.service.ProjectGroupService;
import com.example.ram.service.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/projects")
@Controller
public class ProjectController {

    private final ProjectService projectService;
    private final ProjectGroupService projectGroupService;

    @Autowired
    public ProjectController(ProjectService projectService, ProjectGroupService projectGroupService) {
        this.projectService = projectService;
        this.projectGroupService = projectGroupService;
    }

    @GetMapping
    public ModelAndView getAllProject(){
        ModelAndView mav = new ModelAndView("ProjectView");
        List<Project> projectList = projectService.getAllProject();
        List<ProjectGroup> projectGroupList = projectGroupService.getAllProjectGroup();
        mav.addObject("projects", projectList);
        mav.addObject("projectGroups", projectGroupList);
        return mav;
    }

    @PostMapping("/addOrUpdate")
    public String addOrUpdateProject(Project project){
        projectService.addOrUpdateProject(project);
        return "redirect:/projects";
    }

   @GetMapping("/delete/{id}")
    public  String deleteProject(@PathVariable Long id){
        projectService.deleteProject(id);
       return "redirect:/projects";
   }

}
