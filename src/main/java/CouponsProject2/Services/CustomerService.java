package CouponsProject2.Services;

import CouponsProject2.Beans.Coupon;
import CouponsProject2.Beans.Customer;
import CouponsProject2.Exceptions.AlreadyExistException;
import CouponsProject2.Exceptions.ExpiredDateException;
import CouponsProject2.Exceptions.NotExistException;
import CouponsProject2.Exceptions.OutOfStockException;
import CouponsProject2.Repositories.CouponRepository;
import CouponsProject2.Repositories.CustomerRepository;
import CouponsProject2.Utils.Category;
import CouponsProject2.Utils.ClientService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

@Service
public class CustomerService implements ClientService {
    private final CouponRepository couponRepository;
    private final CustomerRepository customerRepository;
    private int customerId;

    public CustomerService(CouponRepository couponRepository, CustomerRepository customerRepository) {
        this.couponRepository = couponRepository;
        this.customerRepository = customerRepository;
    }

    public boolean login(String email, String password) throws NotExistException {
        Customer customer = customerRepository.findByEmailAndPassword(email, password);
        if (customer != null) {
            customerId = customer.getId();
            return true;
        }
        throw new NotExistException("The email or the password is not correct");
    }

    public void purchaseCoupon(Coupon coupon) throws NotExistException, OutOfStockException, ExpiredDateException, AlreadyExistException {
        if (!couponRepository.existsById(coupon.getId())) {
            throw new NotExistException("This coupon does not exist");
        }
        if (coupon.getAmount() <= 0) {
            throw new OutOfStockException("The coupon is out of stock");
        }
        Date currentDate = new Date();
        if (currentDate.after(coupon.getEndDate())) {
            throw new ExpiredDateException("The expiration date is left!");
        }
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new NotExistException("We did not find a customer to purchase the coupon, please log in first"));
        Set<Coupon> coupons = getCustomerCoupons();
        for (Coupon purchasedCoupon : coupons) {
            if (coupon.getId() == purchasedCoupon.getId())
                throw new AlreadyExistException("This customer already purchased this coupon");
        }
        coupons.add(coupon);
        customer.setCoupons(coupons);
        customerRepository.save(customer);
        Coupon coupon1 = couponRepository.findById(coupon.getId()).orElseThrow();
        coupon1.setAmount(coupon1.getAmount() - 1);
    }

    public Set<Coupon> getCustomerCoupons() {
        Customer connectedCustomer = customerRepository.findById(customerId).orElseThrow();
        return connectedCustomer.getCoupons();
    }

    public ArrayList<Coupon> getCustomerCoupons(Category category) {
        Customer connectedCustomer = customerRepository.findById(customerId).orElseThrow();
        return new ArrayList<>(connectedCustomer.getCoupons().stream().filter((coupon)-> coupon.getCategory() == category).toList());
    }

    public ArrayList<Coupon> getCustomerCoupons(double maxPrice) {
        Customer connectedCustomer = customerRepository.findById(customerId).orElseThrow();
        return new ArrayList<>(connectedCustomer.getCoupons().stream().filter((coupon)-> coupon.getPrice() <= maxPrice).toList());
    }

    public Customer getCustomerDetails(){
        return customerRepository.findById(customerId).orElseThrow();
    }




}
