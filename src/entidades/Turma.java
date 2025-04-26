package entidades;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import entidades.ENUM.MetodoDeAvaliacao;
import entidades.ENUM.Modalidade;

public class Turma {
    private Professor professor;
    private Integer semestre;
    private MetodoDeAvaliacao metodoDeAvaliacao;
    private Modalidade modoDeParticipacao;
    private Map<String, LocalTime> horarioDeAula;
    private Integer sala;
    private Integer maxAlunos;
    private Set<Aluno> alunos = new HashSet<>();// escrever metodos

    public Turma() {
        this.professor = new Professor();
        this.semestre = 0;
        this.metodoDeAvaliacao = MetodoDeAvaliacao.MEDIA_SIMPLES;
        this.modoDeParticipacao = Modalidade.PRESENCIAL;
        this.horarioDeAula = new HashMap<>();
        this.sala = 0;
        this.maxAlunos = 190;
    }

    public Turma(Professor professor, Integer semestre, MetodoDeAvaliacao metodoDeAvaliacao,
            Modalidade modoDeParticipacao, Integer maxAlunos) {
        this.professor = professor;
        this.semestre = semestre;
        this.metodoDeAvaliacao = metodoDeAvaliacao;
        this.modoDeParticipacao = modoDeParticipacao;
        this.modoDeParticipacao = modoDeParticipacao;
        this.maxAlunos = maxAlunos;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public MetodoDeAvaliacao getMetodoDeAvaliacao() {
        return metodoDeAvaliacao;
    }

    public void setMetodoDeAvaliacao(MetodoDeAvaliacao metodoDeAvaliacao) {
        this.metodoDeAvaliacao = metodoDeAvaliacao;
    }

    public Modalidade getModoDeParticipacao() {
        return modoDeParticipacao;
    }

    public void setModoDeParticipacao(Modalidade modoDeParticipacao) {
        this.modoDeParticipacao = modoDeParticipacao;
    }

    public Integer getSala() {
        return sala;
    }

    public void setSala(Modalidade modalidade) {
        if (modoDeParticipacao == Modalidade.valueOf(2))
            this.sala = null;
        this.modoDeParticipacao = modalidade;
    }

    public Integer getMaxAlunos() {
        return maxAlunos;
    }

    public void setMaxAlunos(Integer maxAlunos) {
        this.maxAlunos = maxAlunos;
    }

    public void setHorarioDeAula(String dia, int hora, int minuto) {
        horarioDeAula.put(dia, LocalTime.of(hora, minuto));
    }

    public Map<String, LocalTime> getHorarioDeAula() {
        return horarioDeAula;
    }

    public void setAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public Set<Aluno> getAlunos() {
        return alunos;
    }

    @Override
    public String toString() {
        return getProfessor().getNome() + "," + getSemestre() + "," + getModoDeParticipacao() + "," + getHorarioDeAula()
                + "," + getSala() + "," + getMaxAlunos();
    }
}
