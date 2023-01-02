package com.atendimento.hospital.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nome;

    @Column
    private Date data_nascimento;

    @Column
    private String cpf;

    @Column
    private Integer rg;

    @Column
    private Integer nivel_dor;

    @Column
    private String dor;

    @Column
    private boolean alta;


    @ManyToOne
    @JoinColumn(name = "medicacao_id")
    private Medicacao medicacao;



    // Construtor vazio
    public Paciente(){

    }





    //Getter e Setter


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getRg() {
        return rg;
    }

    public void setRg(Integer rg) {
        this.rg = rg;
    }

    public Integer getNivel_dor() {
        return nivel_dor;
    }

    public void setNivel_dor(Integer nivel_dor) {
        this.nivel_dor = nivel_dor;
    }

    public String getDor() {
        return dor;
    }

    public void setDor(String dor) {
        this.dor = dor;
    }

    public Medicacao getMedicacao() {
        return medicacao;
    }

    public void setMedicacao(Medicacao medicacao) {
        this.medicacao = medicacao;
    }

    public boolean isAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }
}
