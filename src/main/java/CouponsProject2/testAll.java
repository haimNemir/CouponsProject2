package CouponsProject2;

import CouponsProject2.Beans.Company;
import CouponsProject2.Exceptions.NotExistException;
import CouponsProject2.Services.AdminService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class testAll {
	public static void main(String[] args) throws NotExistException {
		ApplicationContext context = SpringApplication.run(testAll.class, args);



		AdminService adminService = context.getBean(AdminService.class);

//		test:
//		Company company1 = adminService.getOneCompany(1);
//		company1.setName("Google");
//		company1.setEmail("Google@Google.com");
//		company1.setPassword("1234");
//		company1.setCoupons(null);
//		adminService.addCompany(company1);

	}
}
