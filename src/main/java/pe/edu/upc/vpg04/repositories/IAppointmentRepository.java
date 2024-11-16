package pe.edu.upc.vpg04.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.vpg04.entities.Appointment;

import java.time.LocalDate;
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
    @Query(value = "select a.psychologist_id, a.veteran_id, a.date\n" +
            "from appointments a \n" +
            "where a.date = :date ",nativeQuery = true)
    public List<String[]> appoitmentsbyDate(@Param("date") LocalDate date1);

    @Query(value = "SELECT a.id, a.date, a.name, a.status, u_psicologo.lastname AS psychologist_lastname, u_veterano.lastname AS veteran_lastname\n" +
            "FROM appointments a\n" +
            "JOIN users u_psicologo ON a.psychologist_id = u_psicologo.id\n" +
            "JOIN users u_veterano ON a.veteran_id = u_veterano.id\n" +
            "WHERE a.status = 'Cancelada'",nativeQuery = true)
    public List<String[]> cancelledAppointments();
}
