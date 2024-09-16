package CouponsProject2.Services;

import CouponsProject2.Beans.Company;
import CouponsProject2.Beans.Customer;
import CouponsProject2.Exceptions.NotExistException;
import CouponsProject2.Repositories.CompanyRepository;
import CouponsProject2.Repositories.CouponRepository;
import CouponsProject2.Repositories.CustomerRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Objects;

@Service
public class AdminService {
    private final CompanyRepository companyRepository;
    private final CustomerRepository customerRepository;
    private CouponRepository couponRepository;

    public AdminService(CompanyRepository companyRepository, CustomerRepository customerRepository, CouponRepository couponRepository) {
        this.companyRepository = companyRepository;
        this.customerRepository = customerRepository;
        this.couponRepository = couponRepository;
    }

    public boolean login(String email, String password) {
        return Objects.equals(email, "admin@admin.com") && Objects.equals(password, "admin");
    }


    /**
     * Add Company to the DB if there is no such Company with this name or email.
     */
    public void addCompany(Company company) {
        companyRepository.save(company);
    }

    public void updateCompany(Company company){
        companyRepository.save(company);
    }

    public void deleteCompany(int companyId){
        companyRepository.deleteById(companyId);
    }

    public ArrayList<Company> getAllCompanies(){
        return (ArrayList<Company>) companyRepository.findAll();
    }

    public Company getOneCompany(int companyId) throws NotExistException {
        return companyRepository.findById(companyId).orElseThrow(()->(new NotExistException("This company does not exist")));
    }

    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void updateCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void deleteCustomer(int customerId) {
        customerRepository.deleteById(customerId);
    }

    public ArrayList<Customer> getAllCustomers(){
        return (ArrayList<Customer>) customerRepository.findAll();
    }

    public Customer getOneCustomer(int customerId) throws NotExistException {
        return customerRepository.findById(customerId).orElseThrow(()->new NotExistException("This customer does not exist"));
    }
}
