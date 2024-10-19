package pe.edu.upc.vpg04.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.vpg04.entities.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Integer> {
}
