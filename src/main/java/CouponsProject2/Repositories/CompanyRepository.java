package CouponsProject2.Repositories;

import CouponsProject2.Beans.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
    boolean existsByEmailOrPassword(String email, String password);
}
