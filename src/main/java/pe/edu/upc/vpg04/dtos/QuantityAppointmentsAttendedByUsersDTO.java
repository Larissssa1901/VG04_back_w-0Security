package pe.edu.upc.vpg04.dtos;

public class QuantityAppointmentsAttendedByUsersDTO {
    private int idUser;
    private String nameUser;
    private String lastNameUser;
    private int quantityAppointmentsAttended;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getLastNameUser() {
        return lastNameUser;
    }

    public void setLastNameUser(String lastNameUser) {
        this.lastNameUser = lastNameUser;
    }

    public int getQuantityAppointmentsAttended() {
        return quantityAppointmentsAttended;
    }

    public void setQuantityAppointmentsAttended(int quantityAppointmentsAttended) {
        this.quantityAppointmentsAttended = quantityAppointmentsAttended;
    }
}
