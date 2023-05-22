package com.example.Dosify.repository;

import com.example.Dosify.model.Appointment;
import com.example.Dosify.model.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateRepository extends JpaRepository<Appointment,Integer> {
   Certificate findByUserId(int id) ;
}
