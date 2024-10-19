package pe.edu.upc.vpg04.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.vpg04.entities.Users;

@Repository
public interface IUserRepository extends JpaRepository<Users, Integer> {
    public Users findByUsername(String username);
}