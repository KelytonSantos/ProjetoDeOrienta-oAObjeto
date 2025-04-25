package model;

public class AlunoEspecial extends Aluno {
    private Boolean alunoEspecial;

    public AlunoEspecial() {
        this.alunoEspecial = Boolean.valueOf(false);
    }

    public AlunoEspecial(Boolean alunoEspecial) {
        this.alunoEspecial = Boolean.valueOf(alunoEspecial);
    }

    public Boolean getAlunoEspecial() {
        return alunoEspecial;
    }

    public void setAlunoEspecial(Boolean alunoEspecial) {
        this.alunoEspecial = alunoEspecial;
    }
}
