package AutoWithAll.AutoWithAll.repository;

import AutoWithAll.AutoWithAll.models.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdRepository extends JpaRepository<Advertisement,Long> {
    @Override
    Optional<Advertisement> findById(Long id);

    @Override
    List<Advertisement> findAll();
}
