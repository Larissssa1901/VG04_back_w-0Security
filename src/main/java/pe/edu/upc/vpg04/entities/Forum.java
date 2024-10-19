package pe.edu.upc.vpg04.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity //mapeo ORL
@Table(name = "Forum")
public class Forum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title", length = 50, nullable = false)
    private String title;

    @Column(name = "description", length = 100, nullable = false)
    private String description;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    // Relación con la taba Users [psiciologo]
    @ManyToOne
    @JoinColumn(name = "psychologistid")
    private Users psychologist;


    public Forum() {
    }

    public Forum(Integer id, String description, String title, LocalDate date, Users psychologist) {
        this.id = id;
        this.description = description;
        this.title = title;
        this.date = date;
        this.psychologist = psychologist;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Users getPsychologist() {
        return psychologist;
    }

    public void setPsychologist(Users psychologist) {
        this.psychologist = psychologist;
    }
}
