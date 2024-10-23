package pe.edu.upc.vpg04.servicesinterfaces;


import pe.edu.upc.vpg04.entities.Forum;
import pe.edu.upc.vpg04.entities.Resource;

import java.time.LocalDate;
import java.util.List;

public interface IResourceService {
    public List<Resource> list();
    public void insert(Resource resour);
    public void update (Resource resour);
    public Resource listId (int id);
    public void delete (int id);
    List<String[]> Rmenosutilizado();
    List<String[]> tiporecursomasutilizad(LocalDate fechaInicio, LocalDate fechaFin);
}
