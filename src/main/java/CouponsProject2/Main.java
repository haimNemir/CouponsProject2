package CouponsProject2;

import CouponsProject2.Beans.Company;
import CouponsProject2.Beans.Customer;
import CouponsProject2.Exceptions.AlreadyExistException;
import CouponsProject2.Exceptions.NotExistException;
import CouponsProject2.Services.AdminService;
import CouponsProject2.Services.CompanyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws NotExistException, AlreadyExistException {
        ApplicationContext context = SpringApplication.run(Main.class, args);
        AdminService adminService = context.getBean(AdminService.class);



//		 TODO: in Test Class you need to open try catch with the throws.
//       TODO: add documentation to the app
//      //Admin service-
//		//Add company - good
//      adminService.addCompany(new Company("non3", "non@nonn3", "12346", null));

//      //Get one Company - good
//        Company company2 = adminService.getOneCompany(1);

//      //Update company - good
//      company2.setEmail("Google@gmail.com");
//      company2.setPassword("1234");
//      company2.setName("bbb");
//      adminService.updateCompany(company2);
//      //Delete company - good
//        adminService.deleteCompany(3);
//      //Get all companies - good
//        System.out.println(adminService.getAllCompanies());
//      // Add customer - good
//        adminService.addCustomer(new Customer("ron", "cohen", "ron@gmail.comm", "2222"));
//      // update customer - good
//        Customer customer = adminService.getOneCustomer(2);
//        customer.setFirstName("avraham");
//        adminService.updateCustomer(customer);
//      //Delete customer - good
//        adminService.deleteCustomer(2);
//      //Get all customers - good
//        System.out.println(adminService.getAllCustomers());
        //Get one customer - good
//        System.out.println(adminService.getOneCustomer(3));



//        finished admin service! upload to git
    }

}
