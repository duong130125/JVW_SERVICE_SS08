package ra.session_08.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.session_08.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}