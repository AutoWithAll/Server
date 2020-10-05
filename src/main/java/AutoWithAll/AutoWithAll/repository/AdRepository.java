package AutoWithAll.AutoWithAll.repository;

import AutoWithAll.AutoWithAll.models.Advertisement;
import AutoWithAll.AutoWithAll.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.RouteMatcher;

<<<<<<< HEAD
//import javax.jws.soap.SOAPBinding;
=======
import javax.jws.soap.SOAPBinding;
>>>>>>> master
import java.util.List;
import java.util.Optional;

@Repository
public interface AdRepository extends JpaRepository<Advertisement,Long> {

    @Override
    Optional<Advertisement> findById(Long id);

    @Override
    List<Advertisement> findAll();

<<<<<<< HEAD
    List<Advertisement> findAllByUser(User user);
=======

    List<Advertisement> findAllByUser(User user);

>>>>>>> master
}
