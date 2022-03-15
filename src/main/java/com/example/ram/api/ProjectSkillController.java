package com.example.ram.api;

import com.example.ram.model.Project;
import com.example.ram.model.ProjectSkill;

import com.example.ram.model.TechnicalSkill;
import com.example.ram.service.ProjectService;
import com.example.ram.service.ProjectSkillService;
import com.example.ram.service.TechnicalSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/project-skills")
@Controller
public class ProjectSkillController {

    private final ProjectSkillService projectSkillService;
    private final ProjectService projectService;
    private final TechnicalSkillService technicalSkillService;

    @Autowired
    public ProjectSkillController(ProjectSkillService projectSkillService, ProjectService projectService, TechnicalSkillService technicalSkillService) {
        this.projectSkillService = projectSkillService;
        this.projectService = projectService;
        this.technicalSkillService = technicalSkillService;
    }

    @GetMapping
    public ModelAndView getAllResource(){
        ModelAndView mav = new ModelAndView("ProjectSkillView");
        List <ProjectSkill> projectSkillList = projectSkillService.getAllProjectSkill();
        List<Project> projectList = projectService.getAllProject();
        List<TechnicalSkill> technicalSkillList = technicalSkillService.getAllTechnicalSkill();
        mav.addObject("projectSkills", projectSkillList);
        mav.addObject("projects", projectList);
        mav.addObject("technicalSkills", technicalSkillList);
        return mav;
    }

    @PostMapping("/addOrUpdate")
    public String addOrUpdateProjectSkill(ProjectSkill projectSkill){
        projectSkillService.addOrUpdateProjectSkill(projectSkill);
        return "redirect:/project-skills";
    }

    @GetMapping("/delete/{id}")
    public String deleteProjectSkill(@PathVariable Long id){
        projectSkillService.deleteProjectSkillById(id);
        return "redirect:/project-skills";
    }
}
