package AutoWithAll.AutoWithAll.repository;

import AutoWithAll.AutoWithAll.models.ReportAd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReportAdRepository extends JpaRepository<ReportAd,Long> {
    @Override
    Optional<ReportAd> findById(Long id);

//    findById(Long id);
}
