package AutoWithAll.AutoWithAll.repository;

import AutoWithAll.AutoWithAll.models.ReportAd;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReportAdRepository extends JpaRepository<ReportAd,Long> {
    @Override
    Optional<ReportAd> findById(Long id);

//    findById(Long id);
}
