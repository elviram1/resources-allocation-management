package com.example.ram.api;

import com.example.ram.model.*;
import com.example.ram.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/metrics")
@Controller
public class MetricsController {

    private final ResourceService resourceService;
    private final AllocationService allocationService;
    private final TechnicalSkillService technicalSkillService;
    private final ResourceSkillService resourceSkillService;
    private final ProjectGroupService projectGroupService;
    private final ProjectService projectService;


    @Autowired
    public MetricsController(ResourceService resourceService, AllocationService allocationService, TechnicalSkillService technicalSkillService, ResourceSkillService resourceSkillService, ProjectGroupService projectGroupService, ProjectService projectService) {
        this.resourceService = resourceService;
        this.allocationService = allocationService;
        this.technicalSkillService = technicalSkillService;
        this.resourceSkillService = resourceSkillService;
        this.projectGroupService = projectGroupService;
        this.projectService = projectService;
    }

    @GetMapping
    public ModelAndView getMetrics() {
        ModelAndView mav = new ModelAndView("Metrics");
        List<Resource> resourceList = resourceService.getAllResource();
        List<Allocation> allocationList = allocationService.getAllAllocation();
        List<TechnicalSkill> technicalSkillList = technicalSkillService.getAllTechnicalSkill();
        List<ResourceSkill> resourceSkillsList = resourceSkillService.getAllResourceSkill();
        List<ProjectGroup> projectGroupList = projectGroupService.getAllProjectGroup();
        List<Project> projectList = projectService.getAllProject();
        mav.addObject("resources", resourceList);
        mav.addObject("allocations", allocationList);
        mav.addObject("technicalSkills", technicalSkillList);
        mav.addObject("resourceSkill", resourceSkillsList);
        mav.addObject("projectGroups",projectGroupList);
        mav.addObject("projects", projectList);
        return mav;
    }
}
