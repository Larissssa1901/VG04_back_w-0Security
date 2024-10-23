package pe.edu.upc.vpg04.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.vpg04.entities.Event;

import java.util.List;
@Repository
public interface IEventRepository extends JpaRepository<Event, Integer> {
    // Query for quantity of veterans in each event
    @Query(value = "SELECT e.id AS eventId, COUNT(u.id) as userxEvent " +
            "FROM users u " +
            "JOIN event e " +
            "ON u.id = e.veteran_id " +
            "GROUP BY e.id", nativeQuery = true)
    public List<String[]> quatityVeteransinEvent();

    @Query(value = "SELECT e.id AS eventId, COUNT(e.id) as qpsicoevent " +
            "FROM event e " +
            "JOIN users u " +
            "ON e.psychologist_id = u.id " + // assuming psychologist is linked through this column
            "GROUP BY e.id", nativeQuery = true)
    public List<String[]> quatityPsicoEvent();

}
