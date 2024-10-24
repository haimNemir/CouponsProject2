package CouponsProject2.Repositories;

import CouponsProject2.Beans.Company;
import CouponsProject2.Beans.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
    boolean existsByEmailOrPassword(String email, String password);
    Company findByEmailAndPassword(String email, String password);



}
