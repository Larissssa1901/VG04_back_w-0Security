package pe.edu.upc.vpg04.servicesinterfaces;

import pe.edu.upc.vpg04.entities.EventType;

import java.util.List;

public interface IEventTypeService {
    public List<EventType> list();
    public void insert(EventType ety);
    public EventType listId(int id);

    public void delete(int id);

    public void update(EventType ety);

    public List<EventType> buscar(String etype);
}
