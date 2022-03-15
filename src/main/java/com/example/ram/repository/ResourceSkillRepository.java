package com.example.ram.repository;

import com.example.ram.model.ResourceSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ResourceSkillRepository extends JpaRepository <ResourceSkill, Long> {

    @Transactional
    @Modifying
    @Query("delete from ResourceSkill r where r.id = :id")
    void deleteResourceSkill(long id);
}
