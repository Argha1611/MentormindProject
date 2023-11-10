package com.diagnosticapplication.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.diagnosticapplication.Entity.Prescription;
import com.diagnosticapplication.Repository.PrescriptionRepository;
import com.diagnosticapplication.Repository.UserRepository;
@Service
public class PrescriptionServiceImpl implements PrescriptionService {
	 @Autowired
	PrescriptionRepository prescriptionRepository;
	 @Autowired
	 UserRepository userRepository;

	@Override
	public List<Prescription> getAllPrescriptions() {
		// TODO Auto-generated method stub
		return prescriptionRepository.findAll();
	}

	@Override
	public Prescription createPrescription(Prescription prescription,long userId) {
		// TODO Auto-generated method stub
		if (userRepository.existsById(userId)) {
            prescription.setUserId(userId);
		}
		return prescriptionRepository.save(prescription);
	}
	
	@Override
	public Prescription updatePrescription(Long prescriptionId, Prescription prescription) {
		// TODO Auto-generated method stub
		if (prescriptionRepository.existsById(prescriptionId)) {
            prescription.setPrescriptionId(prescriptionId);
            return prescriptionRepository.save(prescription);
        }

		return null;
	}

	@Override
	public void deletePrescription(Long prescriptionId) {
		// TODO Auto-generated method stub
		prescriptionRepository.deleteById(prescriptionId);
	}

	@Override
	public Prescription getPrescriptionById(Long prescriptionId) {
		// TODO Auto-generated method stub
		{
			Optional<Prescription> prescription = prescriptionRepository.findById(prescriptionId);
			if (prescription.isPresent()) {
				return prescription.get();
			}
			return null;
		}
	}


}
	