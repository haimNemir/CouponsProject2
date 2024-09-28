package CouponsProject2.Repositories;

import CouponsProject2.Beans.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {
    boolean existsByTitle(String title);
}
