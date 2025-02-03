package ufjf.dcc061.payroll_pro;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Colaborador {
    @Id
    private String idColaborador;
    private String nome;
    private Date dataAdmissao;
    private Date dataDemissao;
    private String status;
    private Double salarioBase;
    private String cargo;

    protected Colaborador() {
    }

    public Colaborador(String idColaborador, String nome, Date dataAdmissao, Date dataDemissao, String status,
            Double salarioBase, String cargo) {
        this.idColaborador = idColaborador;
        this.nome = nome;
        this.dataAdmissao = dataAdmissao;
        this.dataDemissao = dataDemissao;
        this.status = status;
        this.salarioBase = salarioBase;
        this.cargo = cargo;
    }

    public String getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(String idColaborador) {
        this.idColaborador = idColaborador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public Date getDataDemissao() {
        return dataDemissao;
    }

    public void setDataDemissao(Date dataDemissao) {
        this.dataDemissao = dataDemissao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(Double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
