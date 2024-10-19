package pe.edu.upc.vpg04.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.vpg04.entities.Appointment;

import java.util.List;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment, Integer> {
    @Query(value = "SELECT u.id AS userId, u.username, u.lastname, \n" +
            "COUNT(a.id) AS cantidadCitasAtendidas \n" +
            "FROM users u \n" +
            "JOIN appointments a \n" +
            "ON u.id = a.veteran_id \n" +
            "WHERE a.status = 'asistido' \n" +
            "GROUP BY u.id, u.username, u.lastname \n" +
            "ORDER BY cantidadCitasAtendidas DESC",nativeQuery = true)
    public List<String[]> quantityAppointmentsAttendedByUsers();
@Query(value = "SELECT \n" +
        "u.id AS psicologoId, \n" +
        "u.username AS namePsicologo, \n" +
        "u.lastname AS apellidoPsicologo, \n" +
        "COUNT(a.id) AS cantidadCitasAtendidas \n" +
        "FROM appointments a \n" +
        "JOIN users u \n" +
        "ON a.psychologist_id = u.id \n" +
        "WHERE a.status = 'asistido' \n" +
        "AND a.date BETWEEN '2024-01-01' AND '2024-12-31' \n" +
        "GROUP BY u.id, u.username, u.lastname \n" +
        "ORDER BY cantidadCitasAtendidas DESC",nativeQuery = true)
    public List<String[]> quantityAppointmentsAttendedByPsychologistTime();
}
