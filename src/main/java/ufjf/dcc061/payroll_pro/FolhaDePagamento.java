package ufjf.dcc061.payroll_pro;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class FolhaDePagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "colaborador_id", nullable = false)
    private Colaborador colaborador;

    private LocalDate periodo;
    private Double salarioBruto;
    private Double totalDescontos;
    private Double totalLiquido;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public LocalDate getPeriodo() {
        return periodo;
    }

    public void setPeriodo(LocalDate periodo) {
        this.periodo = periodo;
    }

    public Double getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(Double salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    public Double getTotalDescontos() {
        return totalDescontos;
    }

    public void setTotalDescontos(Double totalDescontos) {
        this.totalDescontos = totalDescontos;
    }

    public Double getTotalLiquido() {
        return totalLiquido;
    }

    public void setTotalLiquido(Double totalLiquido) {
        this.totalLiquido = totalLiquido;
    }
}
