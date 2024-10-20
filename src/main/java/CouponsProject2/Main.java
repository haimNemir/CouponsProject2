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
//       TODO: fix purchaseCoupon(Need to save a customer with his updated list of coupons) and login methods in customerService
//       TODO: try do convert the Service layer to design pattern "builder" and you will can connect only to method login and he will return the rest of class methods
//       TODO: print conditions with ternary  and lambda and double lambda!
//       TODO: use in the value return of function to do there conditions like: return isWeekend && isMorning;
//       TODO: CustomerService.purchaseCoupons - do with stream().
//       TODO: on service layer think about change the access to methods only after entered with login method by that he will return CustomerService/CompanyService and the rest of the methods will be privates
//       TODO: in the end: delete redundant imports.
//      Admin service-
//      //login- good
//        System.out.println(adminService.login("admin@admin.com","admin"));

//		//Add company - good
//      adminService.addCompany(new Company("non4", "non@nonn4", "2222"));

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
//        adminService.addCustomer(new Customer("ron", "cohen", "ron@gmail.com", "1111"));
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
//        System.out.println(companyService.login("non@nonn3", "123461"));
//      //Add coupon - good
//        companyService.addCoupon(new Coupon(Category.SPA, "massage", "10 alloy as mental therapy", Date.valueOf("2020-09-01"), Date.valueOf("2026-09-01"),25, 1500.0,null, adminService.getOneCompany(1)));
//      //Update coupon- good
//        Coupon coupon = companyService.getOneCoupon(1);
//        coupon.setCategory(Category.CINEMA);
//        coupon.setCompany(adminService.getOneCompany(2));
//        companyService.updateCoupon(coupon);
//      //Delete coupon- not working ! ask nir why I have a foreign key fail if I have cascade.REMOVE
//        System.out.println(companyService.deleteCoupon(1));
        //Get company coupons - good
//        companyService.login("non@nonn2", "1111");
//        System.out.println(companyService.getCompanyCoupons());
//      //Get company coupon by category - good
//        companyService.login("non@nonn2", "1111");
//        System.out.println(companyService.getCompanyCoupons(Category.SPA));
//      //Get company coupon by max price - good
//        companyService.login("non@nonn2", "1111");
//        System.out.println(companyService.getCompanyCoupons(1500));
//      //Get company details - good
//        companyService.login("non@nonn2", "1111");
//        System.out.println(companyService.getCompanyDetails());






//      //Customer service:
//      //Login - good
//        System.out.println(customerService.login("ron@gmail.com","1111"));

//      //purchase coupon - good!!
//        System.out.println(customerService.login("ron@gmail.com","1111"));
//        customerService.purchaseCoupon(companyService.getOneCoupon(1));

        //Get customer coupons - good
//        System.out.println(customerService.login("ron@gmail.com","1111"));
//        System.out.println(customerService.getCustomerCoupons());

        //Get customer coupons by category - good
//        System.out.println(customerService.login("ron@gmail.com","1111"));
//        System.out.println(customerService.getCustomerCoupons(Category.SPA));

        //Get customer coupons by category - good
//        System.out.println(customerService.login("ron@gmail.com","1111"));
//        System.out.println(customerService.getCustomerCoupons(1450));
//        System.out.println(customerService.getCustomerCoupons(1550));

//      //Get customer details - good
//        System.out.println(customerService.login("ron@gmail.com","1111"));
//        System.out.println(customerService.getCustomerDetails());

    }
}
