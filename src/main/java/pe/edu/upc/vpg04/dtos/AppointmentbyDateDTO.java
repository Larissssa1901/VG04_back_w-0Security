package pe.edu.upc.vpg04.dtos;

import java.time.LocalDate;

public class AppointmentbyDateDTO {
    private int psychologyId;
    private int veteranId;
    private LocalDate appointmentDate;

    public int getPsychologyId() {
        return psychologyId;
    }

    public void setPsychologyId(int psychologyId) {
        this.psychologyId = psychologyId;
    }

    public int getVeteranId() {
        return veteranId;
    }

    public void setVeteranId(int veteranId) {
        this.veteranId = veteranId;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
}
