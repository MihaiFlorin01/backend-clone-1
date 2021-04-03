package com.example.backendclone1.repository;

import com.example.backendclone1.model.Clone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CloneRepository extends JpaRepository<Clone, Long> {

    Clone findFirstByUrl(String url);

}
