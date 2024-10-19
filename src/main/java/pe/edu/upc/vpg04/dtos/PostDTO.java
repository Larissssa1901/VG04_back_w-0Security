package pe.edu.upc.vpg04.dtos;

import pe.edu.upc.vpg04.entities.Forum;
import pe.edu.upc.vpg04.entities.Users;

import java.time.LocalDate;

public class PostDTO {
    private int id;
    private String title;
    private String comment;
    private LocalDate date;
    private Users veteran;
    private Forum forum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Users getVeteran() {
        return veteran;
    }

    public void setVeteran(Users veteran) {
        this.veteran = veteran;
    }

    public Forum getForum() {
        return forum;
    }

    public void setForum(Forum forum) {
        this.forum = forum;
    }
}
