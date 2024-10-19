package pe.edu.upc.vpg04.dtos;

import pe.edu.upc.vpg04.entities.Users;

import java.time.LocalDate;

public class ForumDTO {
    private int id;
    private String title;
    private LocalDate date;
    private String description;
    private Users psychologist;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Users getPsychologist() {
        return psychologist;
    }

    public void setPsychologist(Users psychologist) {
        this.psychologist = psychologist;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
