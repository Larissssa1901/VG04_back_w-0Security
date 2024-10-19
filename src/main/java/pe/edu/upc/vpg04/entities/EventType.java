package pe.edu.upc.vpg04.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "EventType")
public class EventType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEventType;

    @Column(name = "title", nullable = false, length = 25)
    private String title;

    @Column(name="description", nullable = false, length = 250)
    private String description;

    public EventType() {
    }

    public EventType(int idEventType, String title, String description) {
        this.idEventType = idEventType;
        this.title = title;
        this.description = description;
    }

    public int getIdEventType() {

        return idEventType;
    }

    public void setIdEventType(int idEventType) {
        this.idEventType = idEventType;
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
}
