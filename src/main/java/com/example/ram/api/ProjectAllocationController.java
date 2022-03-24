package com.example.ram.api;

import com.example.ram.model.Allocation;
import com.example.ram.model.Project;
import com.example.ram.model.ProjectGroup;
import com.example.ram.model.Resource;
import com.example.ram.service.AllocationService;
import com.example.ram.service.ProjectGroupService;
import com.example.ram.service.ProjectService;
import com.example.ram.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/project-allocation")
@Controller
public class ProjectAllocationController {

    private final ResourceService resourceService;
    private final AllocationService allocationService;
    private final ProjectService projectService;
    private final ProjectGroupService projectGroupService;

    @Autowired
    public ProjectAllocationController(ResourceService resourceService, AllocationService allocationService, ProjectService projectService, ProjectGroupService projectGroupService) {
        this.resourceService = resourceService;
        this.allocationService = allocationService;
        this.projectService = projectService;
        this.projectGroupService = projectGroupService;
    }

    @GetMapping
    public ModelAndView getProjectAllocation(){
        ModelAndView mav = new ModelAndView("ProjectAllocationView");
        List<Resource> resourceList = resourceService.getAllResource();
        List<Allocation> allocationList = allocationService.getAllAllocation();
        List<Project> projectList = projectService.getAllProject();
        List<ProjectGroup> projectGroupList = projectGroupService.getAllProjectGroup();
        mav.addObject("resources", resourceList);
        mav.addObject("allocations", allocationList);
        mav.addObject("projects", projectList);
        mav.addObject("projectGroups", projectGroupList);
        return mav;
    }
}
