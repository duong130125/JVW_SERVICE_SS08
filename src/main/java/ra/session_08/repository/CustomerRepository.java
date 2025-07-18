package ra.session_08.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.session_08.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}