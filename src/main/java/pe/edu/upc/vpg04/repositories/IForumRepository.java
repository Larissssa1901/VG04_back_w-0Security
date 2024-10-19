package pe.edu.upc.vpg04.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.vpg04.entities.Forum;

import java.util.List;

@Repository
public interface IForumRepository extends JpaRepository<Forum, Integer> {
    //pConsulta foros más activos en un mes
    @Query(value = "SELECT f.id,f.title ,\n" +
            "COUNT(p.id) AS numposts \n" +
            "FROM forum f \n" +
            "JOIN posts p ON f.id = p.id_forum\n" +
            "WHERE p.date > NOW() - INTERVAL '30 DAY' \n" +
            "GROUP BY f.id, f.title \n" +
            "ORDER BY numposts DESC", nativeQuery = true)
    public List<String[]> MostActiveForumsInTheLastMonth();

    //Consulta cantidad de foros realizados por un psicólogo
    @Query(value = "SELECT u.username AS psychologistname, \n" +
            "       u.lastname AS psychologistlastname, \n" +
            "       COUNT(f.id) AS forumcount\n" +
            "FROM forum f\n" +
            "JOIN users u ON f.psychologistid = u.id\n" +
            "GROUP BY u.username, u.lastname\n" +
            "ORDER BY forumcount DESC", nativeQuery = true)
    List<String[]> QuantityForumsByPsychologist();
}
