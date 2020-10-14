package AutoWithAll.AutoWithAll.repository;

import AutoWithAll.AutoWithAll.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
}
