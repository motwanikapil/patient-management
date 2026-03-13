package com.pm.patientservice.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pm.patientservice.model.Patient;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID>{
    boolean existsByEmail(String email);
    // this will check that same email exists with different uuid also
    boolean existsByEmailAndIdNot(String email, UUID id);
}

