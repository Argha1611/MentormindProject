package com.diagnosticapplication.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.diagnosticapplication.Entity.Prescription;
@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
    // You can define custom query methods if needed
}
