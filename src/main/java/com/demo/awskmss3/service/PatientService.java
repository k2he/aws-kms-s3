package com.demo.awskmss3.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.awskmss3.domain.Patient;
import com.demo.awskmss3.repository.PatientRepository;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PatientService {

//	@NonNull
//	private KmsCryptoImpl2 kmsCryptoImpl2;
	
	@NonNull
	private PatientRepository patientRepo;
	
	public Patient save(Patient patient) {
		Patient savedPatient = patientRepo.encryptAndSave(patient);
		return savedPatient;
	}
	
	public Patient getPatientById(Long id) {
		Patient patient = patientRepo.findById(id).get();
		return patient;
	}
	
	public List<Patient> getAllPatients() {
		List<Patient> patients = patientRepo.findAll();
		return patients;
	}
}
