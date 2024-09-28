package CouponsProject2.Services;

import CouponsProject2.Beans.Coupon;
import CouponsProject2.Repositories.CompanyRepository;
import CouponsProject2.Repositories.CouponRepository;
import CouponsProject2.Repositories.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private CompanyRepository companyRepository;
    private final CouponRepository couponRepository;
    private CustomerRepository customerRepository;

    public CustomerService(CompanyRepository companyRepository, CouponRepository couponRepository, CustomerRepository customerRepository) {
        this.companyRepository = companyRepository;
        this.couponRepository = couponRepository;
        this.customerRepository = customerRepository;
    }

    public void purchaseCoupon(Coupon coupon){//need to fix this method!!!!!!!!!!!!!!!
        couponRepository.save(coupon);
    }

























}
