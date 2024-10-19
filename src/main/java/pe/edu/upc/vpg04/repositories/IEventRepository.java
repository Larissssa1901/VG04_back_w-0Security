package pe.edu.upc.vpg04.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.vpg04.entities.Event;

import java.util.List;

public interface IEventRepository extends JpaRepository<Event, Integer> {

}
