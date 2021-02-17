package softuni.linkedout_validationlab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.linkedout_validationlab.model.entity.EmployeeEntity;

@Repository
public interface EmployeesRepository extends JpaRepository<EmployeeEntity, String> {
}
