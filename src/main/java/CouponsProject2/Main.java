package CouponsProject2;

import CouponsProject2.Beans.Company;
import CouponsProject2.Beans.Coupon;
import CouponsProject2.Beans.Customer;
import CouponsProject2.Exceptions.AlreadyExistException;
import CouponsProject2.Exceptions.ExpiredDateException;
import CouponsProject2.Exceptions.NotExistException;
import CouponsProject2.Exceptions.OutOfStockException;
import CouponsProject2.Services.AdminService;
import CouponsProject2.Services.CompanyService;
import CouponsProject2.Services.CustomerService;
import CouponsProject2.Utils.Category;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.Date;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws NotExistException, AlreadyExistException, OutOfStockException, ExpiredDateException {
        ApplicationContext context = SpringApplication.run(Main.class, args);
        AdminService adminService = context.getBean(AdminService.class);
        CompanyService companyService = context.getBean(CompanyService.class);
        CustomerService customerService = context.getBean(CustomerService.class);
//        companyService.addCoupon(new Coupon(Category.CINEMA, "Movie", "65% off for IDF soldiers", Date.valueOf("2020-09-01"), Date.valueOf("2026-09-01"),25, 1.0,null, company3));
//        Customer customer2 = new Customer("David", "Bachar", "DavidB@gmail.com", "2222");
//       TODO: check for all company service method if they are mach with the instructions.
//		 TODO: in Test Class you need to open try catch with the throws.
//       TODO: add documentation to the app(Java Docs).
//       TODO: if you have for loop in Collections, use "Predicate" only!
//       TODO: check if the login method in the service layer is redundant.
//       TODO: Change in table coupons_customer to the option to have 2 coupons to one customer.
//       TODO: fix purchaseCoupon(Need to save a customer with his updated list of coupons) and login methods in customerService
//       TODO: try do convert the Service layer to design pattern "builder" and you will can connect only to method login and he will return the rest of class methods
//      //Admin service-
//      //login- good
//        System.out.println(adminService.login("admin@admin.com","admin"));

//		//Add company - good
//      adminService.addCompany(new Company("non3", "non@nonn3", "12346", null));

//      //Get one Company - good
//        Company company2 = adminService.getOneCompany(1);

//      //Update company - good
//      company2.setEmail("Google@gmail.com");
//      company2.setPassword("1234");
//      company2.setName("bbb");
//      adminService.updateCompany(company2);
//      //Delete company - not good!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//        adminService.deleteCompany(8);
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

//      //Company service:
//      //login - good
//        System.out.println(companyService.login("non@nonn3", "12346"));
//      //Add coupon - good
//        companyService.addCoupon(new Coupon(Category.SPA, "massage", "10 alloy as mental therapy", Date.valueOf("2020-09-01"), Date.valueOf("2026-09-01"),25, 1500.0,null, adminService.getOneCompany(1)));










//      //Customer service:
//      //purchase coupon - good!!
//        customerService.login("ron@gmail.com","1111");
//        customerService.purchaseCoupon(companyService.getOneCoupon(1));

    }
}
