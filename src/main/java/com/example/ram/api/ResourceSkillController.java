package com.example.ram.api;

import com.example.ram.model.Resource;
import com.example.ram.model.ResourceSkill;
import com.example.ram.model.TechnicalSkill;
import com.example.ram.service.ResourceService;
import com.example.ram.service.ResourceSkillService;
import com.example.ram.service.TechnicalSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/resource-skills")
@Controller
public class ResourceSkillController {

    private final ResourceSkillService resourceSkillService;
    private final ResourceService resourceService;
    private final TechnicalSkillService technicalSkillService;

    @Autowired
    public ResourceSkillController(ResourceSkillService resourceSkillService, ResourceService resourceService, TechnicalSkillService technicalSkillService) {
        this.resourceSkillService = resourceSkillService;
        this.resourceService = resourceService;
        this.technicalSkillService = technicalSkillService;
    }

    @GetMapping
    public ModelAndView getAllResourceSkill(){
        ModelAndView mav = new ModelAndView("ResourceSkillView");
        List<ResourceSkill> resourceSkillList = resourceSkillService.getAllResourceSkill();
        List<Resource> resourceList = resourceService.getAllResource();
        List<TechnicalSkill> technicalSkillList = technicalSkillService.getAllTechnicalSkill();
        mav.addObject("resourceSkills", resourceSkillList);
        mav.addObject("resources", resourceList);
        mav.addObject("technicalSkills", technicalSkillList);
        return mav;
    }

    @PostMapping("/addOrUpdate")
    public String addOrUpdateResourceSkill(ResourceSkill resourceSkill){
        resourceSkillService.addOrUpdateResourceSkill(resourceSkill);
        return "redirect:/resource-skills";
    }

    @GetMapping("/delete/{id}")
    public String deleteResourceSkill(@PathVariable Long id){
        resourceSkillService.deleteResourceSkill(id);
        return "redirect:/resource-skills";
    }
}
