package ufjf.dcc061.payroll_pro;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PayrollProApplication {
	public static void main(String[] args) {
		SpringApplication.run(PayrollProApplication.class, args);

	}

	@Bean
	public CommandLineRunner demo(ColaboradorRepository colaboradorRepository) {
		return (args) -> {
			colaboradorRepository
					.save(new Colaborador("202065245C", "Antônio", new Date(), null, "Ativo", 10.0, "Desenvolvedor"));
		};
	}

}
