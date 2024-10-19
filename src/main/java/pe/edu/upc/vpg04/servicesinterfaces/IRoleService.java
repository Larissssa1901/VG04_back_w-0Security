package pe.edu.upc.vpg04.servicesinterfaces;


import pe.edu.upc.vpg04.entities.Role;

import java.util.List;

public interface IRoleService {
    public void insert(Role rol);

    public List<Role> list();

    public void delete(Integer idRol);

    public Role listarId(Integer idRol);
}
