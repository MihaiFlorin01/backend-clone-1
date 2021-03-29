package com.example.backendclone1.controller;

import com.example.backendclone1.exception.ResourceNotFoundException;
import com.example.backendclone1.model.Clone;
import com.example.backendclone1.service.CloneService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.annotation.Resource;
import java.util.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping()
public class CloneController extends WebMvcConfigurationSupport {
    @Resource
    private CloneService cloneService;

    //get all websites
    @GetMapping("/clone")
    public List<Clone> getAll() {
        return cloneService.findAll();
    }

    //create clone rest api
    @PostMapping("/create/clone")
    public Clone create(@RequestBody Clone clone) {
        Clone clone2 = cloneService.findFirstByName(clone.getName());
        if (clone.getName().equals(clone2.getName())) {
            clone2.setName(clone.getName());
            clone2.setUrl(clone.getUrl());
            clone2.setActive(clone.isActive());
            return cloneService.save(clone2);
        }
//        System.out.println(clone2.toString());
//        System.out.println(clone.toString());
        return cloneService.save(clone);
    }

        //get website by id rest api
        @GetMapping("/websites/{id}")
        public ResponseEntity<Clone> getWebsiteById (@PathVariable Long id) throws Throwable {
            Clone website = cloneService.findById(id).orElseThrow(() -> new ResourceNotFoundException("website not exist with name: " + id));
            return ResponseEntity.ok(website);
        }

        //update website rest api
        @PutMapping("/website/{id}")
        public ResponseEntity<Clone> update (@PathVariable Long id, @RequestBody Clone cloneDetails){
            Clone clone = cloneService.findById(id).orElseThrow(() -> new ResourceNotFoundException("website not exist with name: " + id));

            clone.setName(cloneDetails.getName());
            clone.setActive(cloneDetails.isActive());
            clone.setUrl(cloneDetails.getUrl());

            Clone updateWebsite = cloneService.save(clone);
            return ResponseEntity.ok(updateWebsite);
        }

        //delete website rest api
        @DeleteMapping("/websites/delete/{id}")
        public ResponseEntity<Map<String, Boolean>> delete (@PathVariable Long id){
            Clone website = cloneService.findById(id).orElseThrow(() -> new ResourceNotFoundException("website not exist with name: " + id));

            cloneService.delete(website);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return ResponseEntity.ok(response);
        }

//    @GetMapping("/clone/status")
//    public Boolean getStatus(HttpServletRequest httpServletRequest) {
//        System.out.println(httpServletRequest.getServerName());
//        System.out.println(cloneService.findFirstByName(httpServletRequest.getServerName()).isActive());
//        return cloneService.findFirstByName(httpServletRequest.getServerName()).isActive();
//    }

        @GetMapping("/status/clone")
        public Boolean getStatus() {
            List<Clone> list = getAll();
            Clone clone2 = list.get(0);
            return clone2.isActive();
        }

//    @ModelAttribute
//    public void setResponseHeader(HttpServletResponse response) {
//        response.setHeader();
//    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS").allowedOrigins("http://localhost:4201");
    }
}
