package pe.edu.upc.vpg04.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Recursos")
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "resourcetype",length = 50,nullable = false)
    private String resourcetype;
    @Column(name="resourcedescription",length = 400,nullable = false)
    private String resourcedescription;

    @ManyToOne
    @JoinColumn(name = "idUsers")
    private Users use;

    public Resource() {}

    public Resource(int id, String resourcetype, String resourcedescription, Users use) {
        this.id = id;
        this.resourcetype = resourcetype;
        this.resourcedescription = resourcedescription;
        this.use = use;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResourcetype() {
        return resourcetype;
    }

    public void setResourcetype(String resourcetype) {
        this.resourcetype = resourcetype;
    }

    public String getResourcedescription() {
        return resourcedescription;
    }

    public void setResourcedescription(String resourcedescription) {
        this.resourcedescription = resourcedescription;
    }

    public Users getUse() {
        return use;
    }

    public void setUse(Users use) {
        this.use = use;
    }
}
