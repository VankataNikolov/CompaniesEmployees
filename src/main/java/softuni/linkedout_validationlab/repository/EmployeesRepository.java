package softuni.linkedout_validationlab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import softuni.linkedout_validationlab.model.entity.EmployeeEntity;

@Repository
public interface EmployeesRepository extends JpaRepository<EmployeeEntity, String> {

    @Modifying
    @Query("delete from EmployeeEntity e where e.id=:id")
    int deleteEmployee(@Param("id") String id);

}
