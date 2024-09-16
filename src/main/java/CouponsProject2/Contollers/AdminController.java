package CouponsProject2.Contollers;

import CouponsProject2.Beans.Company;
import CouponsProject2.Services.AdminService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("admin")
public class AdminController {
    private final AdminService service;

    public AdminController(AdminService service) {
        this.service = service;
    }

    @PostMapping("add-company")
    public void addCompany(@RequestBody Company company) {
        service.addCompany(company);
    }
}
