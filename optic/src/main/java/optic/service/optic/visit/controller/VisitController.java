package optic.service.optic.visit.controller;

import lombok.RequiredArgsConstructor;

import optic.service.optic.visit.entity.Visit;
import optic.service.optic.visit.entity.dto.AddVisitDto;
import optic.service.optic.visit.service.VisitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/visit")
@RequiredArgsConstructor
public class VisitController {
    private final VisitService visitService;

    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    @PostMapping("/add-visit")
    public ResponseEntity<Visit> addVisit(@RequestBody AddVisitDto addVisitDto) {
        return ResponseEntity.ok(visitService.addVisit(addVisitDto));
    }

    @GetMapping("/get")
    public ResponseEntity<Visit> getVisit(@RequestParam String visitId) {
        return ResponseEntity.ok(visitService.getVisit(visitId));
    }

    @GetMapping("/get-all-by-patient")
    public ResponseEntity<List<Visit>> getAllVisitsByPatientId(@RequestParam String patientId) {
        return ResponseEntity.ok(visitService.getAllVisitsByPatient(patientId));
    }
}
