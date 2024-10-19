package pe.edu.upc.vpg04.dtos;

import pe.edu.upc.vpg04.entities.Resource;
import pe.edu.upc.vpg04.entities.Users;

import java.time.LocalDate;

public class UseResourcesDTO {
    private int iduso;
    private LocalDate fecha;
    private Users usuario;
    private Resource recurso;

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
