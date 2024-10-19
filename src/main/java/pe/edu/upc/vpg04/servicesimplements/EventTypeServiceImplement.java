package pe.edu.upc.vpg04.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.vpg04.entities.EventType;
import pe.edu.upc.vpg04.repositories.IEventTypeRepository;
import pe.edu.upc.vpg04.servicesinterfaces.IEventTypeService;

import java.util.List;
@Service
public class EventTypeServiceImplement implements IEventTypeService {
    @Autowired
    private IEventTypeRepository eR;
    @Override
    public List<EventType> list() {
        return eR.findAll();
    }

    @Override
    public void insert(EventType ety) {
        eR.save(ety);

    }

    @Override
    public EventType listId(int id) {
        return eR.findById(id).orElse(new EventType());
    }

    @Override
    public void delete(int id) {
        eR.deleteById(id);

    }

    @Override
    public void update(EventType ety) {
        eR.save(ety);

    }

    @Override
    public List<EventType> buscar(String etype) {
        return eR.buscar(etype);
    }
}
