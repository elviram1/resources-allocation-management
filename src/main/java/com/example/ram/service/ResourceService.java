package com.example.ram.service;

import com.example.ram.model.Resource;
import com.example.ram.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    public List<Resource> getAllResource(){
        List<Resource> resourceList = new ArrayList<>();
        return resourceList = resourceRepository.findAll();
    }

    public void addOrUpdateResource(Resource resource){
        resourceRepository.save(resource);
    }

    public void deleteResource(long id){
        resourceRepository.deleteById(id);
    }
}
