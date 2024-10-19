package pe.edu.upc.vpg04.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="usorecursos")
public class UseResources {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int iduso;
    @Column(name="fecha",nullable=false)
    private LocalDate fecha;
    @ManyToOne
    @JoinColumn(name="idUs")
    private Users usuario;
    @ManyToOne
    @JoinColumn(name="idRe")
    private Resource recurso;
    public UseResources() {}

    public UseResources(int iduso, LocalDate fecha, Users usuario, Resource recurso) {
        this.iduso = iduso;
        this.fecha = fecha;
        this.usuario = usuario;
        this.recurso = recurso;
    }

    public int getIduso() {
        return iduso;
    }

    public void setIduso(int iduso) {
        this.iduso = iduso;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Users getUsuario() {
        return usuario;
    }

    public void setUsuario(Users usuario) {
        this.usuario = usuario;
    }

    public Resource getRecurso() {
        return recurso;
    }

    public void setRecurso(Resource recurso) {
        this.recurso = recurso;
    }
}
