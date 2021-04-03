package com.example.backendclone1.service;

import com.example.backendclone1.model.Clone;
import com.example.backendclone1.repository.CloneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CloneService {
    @Autowired
    private CloneRepository cloneRepository;

    public List<Clone> findAll() {
        return cloneRepository.findAll();
    }

    public Clone save(Clone clone) {
//        Optional<Clone> cloneOptional = cloneRepository.findFirstByUrl(website.getUrl());
////        if (cloneOptional.get() != null) {
////            Clone clone = cloneOptional.get();
////            clone.setName(website.getName());
////            clone.setActive(website.isActive());
////            clone.setUrl(website.getUrl());
////            return cloneRepository.save(clone);
////        }
        return cloneRepository.save(clone);
    }


    public <T> Optional<Clone> findById(Long id) {
        return cloneRepository.findById(id);
    }

    public void delete(Clone clone) {
        cloneRepository.delete(clone);
    }

    public  Clone findFirstByUrl(String url) {
        return cloneRepository.findFirstByUrl(url);
    }
}
