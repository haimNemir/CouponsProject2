package CouponsProject2.Services;
import CouponsProject2.Beans.Coupon;
import CouponsProject2.Exceptions.AlreadyExistException;
import CouponsProject2.Exceptions.NotExistException;
import CouponsProject2.Repositories.CompanyRepository;
import CouponsProject2.Repositories.CouponRepository;
import CouponsProject2.Repositories.CustomerRepository;
import org.springframework.stereotype.Service;


@Service
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final CustomerRepository customerRepository;
    private final CouponRepository couponRepository;
    private int companyId;

    public CompanyService(CompanyRepository companyRepository, CustomerRepository customerRepository, CouponRepository couponRepository) {
        this.companyRepository = companyRepository;
        this.customerRepository = customerRepository;
        this.couponRepository = couponRepository;
    }

    public boolean login(String email, String password) throws NotExistException {
        if (companyRepository.existsByEmailAndPassword(email, password))
            return true;
        throw new NotExistException("The email or the password is not correct");
    }

    public void addCoupon(Coupon coupon) throws AlreadyExistException {
        if (couponRepository.existsByTitle(coupon.getTitle()))
            throw new AlreadyExistException("The coupon title already exist");
        couponRepository.save(coupon);
    }

}
