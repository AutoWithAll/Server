package AutoWithAll.AutoWithAll.repository;
import AutoWithAll.AutoWithAll.models.Packages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface PackagesRepository extends JpaRepository<Packages,Long> {
    @Override
    Optional<Packages> findById(Long aLong);

}
