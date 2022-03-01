package com.example.ram.api;

import com.example.ram.model.ProjectGroup;
import com.example.ram.service.ProjectGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RequestMapping("/project-groups")
@Controller
public class ProjectGroupController {

    private final ProjectGroupService projectGroupService;

    @Autowired
    public ProjectGroupController(ProjectGroupService projectGroupService) {
        this.projectGroupService = projectGroupService;
    }

    @GetMapping
    public ModelAndView getAllProjectGroup(){
        ModelAndView mav = new ModelAndView("ProjectGroupView");
        List<ProjectGroup> projectGroupList = projectGroupService.getAllProjectGroup();
        mav.addObject("projectGroups", projectGroupList);
        return mav;
    }

    @PostMapping("/addOrUpdate")
    public String addProjectGroup(ProjectGroup projectGroup){
        projectGroupService.addOrUpdateProjectGroup(projectGroup);
        return "redirect:/project-groups";
    }

    /*@GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model){
        Optional<ProjectGroup> projectGroup = projectGroupService.getProjectGroupById(id);
        model.addAttribute("projectGroup", projectGroup);
        return "redirect:/project-groups";

    }*/



}
