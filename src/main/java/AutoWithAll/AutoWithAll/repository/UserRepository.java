package AutoWithAll.AutoWithAll.repository;

import AutoWithAll.AutoWithAll.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);

    @Override
    Optional<User> findById(Long aLong);

    boolean existsByUsername(String username);
//    boolean existsByEmail(String username);
    boolean existsByNic(String nic);
    @Override
    List<User> findAll();

    //@Query("select count (us.id) from user us")
    //List<Integer> getUserCount();


}
