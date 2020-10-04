package AutoWithAll.AutoWithAll.repository;

import AutoWithAll.AutoWithAll.models.Advertisement;
import AutoWithAll.AutoWithAll.models.LPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface LPlanRepository extends JpaRepository<LPlan,Long> {
    @Override
    Optional<LPlan> findById(Long aLong);

    @Override
    List<LPlan> findAll();

//    Advertisement<LPlan> findByAdId(Long AdId, Pageable pageable);
//    Optional<Comment> findByIdAndPostId(Long id, Long postId);
}