package softuni.linkedout_validationlab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.linkedout_validationlab.model.entity.UserRoleEntity;
import softuni.linkedout_validationlab.model.entity.enums.UserRole;


@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, String> {

    UserRoleEntity findByRole(UserRole userRole);
}
