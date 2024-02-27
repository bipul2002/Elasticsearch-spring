package com.elasticsearch.elasticsearch.repository;

import com.elasticsearch.elasticsearch.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SkillRepository extends JpaRepository<Skill,Long> {
    Optional<Skill> findBySkillId(Long skillId);
}
