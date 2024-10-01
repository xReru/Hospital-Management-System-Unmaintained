/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hmsystem.System.repository;

import com.hmsystem.System.entity.Patient;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Janrell Quiaroro
 */
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
   List<Patient> findByName(String name);
}
