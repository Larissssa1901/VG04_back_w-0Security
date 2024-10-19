package pe.edu.upc.vpg04.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name",length = 100,nullable = false)
    private String name;
    @Column(nullable = false)
    private LocalDate date;
    @Column(name = "status",length = 50,nullable = false)
    private String status;
    @ManyToOne
    @JoinColumn(name = "psychologistId")
    private Users psychologist;
    @ManyToOne
    @JoinColumn(name = "veteranId")
    private Users veteran;

    public Appointment() {
    }

    public Appointment(int id, String name, LocalDate date, String status, Users psychologist, Users veteran) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.status = status;
        this.psychologist = psychologist;
        this.veteran = veteran;
    }

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

//Pendiente: La cita está programada, pero aún no ha ocurrido.
//Completada: La cita ha sido realizada.
//Cancelada: La cita fue cancelada por alguna razón.
//Reprogramada: La cita fue movida a otra fecha.