package pe.edu.upc.vpg04.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.vpg04.entities.Resource;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IResourceRepository extends JpaRepository <Resource, Integer> {
    @Query(value = "SELECT r.resourcetype AS recurso,COUNT(ur.id_re) AS total_usos\n" +
            "FROM recursos r\n" +
            "LEFT JOIN usorecursos ur ON r.id = ur.id_re\n" +
            "GROUP BY r.id\n" +
            "Having COUNT(ur.id_re) = 1\n" +
            "ORDER BY total_usos ASC",nativeQuery = true)
    List<String[]> Rmenosutilizado();

    @Query(value = "SELECT r.resourcetype AS recurso, COUNT(ur.id_re) AS total_usos " +
            "FROM recursos r " +
            "JOIN usorecursos ur ON r.id = ur.id_re " +
            "WHERE ur.fecha BETWEEN :fechaInicio AND :fechaFin " +
            "GROUP BY r.id " +
            "ORDER BY total_usos DESC ", nativeQuery = true)
    List<String[]> tiporecursomasutilizado(@Param("fechaInicio") LocalDate fechaInicio, @Param("fechaFin") LocalDate fechaFin);
}
