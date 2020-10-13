package AutoWithAll.AutoWithAll.repository;

import AutoWithAll.AutoWithAll.models.Advertisement;
import AutoWithAll.AutoWithAll.models.IPlan;
import AutoWithAll.AutoWithAll.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IPlanRepository extends JpaRepository<IPlan,Long> {
    @Override
    Optional<IPlan> findById(Long aLong);

    @Override
    List<IPlan> findAll();

//    List<Advertisement> findAllByUserAndAdvertisement(User user);
}
