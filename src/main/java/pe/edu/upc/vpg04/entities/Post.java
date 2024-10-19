package pe.edu.upc.vpg04.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title",length = 50,nullable = false)
    private String title;
    @Column(name = "comment",length = 150,nullable = false)
    private String comment;
    @Column(nullable = false)
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "veteranId")
    private Users veteran;
    // Relación muchos a uno con Forum
    @ManyToOne
    @JoinColumn(name = "idForum")
    private Forum forum;

    public Post() {
    }

    public Post(int id, String title, String comment, LocalDate date, Users veteran, Forum forum) {
        this.id = id;
        this.title = title;
        this.comment = comment;
        this.date = date;
        this.veteran = veteran;
        this.forum = forum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
//Post
//
//id
//title
//comment
//date
//veteran_id