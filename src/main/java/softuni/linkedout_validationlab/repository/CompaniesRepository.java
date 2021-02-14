package softuni.linkedout_validationlab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.linkedout_validationlab.model.entity.CompanyEntity;

@Repository
public interface CompaniesRepository extends JpaRepository<CompanyEntity, String> {
    CompanyEntity findByName(String companyName);
}
