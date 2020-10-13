package AutoWithAll.AutoWithAll.repository;

import AutoWithAll.AutoWithAll.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);

    @Override
    Optional<User> findById(Long aLong);
    boolean existsByUsername(String username);
    boolean existsByNic(String nic);
    @Override
    List<User> findAll();


    @Query(value = "SELECT u FROM User u where u.roles = :roles")
    List<User> FilterByRole(@Param("roles") String[] roles);


}
