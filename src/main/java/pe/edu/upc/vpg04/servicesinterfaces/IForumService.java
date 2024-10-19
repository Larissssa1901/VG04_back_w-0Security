package pe.edu.upc.vpg04.servicesinterfaces;


import pe.edu.upc.vpg04.entities.Forum;

import java.util.List;

public interface IForumService {
    public void insert (Forum forum);
    public void update (Forum forum);

    public void delete (int id);
    public List<Forum> list();
    public Forum listId (int id);
    //agregar los otros US que sirvan
    public List<String[]>ForosMasActivosEnElEltimoMes ();
    public List<String[]>CantidadDeForosQueTieneUnPsicologo();
}
