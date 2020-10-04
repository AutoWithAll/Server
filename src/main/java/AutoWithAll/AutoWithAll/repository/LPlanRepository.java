package AutoWithAll.AutoWithAll.repository;

import AutoWithAll.AutoWithAll.models.LPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LPlanRepository extends JpaRepository<LPlan,Long> {
    @Override
    Optional<LPlan> findById(Long aLong);

    @Override
    List<LPlan> findAll();
}
