package CouponsProject2.Services;
import CouponsProject2.Exceptions.NotExistException;
import org.springframework.stereotype.Component;

@Component
public class LoginManager {
    private final AdminService adminService;
    private final CompanyService companyService;
    private final CustomerService customerService;

    private LoginManager(AdminService adminService, CompanyService companyService, CustomerService customerService) {
        this.adminService = adminService;
        this.companyService = companyService;
        this.customerService = customerService;
    }

    public ClientService login(String email, String password, ClientType clientType) throws NotExistException {
        switch (clientType){
            case Administrator:
                if (adminService.login(email,password))
                    return adminService;
                break;
            case Company:
                if (companyService.login(email,password))
                    return companyService;
                 break;
            case Customer:
                if (customerService.login(email,password))
                    return customerService;
        }
        return null;
    }
}
