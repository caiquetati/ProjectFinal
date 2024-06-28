package TokioFinal.ProjectWork.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Servico")
public class Perfil_Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nome;
    private Double centroCusto;
    private String userInclusao;

    @Column(name = "data_inclusao")
    private LocalDate dataInclusao;

    private String ativo;

    // Getters e setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getCentroCusto() {
        return centroCusto;
    }

    public void setCentroCusto(Double centroCusto) {
        this.centroCusto = centroCusto;
    }

    public String getUserInclusao() {
        return userInclusao;
    }

    public void setUserInclusao(String userInclusao) {
        this.userInclusao = userInclusao;
    }

    public LocalDate getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(LocalDate dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }
}
