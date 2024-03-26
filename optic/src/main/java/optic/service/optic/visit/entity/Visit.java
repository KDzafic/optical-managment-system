package optic.service.optic.visit.entity;

import jakarta.persistence.*;
import lombok.*;
import optic.service.optic.patient.entity.Patient;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "VISIT")
public class Visit {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;

    @Column(name = "main_problem")
    private String mainProblem;

    @Column(name = "vod")
    private String vod;

    @Column(name = "vos")
    private String vos;

    @Column(name = "tod")
    private String tod;

    @Column(name = "tos")
    private String tos;

    @Column(name = "spaltod")
    private String spaltod;

    @Column(name = "spaltos")
    private String spaltos;

    @Column(name = "fod")
    private String fod;

    @Column(name = "fos")
    private String fos;

    @Column(name = "date_of_visit")
    private LocalDateTime dateOfVisit;

    @Column(name = "interventions")
    private String interventions;

    @Column(name = "diagnosis")
    private String diagnosis;

    @Column(name = "control")
    private String control;

    @Column(name = "therapy")
    private String therapy;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private Patient patient;

    public String getMainProblem() {
        return mainProblem;
    }

    public void setMainProblem(String mainProblem) {
        this.mainProblem = mainProblem;
    }

    public String getVod() {
        return vod;
    }

    public void setVod(String vod) {
        this.vod = vod;
    }

    public String getVos() {
        return vos;
    }

    public void setVos(String vos) {
        this.vos = vos;
    }

    public String getTod() {
        return tod;
    }

    public void setTod(String tod) {
        this.tod = tod;
    }

    public String getTos() {
        return tos;
    }

    public void setTos(String tos) {
        this.tos = tos;
    }

    public String getSpaltod() {
        return spaltod;
    }

    public void setSpaltod(String spaltod) {
        this.spaltod = spaltod;
    }

    public String getSpaltos() {
        return spaltos;
    }

    public void setSpaltos(String spaltos) {
        this.spaltos = spaltos;
    }

    public String getFod() {
        return fod;
    }

    public void setFod(String fod) {
        this.fod = fod;
    }

    public String getFos() {
        return fos;
    }

    public void setFos(String fos) {
        this.fos = fos;
    }

    public LocalDateTime getDateOfVisit() {
        return dateOfVisit;
    }

    public void setDateOfVisit(LocalDateTime dateOfVisit) {
        this.dateOfVisit = dateOfVisit;
    }

    public String getInterventions() {
        return interventions;
    }

    public void setInterventions(String interventions) {
        this.interventions = interventions;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getControl() {
        return control;
    }

    public void setControl(String control) {
        this.control = control;
    }

    public String getTherapy() {
        return therapy;
    }

    public void setTherapy(String therapy) {
        this.therapy = therapy;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
