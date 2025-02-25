package ufjf.dcc061.payroll_pro;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FolhaDePagamentoRepository extends JpaRepository<FolhaDePagamento, Long> {
    // Métodos customizados podem ser adicionados se necessário.
}
