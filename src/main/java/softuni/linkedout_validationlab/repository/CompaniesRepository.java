package softuni.linkedout_validationlab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import softuni.linkedout_validationlab.model.entity.CompanyEntity;

import java.util.List;

@Repository
public interface CompaniesRepository extends JpaRepository<CompanyEntity, String> {
    CompanyEntity findByName(String companyName);

    @Query("SELECT c.name FROM CompanyEntity c")
    List<String> getAllCompanyNames();

}
