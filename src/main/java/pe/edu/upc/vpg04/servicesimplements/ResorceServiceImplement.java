package pe.edu.upc.vpg04.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.vpg04.entities.Resource;
import pe.edu.upc.vpg04.repositories.IResourceRepository;
import pe.edu.upc.vpg04.servicesinterfaces.IResourceService;

import java.time.LocalDate;
import java.util.List;

@Service
public class ResorceServiceImplement implements IResourceService {

    @Autowired
    private IResourceRepository rR;

    @Override
    public List<Resource> list() {
        return rR.findAll();
    }

    @Override
    public void insert(Resource resour) {
        rR.save(resour);
    }

    @Override
    public void update(Resource resour) {
        rR.save(resour);
    }

    @Override
    public Resource listId(int id) {
        return rR.findById(id).orElse(new Resource());
    }

    @Override
    public void delete(int id) {
        rR.deleteById(id);
    }

    @Override
    public List<String[]> Rmenosutilizado() {
        return rR.Rmenosutilizado();
    }

    @Override
    public List<String[]> tiporecursomasutilizad(LocalDate fechaInicio, LocalDate fechaFin) {
        return rR.tiporecursomasutilizado(fechaInicio, fechaFin);
    }

}
