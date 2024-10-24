package CouponsProject2.Repositories;

import CouponsProject2.Beans.Coupon;
import CouponsProject2.Utils.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {
    boolean existsByTitle(String title);

    List<Coupon> findCouponsByCompanyId(int companyId);

    List<Coupon> findCouponsByCompanyIdAndCategory(int companyId, Category category);

    List<Coupon> findCouponsByCompanyIdAndPriceLessThan(int companyId, double maxPrice);

    ArrayList<Coupon> findByEndDateBefore(Date date);

}
