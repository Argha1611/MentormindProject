package com.diagnosticapplication.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.diagnosticapplication.Entity.Prescription;
import com.diagnosticapplication.Service.PrescriptionService;

import java.util.List;
@Controller
public class PrescriptionController {
    @Autowired
	PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }
    @GetMapping("/getPrescriptionById/{prescriptionId}")
    public Prescription getPrescriptionById(@PathVariable Long prescriptionId) {
        return prescriptionService.getPrescriptionById(prescriptionId);
    }
    @GetMapping("/getAllPrescriptions")
    public List<Prescription> getAllPrescriptions() {
        return prescriptionService.getAllPrescriptions();
    }
    @PostMapping("/createPrescription")
    public Prescription createPrescription(@RequestBody Prescription prescription) {
        return prescriptionService.createPrescription(prescription, prescription.getUserId());
    }
    @PutMapping("/updatePrescription/{prescriptionId}")
    public Prescription updatePrescription(@PathVariable Long prescriptionId, @RequestBody Prescription prescription) {
        return prescriptionService.updatePrescription(prescriptionId, prescription);
    }
    @DeleteMapping("deletePrescription/{prescriptionId}")
    public void deletePrescription(@PathVariable Long prescriptionId) {
        prescriptionService.deletePrescription(prescriptionId);
    }
}