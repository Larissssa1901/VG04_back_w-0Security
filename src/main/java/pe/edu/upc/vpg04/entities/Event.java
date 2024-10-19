package pe.edu.upc.vpg04.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Evento")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEvent;

    @Column(name = "name", nullable = false, length = 10)
    private String name;

    @Column(name = "description", nullable = false, length = 10)
    private String description;

    @Column(name = "startDate", nullable = false, length = 10)
    private LocalDate startDate;

    @Column(name = "endDate", nullable = false, length = 10)
    private LocalDate endDate;

    @Column(name = "registrationDate", nullable = false, length = 10)
    private LocalDate registrationDate;

    @ManyToOne
    @JoinColumn(name = "idVeterano")
    private Users verterano;

    @ManyToOne
    @JoinColumn(name = "idPsicologo")
    private Users psicologo;

    @ManyToOne
    @JoinColumn(name = "idTipoEvento")
    private EventType eventType;

    public Event() {
    }

    public Event(int idEvent, String name, String description, LocalDate startDate, LocalDate endDate, LocalDate registrationDate, Users verterano, Users psicologo, EventType eventType) {
        this.idEvent = idEvent;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.registrationDate = registrationDate;
        this.verterano = verterano;
        this.psicologo = psicologo;
        this.eventType = eventType;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Users getVerterano() {
        return verterano;
    }

    public void setVerterano(Users verterano) {
        this.verterano = verterano;
    }

    public Users getPsicologo() {
        return psicologo;
    }

    public void setPsicologo(Users psicologo) {
        this.psicologo = psicologo;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }
}

