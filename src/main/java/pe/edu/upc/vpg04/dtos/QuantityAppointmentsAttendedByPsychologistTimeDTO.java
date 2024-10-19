package pe.edu.upc.vpg04.dtos;

public class QuantityAppointmentsAttendedByPsychologistTimeDTO {
    private int psychologistId;
    private String psychologistName;
    private String psychologistLastName;
    private int quantityAppointmentsAttended;

    public int getPsychologistId() {
        return psychologistId;
    }

    public void setPsychologistId(int psychologistId) {
        this.psychologistId = psychologistId;
    }

    public String getPsychologistName() {
        return psychologistName;
    }

    public void setPsychologistName(String psychologistName) {
        this.psychologistName = psychologistName;
    }

    public String getPsychologistLastName() {
        return psychologistLastName;
    }

    public void setPsychologistLastName(String psychologistLastName) {
        this.psychologistLastName = psychologistLastName;
    }

    public int getQuantityAppointmentsAttended() {
        return quantityAppointmentsAttended;
    }

    public void setQuantityAppointmentsAttended(int quantityAppointmentsAttended) {
        this.quantityAppointmentsAttended = quantityAppointmentsAttended;
    }
}
