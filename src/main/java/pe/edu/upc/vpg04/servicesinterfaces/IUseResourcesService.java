package pe.edu.upc.vpg04.servicesinterfaces;

import pe.edu.upc.vpg04.entities.UseResources;

import java.util.List;

public interface IUseResourcesService {
    public List<UseResources> listaruso();
    public void insert(UseResources useResources);
}
