package pe.edu.upc.vpg04.dtos;

import pe.edu.upc.vpg04.entities.Users;

public class RoleDTO {
    private int id;
    private String nameRole;
    private Users user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
