package pe.edu.upc.vpg04.dtos;

import pe.edu.upc.vpg04.entities.Users;

import java.time.LocalDate;

public class AppointmentDTO {
    private int id;
    private String name;
    private LocalDate date;
    private String status;
    private Users psychologist;
    private Users veteran;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Users getPsychologist() {
        return psychologist;
    }

    public void setPsychologist(Users psychologist) {
        this.psychologist = psychologist;
    }

    public Users getVeteran() {
        return veteran;
    }

    public void setVeteran(Users veteran) {
        this.veteran = veteran;
    }
}
