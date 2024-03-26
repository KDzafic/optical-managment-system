package optic.service.optic.patient.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import optic.service.optic.patient.entity.Patient;
import optic.service.optic.patient.entity.dto.AddPatientDto;
import optic.service.optic.patient.entity.dto.UpdatePatientDto;
import optic.service.optic.patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class PatientService {

    @Autowired
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


    public Patient addPatient(AddPatientDto addPatientDto) {
        Patient patient = new Patient();
        if (patientRepository.existsByEmail(addPatientDto.getEmail())) {
            throw new RuntimeException("Duplicate Email");
        }
        if (patientRepository.existsByJmbg(addPatientDto.getJmbg())) {
            throw new RuntimeException("Duplicate JMBG");
        }
        if (patientRepository.existsByPhoneNumber(addPatientDto.getPhoneNumber())) {
            throw new RuntimeException("Duplicate Phone Number");
        }
        patient.setFirstName(addPatientDto.getFirstName());
        patient.setLastName(addPatientDto.getLastName());
        patient.setEmail(addPatientDto.getEmail());
        patient.setPhoneNumber(addPatientDto.getPhoneNumber());
        patient.setJmbg(addPatientDto.getJmbg());
        patient.setAddress(addPatientDto.getAddress());
        patient.setDateOfBirth(addPatientDto.getDateOfBirth());
        patient.setAdded(LocalDateTime.now());
        patient.setVisits(new ArrayList<>());
        return patientRepository.save(patient);
    }

    public Patient updatePatient(UpdatePatientDto updatePatientDto) {
        Patient patient = patientRepository.findById(updatePatientDto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with id: " + updatePatientDto.getId()));
        patient.setFirstName(updatePatientDto.getFirstName());
        patient.setLastName(updatePatientDto.getLastName());
        if (!Objects.equals(patient.getEmail(), updatePatientDto.getEmail()) && patientRepository.existsByEmail(updatePatientDto.getEmail())) {
            throw new RuntimeException("Duplicate Email");
        }
        patient.setEmail(updatePatientDto.getEmail());
        patient.setAddress(updatePatientDto.getAddress());
        if (!Objects.equals(patient.getPhoneNumber(), updatePatientDto.getPhoneNumber()) && patientRepository.existsByPhoneNumber(updatePatientDto.getPhoneNumber())) {
            throw new RuntimeException("Duplicate Phone Number");
        }
        patient.setPhoneNumber(updatePatientDto.getPhoneNumber());
        return patientRepository.save(patient);
    }

    public List<Patient> getAll() {
        return patientRepository.findAll();
    }
}

