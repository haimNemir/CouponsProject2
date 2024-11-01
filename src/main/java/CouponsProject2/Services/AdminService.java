package CouponsProject2.Services;

import CouponsProject2.Beans.Company;
import CouponsProject2.Beans.Coupon;
import CouponsProject2.Beans.Customer;
import CouponsProject2.Exceptions.AlreadyExistException;
import CouponsProject2.Exceptions.NotExistException;
import CouponsProject2.Repositories.CompanyRepository;
import CouponsProject2.Repositories.CouponRepository;
import CouponsProject2.Repositories.CustomerRepository;
import CouponsProject2.Utils.ClientService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class AdminService implements ClientService {
    private final CompanyRepository companyRepository;
    private final CustomerRepository customerRepository;
    private final CouponRepository couponRepository;

    public AdminService(CompanyRepository companyRepository, CustomerRepository customerRepository, CouponRepository couponRepository) {
        this.companyRepository = companyRepository;
        this.customerRepository = customerRepository;
        this.couponRepository = couponRepository;
    }

    public boolean login(String email, String password) throws NotExistException {
        if (Objects.equals(email, "admin@admin.com") && Objects.equals(password, "admin")) {
            return true;
        }
        throw new NotExistException("The email or the password is not correct");
    }

    /**
     * Add Company to the DB if there is no such Company with this name or email.
     */
    public void addCompany(Company company) throws AlreadyExistException {
        if (companyRepository.existsByEmailOrPassword(company.getEmail(), company.getPassword())) {
            throw new AlreadyExistException("This Company already exist");
        } else {
            companyRepository.save(company);
        }
    }

    /**
     * @param company get Company with ID, and update the same Company in the DB by the values in the "Company".
     *                This method will not update the ID and the name of the Company.
     * @throws NotExistException if there is no Company with this ID it will throw Exception.
     */
    public void updateCompany(Company company) throws NotExistException {
        Company companyDB = companyRepository.findById(company.getId()).orElseThrow(() -> new NotExistException("This company does not exist"));
        company.setName(companyDB.getName());
        companyRepository.save(company);
    }

    @Transactional // for telling Spring: this method is from INSERT/UPDATE/DELETE
    public void deleteCompany(int companyId) {
        ArrayList<Coupon> companyCoupon = (ArrayList<Coupon>) couponRepository.findCouponsByCompanyId(companyId);
        for (Coupon coupon : companyCoupon) {
            System.out.println(coupon);
            couponRepository.deletePurchasedCoupons(coupon.getId());
            couponRepository.deleteById(coupon.getId());
        }
        companyRepository.deleteById(companyId);
    }

    public ArrayList<Company> getAllCompanies() throws NotExistException {
        ArrayList<Company> companies = (ArrayList<Company>) companyRepository.findAll();
        if (!(companies.isEmpty()))
            return (ArrayList<Company>) companyRepository.findAll();
        else throw new NotExistException("There are no companies yet");
    }

    public Company getOneCompany(int companyId) throws NotExistException {
        return companyRepository.findById(companyId).orElseThrow(() -> (new NotExistException("This company does not exist")));
    }

    /**
     * add new customer to the DB if there is no such customer with this email over there
     */
    public void addCustomer(Customer customer) throws AlreadyExistException {
        if (customerRepository.existsByEmail(customer.getEmail()))
            throw new AlreadyExistException("Cant added customer, the email is already taken");
        customerRepository.save(customer);
    }

    public void updateCustomer(Customer customer) throws NotExistException {
        if (customerRepository.existsById(customer.getId())) {
            customerRepository.save(customer);
        } else throw new NotExistException("the customer does not exist");
    }

    public void deleteCustomer(int customerId) throws NotExistException {
        if (customerRepository.existsById(customerId)) {
            customerRepository.deleteById(customerId);
            return;
        }
        throw new NotExistException("This customer does not exist");
    }

    public Customer getOneCustomer(int customerId) throws NotExistException {
        return customerRepository.findById(customerId).orElseThrow(() -> new NotExistException("This customer does not exist"));
    }

    public ArrayList<Customer> getAllCustomers() throws NotExistException {
        ArrayList<Customer> customers = (ArrayList<Customer>) customerRepository.findAll();
        if (!(customers.isEmpty()))
            return (ArrayList<Customer>) customerRepository.findAll();
        else throw new NotExistException("There are no customers yet");
    }
}
