package CouponsProject2;
import CouponsProject2.Exceptions.AlreadyExistException;
import CouponsProject2.Exceptions.ExpiredDateException;
import CouponsProject2.Exceptions.NotExistException;
import CouponsProject2.Exceptions.OutOfStockException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class, args);
        TestAll testAll = context.getBean(TestAll.class);
        try {
             testAll.test();
        } catch (NotExistException | AlreadyExistException |  OutOfStockException | ExpiredDateException | RuntimeException e) {
            testAll.getCurrentThread().interrupt(); // prevent where we get exceptions in the middle of the proses to continue with "job" forever.
            throw new RuntimeException(e.getMessage());
        }

    }
}
