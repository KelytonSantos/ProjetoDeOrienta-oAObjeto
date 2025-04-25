package model;

public class Aluno {
    private String nome;
    private Integer matricula;
    private String curso;

    public Aluno() {
        this.nome = "";
        this.matricula = 0;
        this.curso = "";
    }

    public Aluno(String nome, Integer matricula, String curso) {
        this.nome = nome;

    }
}
