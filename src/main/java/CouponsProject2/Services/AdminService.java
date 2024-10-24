package CouponsProject2.Services;
import CouponsProject2.Beans.Company;
import CouponsProject2.Beans.Customer;
import CouponsProject2.Exceptions.AlreadyExistException;
import CouponsProject2.Exceptions.NotExistException;
import CouponsProject2.Repositories.CompanyRepository;
import CouponsProject2.Repositories.CouponRepository;
import CouponsProject2.Repositories.CustomerRepository;
import CouponsProject2.Utils.ClientService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class AdminService implements ClientService {
    private final CompanyRepository companyRepository;
    private final CustomerRepository customerRepository;
    private final CouponRepository couponRepository;
    private final CompanyService companyService;

    public AdminService(CompanyRepository companyRepository, CustomerRepository customerRepository, CouponRepository couponRepository, CompanyService companyService) {
        this.companyRepository = companyRepository;
        this.customerRepository = customerRepository;
        this.couponRepository = couponRepository;
        this.companyService = companyService;
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

    public boolean deleteCompany(int companyId) throws NotExistException {
        if (companyRepository.existsById(companyId)) {
            companyService.getCompanyCoupons();
            companyRepository.deleteById(companyId);
            return true;
        }
        throw new NotExistException("This company does not exist");
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
        if (customerRepository.existsById(customer.getId())){
            customerRepository.save(customer);}
        else throw new NotExistException("the customer does not exist");
    }

    public boolean deleteCustomer(int customerId) throws NotExistException {
        if (customerRepository.existsById(customerId)) {
            customerRepository.deleteById(customerId);
            return true;
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
