package com.example.ram.api;

import com.example.ram.model.TechnicalSkill;
import com.example.ram.service.TechnicalSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/technical-skills")
@RestController
public class TechnicalSkillController {

    public TechnicalSkillService technicalSkillService;

    @Autowired
    public TechnicalSkillController(TechnicalSkillService technicalSkillService) {
        this.technicalSkillService = technicalSkillService;
    }

    @GetMapping
    public ModelAndView getAllTechnicalSkill(){
        ModelAndView mav = new ModelAndView("TechnicalSkillView");
        List<TechnicalSkill> technicalSkillList = technicalSkillService.getAllTechnicalSkill();
        mav.addObject("techinalSkills", technicalSkillList);
        return mav;
    }
}
