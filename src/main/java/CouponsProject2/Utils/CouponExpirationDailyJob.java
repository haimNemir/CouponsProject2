package CouponsProject2.Utils;
import CouponsProject2.Beans.Coupon;
import CouponsProject2.Repositories.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Date;
import static java.lang.Thread.sleep;

@Component
public class CouponExpirationDailyJob implements Runnable {

    @Autowired
    private CouponRepository couponRepository;

    public CouponExpirationDailyJob() {
    }

    @Override
    public void run() {
        while (true) {
            try {
                Date currentDate = new Date();
                ArrayList<Coupon> expiredCoupons = couponRepository.findByEndDateBefore(currentDate);
                for (Coupon coupon : expiredCoupons) {
                    couponRepository.deleteById(coupon.getId());
                }
              sleep(3_600_000 * 24); // 24 hours
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted!!");
                break;
            }
        }
    }
}
