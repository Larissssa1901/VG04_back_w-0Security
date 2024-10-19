package pe.edu.upc.vpg04.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.vpg04.entities.Post;

import java.util.List;

@Repository
public interface IPostRepository extends JpaRepository<Post, Integer> {
    @Query(value = "SELECT \n" +
            "u.username, \n" +
            "u.lastname, \n" +
            "COUNT(p.id) AS total_posts \n" +
            "FROM posts p \n" +
            "JOIN users u \n" +
            "ON p.veteran_id = u.id \n" +
            "GROUP BY u.username, u.lastname \n" +
            "ORDER BY total_posts DESC",nativeQuery = true)
    public List<String[]> quantityPostsByVeteran();
}
