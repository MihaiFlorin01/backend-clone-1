package com.example.backendclone1.service;

import com.example.backendclone1.model.Clone;
import com.example.backendclone1.repository.CloneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CloneService {

    @Autowired
    private CloneRepository cloneRepository;

    public List<Clone> findAll() {
        return cloneRepository.findAll();
    }

    public Clone save(Clone clone) {
        return cloneRepository.save(clone);
    }

    public  Clone findFirstByUrl(String url) {
        return cloneRepository.findFirstByUrl(url);
    }

}
