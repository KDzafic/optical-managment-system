package optic.service.optic.visit.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import optic.service.optic.patient.entity.Patient;
import optic.service.optic.patient.repository.PatientRepository;
import optic.service.optic.visit.entity.Visit;
import optic.service.optic.visit.entity.dto.AddVisitDto;
import optic.service.optic.visit.repository.VisitRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitService {
    private final VisitRepository visitRepository;
    private final PatientRepository patientRepository;

    public VisitService(VisitRepository visitRepository, PatientRepository patientRepository) {
        this.visitRepository = visitRepository;
        this.patientRepository = patientRepository;
    }

    public Visit addVisit(AddVisitDto addVisitDto) {
        Visit visit = new Visit();
        visit.setMainProblem(addVisitDto.getMainProblem());
        visit.setVod(addVisitDto.getVod());
        visit.setVos(addVisitDto.getVos());
        visit.setTod(addVisitDto.getTod());
        visit.setTos(addVisitDto.getTos());
        visit.setSpaltod(addVisitDto.getSpaltod());
        visit.setSpaltos(addVisitDto.getSpaltos());
        visit.setFod(addVisitDto.getFod());
        visit.setFos(addVisitDto.getFos());
        visit.setDateOfVisit(LocalDateTime.now());
        visit.setInterventions(addVisitDto.getInterventions());
        visit.setControl(addVisitDto.getControl());
        visit.setControl(addVisitDto.getControl());
        visit.setTherapy(addVisitDto.getTherapy());

        Patient patient = patientRepository.findById(addVisitDto.getPatientId())
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with id: " + addVisitDto.getPatientId()));

        visit.setPatient(patient);

        return visitRepository.save(visit);
    }

    public Visit getVisit(String visitId) {
        return visitRepository.findById(visitId)
                .orElseThrow(() -> new EntityNotFoundException("Visit not found with id: " + visitId));
    }

    public List<Visit> getAllVisitsByPatient(String patientId) {
        return visitRepository.findAllByPatientId(patientId);
    }
}
