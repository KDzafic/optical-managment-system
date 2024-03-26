package optic.service.optic.visit.repository;

import optic.service.optic.visit.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VisitRepository extends JpaRepository<Visit, String> {
    @Query("select v from Visit v where v.patient.id = :patientId")
    List<Visit> findAllByPatientId(String patientId);
}
