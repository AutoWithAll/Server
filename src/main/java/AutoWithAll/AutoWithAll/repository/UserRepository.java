package AutoWithAll.AutoWithAll.repository;

import AutoWithAll.AutoWithAll.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface    UserRepository extends JpaRepository<User,Long> {
    Optional<User>findByUsername(String username);
    boolean existsByUsername(String username);
//    boolean existsByEmail(String username);
    boolean existsByNic(String nic);
}