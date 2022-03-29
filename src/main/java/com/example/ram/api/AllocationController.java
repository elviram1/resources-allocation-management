package com.example.ram.api;

import com.example.ram.model.Allocation;
import com.example.ram.model.Project;
import com.example.ram.model.Resource;
import com.example.ram.service.AllocationService;
import com.example.ram.service.ProjectService;
import com.example.ram.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/allocations")
@Controller
public class AllocationController {

    private final AllocationService allocationService;
    private final ProjectService projectService;
    private final ResourceService resourceService;

    @Autowired
    public AllocationController(AllocationService allocationService, ProjectService projectService, ResourceService resourceService) {
        this.allocationService = allocationService;
        this.projectService = projectService;
        this.resourceService = resourceService;
    }

    @GetMapping
    public ModelAndView getAllAllocation(){
        ModelAndView mav = new ModelAndView("AllocationView");
        List<Allocation> allocationList = allocationService.getAllAllocation();
        List<Project> projectList = projectService.getAllProject();
        List<Resource> resourceList = resourceService.getAllResource();
        mav.addObject("allocations", allocationList);
        mav.addObject("projects", projectList);
        mav.addObject("resources", resourceList);
        return mav;
    }

    @PostMapping("/addOrUpdate")
    public String addOrUpdateAllocation(Allocation allocation){
        allocationService.addOrUpdateAllocation(allocation);
        return "redirect:/allocations";
    }
    @PostMapping("/add-project-allocation")
    public String addAllocationInProjectAllocationView(Allocation allocation){
        allocationService.addOrUpdateAllocation(allocation);
        return "redirect:/project-allocation";
    }

    @GetMapping("/delete/{id}")
    public String deleteAllocation(@PathVariable Long id){
        allocationService.deleteAllocation(id);
        return "redirect:/allocations";
    }
}
