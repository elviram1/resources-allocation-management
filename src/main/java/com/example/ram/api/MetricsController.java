package com.example.ram.api;

import com.example.ram.model.Allocation;
import com.example.ram.model.Resource;
import com.example.ram.model.ResourceSkill;
import com.example.ram.model.TechnicalSkill;
import com.example.ram.service.AllocationService;
import com.example.ram.service.ResourceService;
import com.example.ram.service.ResourceSkillService;
import com.example.ram.service.TechnicalSkillService;
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


    @Autowired
    public MetricsController(ResourceService resourceService, AllocationService allocationService, TechnicalSkillService technicalSkillService, ResourceSkillService resourceSkillService) {
        this.resourceService = resourceService;
        this.allocationService = allocationService;
        this.technicalSkillService = technicalSkillService;
        this.resourceSkillService = resourceSkillService;
    }

    @GetMapping
    public ModelAndView getMetrics() {
        ModelAndView mav = new ModelAndView("Metrics");
        List<Resource> resourceList = resourceService.getAllResource();
        List<Allocation> allocationList = allocationService.getAllAllocation();
        List<TechnicalSkill> technicalSkillList = technicalSkillService.getAllTechnicalSkill();
        List<ResourceSkill> resourceSkillsList = resourceSkillService.getAllResourceSkill();
        mav.addObject("resources", resourceList);
        mav.addObject("allocations", allocationList);
        mav.addObject("technicalSkills", technicalSkillList);
        mav.addObject("resourceSkill", resourceSkillsList);
        return mav;
    }
}
