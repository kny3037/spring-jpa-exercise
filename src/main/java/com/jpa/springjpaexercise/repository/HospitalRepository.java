package com.jpa.springjpaexercise.repository;

import com.jpa.springjpaexercise.domain.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
}
