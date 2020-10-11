package AutoWithAll.AutoWithAll.repository;

import AutoWithAll.AutoWithAll.models.Advertisement;
import AutoWithAll.AutoWithAll.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;
import org.springframework.util.RouteMatcher;


import java.util.List;
import java.util.Optional;

@Repository
public interface AdRepository extends JpaRepository<Advertisement,Long> {

    @Override
    Optional<Advertisement> findById(Long id);
    boolean existsById(Long id);

    @Override
    List<Advertisement> findAll();



    List<Advertisement> findByUser(User user);



    List<Advertisement> findAllByUser(User user);

    @Query(value = "Select u FROM Advertisement u where u.falg= 1")
    List<Advertisement> getConfirmAd();


    @Query(value = "select u from Advertisement u where u.falg=0")
    List<Advertisement> getPendingAd();

    @Query(value = "SELECT count(id) FROM Advertisement where user = :user and falg = 0")
    public Long rcount(@Param("user") User user);

    @Query(value = "SELECT count(id) FROM Advertisement where user = :user and falg = 1")
    public Long pcount(@Param("user") User user);

}
