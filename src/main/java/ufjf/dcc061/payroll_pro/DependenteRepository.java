package ufjf.dcc061.payroll_pro;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DependenteRepository extends JpaRepository<Dependente, Long> {
    // Métodos customizados podem ser adicionados conforme necessário.
}
