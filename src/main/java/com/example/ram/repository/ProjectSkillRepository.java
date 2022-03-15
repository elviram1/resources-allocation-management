package com.example.ram.repository;

import com.example.ram.model.ProjectSkill;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


public interface ProjectSkillRepository extends JpaRepository <ProjectSkill, Long> {

    @Transactional
    @Modifying
    @Query("delete from ProjectSkill p where p.id = :id")
    void deleteProjectSkill(long id);
}
