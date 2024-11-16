package pe.edu.upc.vpg04.dtos;

import java.time.LocalDate;

public class CancelledAppointmentsDTO {

    private int idAppointment;
    private LocalDate appointmentDate;
    private String name;
    private String status;
    private String psychologyLastname;
    private String veteranLastname;

    public int getIdAppointment() {
        return idAppointment;
    }

    public void setIdAppointment(int idAppointment) {
        this.idAppointment = idAppointment;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPsychologyLastname() {
        return psychologyLastname;
    }

    public void setPsychologyLastname(String psychologyLastname) {
        this.psychologyLastname = psychologyLastname;
    }

    public String getVeteranLastname() {
        return veteranLastname;
    }

    public void setVeteranLastname(String veteranLastname) {
        this.veteranLastname = veteranLastname;
    }
}
