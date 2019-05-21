package ps.pl.gc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ps.pl.gc.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
