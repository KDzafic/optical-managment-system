package optic.service.optic.patient.repository;

import optic.service.optic.patient.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, String> {

    boolean existsByJmbg(String jmbg);

    boolean existsByPhoneNumber(String phoneNumber);

    boolean existsByEmail(String email);
}
