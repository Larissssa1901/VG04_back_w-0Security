package pe.edu.upc.vpg04.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.vpg04.entities.EventType;

import java.util.List;

public interface IEventTypeRepository extends JpaRepository<EventType, Integer> {
    @Query("SELECT ety from EventType ety where ety.title like %:titulo%")
    public List<EventType> buscar(@Param("titulo") String titulo);
}
