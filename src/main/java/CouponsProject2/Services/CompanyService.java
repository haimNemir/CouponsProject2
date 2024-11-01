package CouponsProject2.Services;

import CouponsProject2.Beans.Company;
import CouponsProject2.Beans.Coupon;
import CouponsProject2.Exceptions.AlreadyExistException;
import CouponsProject2.Exceptions.NotExistException;
import CouponsProject2.Repositories.CompanyRepository;
import CouponsProject2.Repositories.CouponRepository;
import CouponsProject2.Utils.Category;
import CouponsProject2.Utils.ClientService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
public class CompanyService implements ClientService {
    private final CompanyRepository companyRepository;
    private final CouponRepository couponRepository;
    private int companyId;

    public CompanyService(CompanyRepository companyRepository, CouponRepository couponRepository) {
        this.companyRepository = companyRepository;
        this.couponRepository = couponRepository;
    }

    public boolean login(String email, String password) throws NotExistException {
        Company company = companyRepository.findByEmailAndPassword(email, password);
        if (company != null) {
            companyId = company.getId();
            return true;
        }
        throw new NotExistException("The email or the password is not correct");
    }

    /**
     * @throws AlreadyExistException if the title of the coupon already exist in other coupon of !!!this!!! company
     */
    public void addCoupon(Coupon coupon) throws AlreadyExistException, NotExistException {
        // check if there is existing coupon with this title, return true if exists.
        boolean couponExists = couponRepository.findCouponsByCompanyId(coupon.getCompany().getId()).stream()
                .anyMatch(existingCoupons -> existingCoupons.getTitle().equals(coupon.getTitle()));

        if (couponExists)
            throw new AlreadyExistException("The coupon title already exist");
        couponRepository.save(coupon);
    }

    /**
     * @param updatingCoupon gets Coupon with exist ID, cant updated ID or companyId
     * @throws NotExistException if there is no such coupon by ID.
     */
    public void updateCoupon(Coupon updatingCoupon) throws NotExistException {
        Coupon oldCoupon = couponRepository.findById(updatingCoupon.getId()).orElseThrow(() -> new NotExistException("This coupon does not exist"));
        updatingCoupon.setCompany(oldCoupon.getCompany());
        couponRepository.save(updatingCoupon);
    }

    @Transactional // for telling Spring: this method is from INSERT/UPDATE/DELETE
    public boolean deleteCoupon(int couponId) {
        if (couponRepository.existsById(couponId)) {
            System.out.println("1");
            couponRepository.deletePurchasedCoupons(couponId);
            System.out.println("2");
            couponRepository.deleteById(couponId);
            System.out.println("3");

            return true;
        }
        return false;
    }

    public ArrayList<Coupon> getCompanyCoupons() {
        return new ArrayList<>(couponRepository.findCouponsByCompanyId(companyId));
    }

    public ArrayList<Coupon> getCompanyCoupons(Category category) {
        return new ArrayList<>(couponRepository.findCouponsByCompanyIdAndCategory(companyId, category));
    }

    public ArrayList<Coupon> getCompanyCoupons(double maxPrice) {
        return new ArrayList<>(couponRepository.findCouponsByCompanyIdAndPriceLessThan(companyId, maxPrice));
    }

    public Company getCompanyDetails() {
        return companyRepository.findById(companyId).orElseThrow();
    }
}
