package pe.edu.upc.vpg04.servicesinterfaces;


import pe.edu.upc.vpg04.entities.Post;

import java.util.List;

public interface IPostService {
    public void insert (Post post);
    public void update (Post post);

    public void delete (int id);
    public List<Post> list();
    public Post listId (int id);
    public List<String[]> cantidadPublicacionesPorVeteranos();
}
