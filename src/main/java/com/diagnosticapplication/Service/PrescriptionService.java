package com.diagnosticapplication.Service;
import java.util.List;
import com.diagnosticapplication.Entity.Prescription;
public interface PrescriptionService {
    Prescription getPrescriptionById(Long prescriptionId);
    List<Prescription> getAllPrescriptions();
    //Prescription createPrescription(Prescription prescription);
    Prescription updatePrescription(Long prescriptionId, Prescription prescription);
    void deletePrescription(Long prescriptionId);
	Prescription createPrescription(Prescription prescription, long userId);
}