package AutoWithAll.AutoWithAll.repository;

import AutoWithAll.AutoWithAll.models.IPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IPlanRepository extends JpaRepository<IPlan,Long> {
    @Override
    Optional<IPlan> findById(Long aLong);

    @Override
    List<IPlan> findAll();
}
