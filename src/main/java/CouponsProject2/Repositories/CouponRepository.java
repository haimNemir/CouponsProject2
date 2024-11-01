package CouponsProject2.Repositories;

import CouponsProject2.Beans.Coupon;
import CouponsProject2.Utils.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {

    List<Coupon> findCouponsByCompanyId(int companyId);

    List<Coupon> findCouponsByCompanyIdAndCategory(int companyId, Category category);

    List<Coupon> findCouponsByCompanyIdAndPriceLessThan(int companyId, double maxPrice);

    ArrayList<Coupon> findByEndDateBefore(Date date);

    @Modifying
    @Query(nativeQuery = true, value = "delete from `customer_coupon` WHERE (`coupon_id` = ?1);")
    void deletePurchasedCoupons(int couponId);



}
