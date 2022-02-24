package com.example.ram.api;

import com.example.ram.model.Project;
import com.example.ram.model.ResourceSkill;
import com.example.ram.service.ResourceSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/resourses-skills")
@RestController
public class ResourceSkillController {

    private ResourceSkillService resourceSkillService;

    @Autowired
    public ResourceSkillController(ResourceSkillService resourceSkillService) {
        this.resourceSkillService = resourceSkillService;
    }

    @GetMapping
    public ModelAndView getAllResourceSkill(){
        ModelAndView mav = new ModelAndView("ResourceSkillView");
        List<ResourceSkill> resourceSkillList = resourceSkillService.getAllResourceSkill();
        mav.addObject("resourceSkills", resourceSkillList);
        return mav;
    }
}
