/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hmsystem.System.repository;

import com.hmsystem.System.entity.Doctor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Janrell Quiaroro
 */
public interface DoctorRepository extends JpaRepository<Doctor, Long>{
    List<Doctor> findByName(String name);
}
