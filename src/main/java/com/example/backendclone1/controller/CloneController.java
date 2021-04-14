package com.example.backendclone1.controller;

import com.example.backendclone1.model.Clone;
import com.example.backendclone1.service.CloneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping()
public class CloneController extends WebMvcConfigurationSupport {

    @Autowired
    private CloneService cloneService;

    @GetMapping("/clone")
    public List<Clone> getAll() {
        return cloneService.findAll();
    }

    @PostMapping("/create/clone")
    public Clone create(@RequestBody Clone clone) {
        Clone clone2 = cloneService.findFirstByUrl(clone.getUrl());
        if (clone.getUrl().equals(clone2.getUrl())) {
            clone2.setName(clone.getName());
            clone2.setUrl(clone.getUrl());
            clone2.setActive(clone.isActive());
            return cloneService.save(clone2);
        }
        return cloneService.save(clone);
    }
}
