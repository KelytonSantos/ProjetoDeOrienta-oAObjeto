package model;

import java.util.ArrayList;
import java.util.List;

public class Classe {

    private String nome;
    private Integer cargaHoraria;
    private List<Turma> turma = new ArrayList<>();

    public Classe() {
        this.nome = "";
        this.cargaHoraria = 0;
    }

    public Classe(String nome, Integer cargaHoraria) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public List<Turma> getTurma() {
        return turma;
    }

    public void setTurma(List<Turma> turma) {
        this.turma = turma;
    }
}
