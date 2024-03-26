package optic.service.optic.visit.entity.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AddVisitDto {

    private String mainProblem;
    private String vod;
    private String vos;
    private String tod;
    private String tos;
    private String spaltod;
    private String spaltos;
    private String fod;
    private String fos;
    private String interventions;
    private String diagnosis;
    private String control;
    private String therapy;
    private String patientId;

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

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
}
