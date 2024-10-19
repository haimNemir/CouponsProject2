package CouponsProject2.Services;

import CouponsProject2.Beans.Company;
import CouponsProject2.Beans.Coupon;
import CouponsProject2.Exceptions.AlreadyExistException;
import CouponsProject2.Exceptions.NotExistException;
import CouponsProject2.Repositories.CompanyRepository;
import CouponsProject2.Repositories.CouponRepository;
import CouponsProject2.Repositories.CustomerRepository;
import CouponsProject2.Utils.Category;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final CustomerRepository customerRepository;
    private final CouponRepository couponRepository;
    private Company connectedCompany;

    public CompanyService(CompanyRepository companyRepository, CustomerRepository customerRepository, CouponRepository couponRepository) {
        this.companyRepository = companyRepository;
        this.customerRepository = customerRepository;
        this.couponRepository = couponRepository;
    }

    public boolean login(String email, String password) throws NotExistException {
        Company company = companyRepository.findByEmailAndPassword(email, password);
        if (company != null) {
            connectedCompany = company;
            return true;
        }
        throw new NotExistException("The email or the password is not correct");
    }

    /**
     *
     * @param coupon
     * @throws AlreadyExistException if the title of the coupon already exist in other coupon of !!!this!!! company
     */
    public void addCoupon(Coupon coupon) throws AlreadyExistException, NotExistException {
        Company company = companyRepository.findById(coupon.getCompany().getId())
                .orElseThrow(()->new NotExistException("We could not find the company of this coupon"));
        // check if there is existing coupon with this title, return true if exists.
        boolean couponExists = company.getCoupons().stream()
                .anyMatch(existingCoupons -> existingCoupons.getTitle().equals(coupon.getTitle()));

        if(couponExists)
            throw new AlreadyExistException("The coupon title already exist");
        couponRepository.save(coupon);
    }

    /**
     *
     * @param updatingCoupon gets Coupon with exist ID, cant updated ID or companyId
     * @throws NotExistException if there is no such coupon by ID.
     */
    public void updateCoupon(Coupon updatingCoupon) throws NotExistException {
        Coupon oldCoupon = couponRepository.findById(updatingCoupon.getId()).orElseThrow(() -> new NotExistException("This coupon does not exist"));
        updatingCoupon.setCompany(oldCoupon.getCompany());
        couponRepository.save(updatingCoupon);
    }

    public boolean deleteCoupon(int couponId) { // not working!!!!!!!!!!!!!!!!!!!!!!!
        if (couponRepository.existsById(couponId)){
            couponRepository.deleteById(couponId);
            return true;
        }
        return false;
    }

    public ArrayList<Coupon> getCompanyCoupons() {
        return new ArrayList<>(couponRepository.findCouponsByCompanyId(connectedCompany.getId()));
    }

    public ArrayList<Coupon> getCompanyCoupons(Category category) {
        return new ArrayList<>(couponRepository.findCouponsByCompanyIdAndCategory(connectedCompany.getId(), category));
    }

    public ArrayList<Coupon> getCompanyCoupons(double maxPrice) {
        return new ArrayList<>(couponRepository.findCouponsByCompanyIdAndPriceLessThan(connectedCompany.getId(), maxPrice));
    }

    public Company getCompanyDetails(){
        return connectedCompany;
    }
}
