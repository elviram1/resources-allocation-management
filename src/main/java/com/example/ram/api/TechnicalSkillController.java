package com.example.ram.api;

import com.example.ram.model.TechnicalSkill;
import com.example.ram.service.TechnicalSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/technical-skills")
@Controller
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
        mav.addObject("technicalSkills", technicalSkillList);
        return mav;
    }
    @PostMapping("/addOrUpdate")
    public String addOrUpdateTechnicalSkill(TechnicalSkill technicalSkill){
        technicalSkillService.addOrUpdateTechnicalSkill(technicalSkill);
        return "redirect:/technical-skills";
    }

    @GetMapping("/delete/{id}")
    public String deleteTechnicalSkill(@PathVariable Long id){
        technicalSkillService.deleteTechnicalSkill(id);
        return "redirect:/technical-skills";
    }

}
