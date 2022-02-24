package com.example.ram.api;

import com.example.ram.model.Allocation;
import com.example.ram.service.AllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/allocations")
@RestController
public class AllocationController {

    private final AllocationService allocationService;

    @Autowired
    public AllocationController(AllocationService allocationService) {
        this.allocationService = allocationService;
    }

    @GetMapping
    public ModelAndView getAllAllocation(){
        ModelAndView mav = new ModelAndView("AllocationView");
        List<Allocation> allocationList = allocationService.getAllAllocation();
        mav.addObject("allocations", allocationList);
        return mav;
    }
}
