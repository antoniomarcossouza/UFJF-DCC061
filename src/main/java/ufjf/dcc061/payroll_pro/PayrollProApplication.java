package ufjf.dcc061.payroll_pro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "ufjf.dcc061.payroll_pro")
public class PayrollProApplication {
	public static void main(String[] args) {
		SpringApplication.run(PayrollProApplication.class, args);
	}
}
