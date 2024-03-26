package optic.service.optic.patient.controller;

import lombok.RequiredArgsConstructor;
import optic.service.optic.patient.entity.Patient;
import optic.service.optic.patient.entity.dto.AddPatientDto;
import optic.service.optic.patient.entity.dto.UpdatePatientDto;
import optic.service.optic.patient.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/patient")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/add-patient")
    public ResponseEntity<Patient> addPatient(@RequestBody AddPatientDto addPatientDto) {
        return ResponseEntity.ok(patientService.addPatient(addPatientDto));
    }

    @PutMapping("/update-patient")
    public ResponseEntity<Patient> updatePatient(@RequestBody UpdatePatientDto updatePatientDto) {
        return ResponseEntity.ok(patientService.updatePatient(updatePatientDto));
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Patient>> getAllPatients() {
        return ResponseEntity.ok(patientService.getAll());
    }
}
