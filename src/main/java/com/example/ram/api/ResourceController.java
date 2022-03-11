package com.example.ram.api;

import com.example.ram.model.Resource;
import com.example.ram.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/resources")
@Controller
public class ResourceController {

    private final ResourceService resourceService;

    @Autowired
    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @GetMapping
    public ModelAndView getAllResource(){
        ModelAndView mav = new ModelAndView("ResourceView");
        List<Resource> resourceList = resourceService.getAllResource();
        mav.addObject("resources", resourceList);
        return mav;
    }

    @PostMapping("/addOrUpdate")
    public  String addOrDeleteResource(Resource resource){
        resourceService.addOrUpdateResource(resource);
        return "redirect:/resources";
    }

    @GetMapping("/delete/{id}")
    public String deleteResource(@PathVariable Long id){
        resourceService.deleteResource(id);
        return "redirect:/resources";
    }
}
