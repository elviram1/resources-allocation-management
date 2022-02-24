package com.example.ram.api;

import com.example.ram.model.Project;
import com.example.ram.model.Resource;
import com.example.ram.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/resources")
@RestController
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
}
