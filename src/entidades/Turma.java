package entidades;

import java.time.DayOfWeek;
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
    private Map<DayOfWeek, LocalTime> horarioDeAula;
    private Integer capacidade;
    private Integer sala;
    private Integer maxAlunos;
    private Set<Aluno> alunos = new HashSet<>();// escrever metodos

    public Turma() {
        this.professor = new Professor();
        this.semestre = 0;
        this.metodoDeAvaliacao = MetodoDeAvaliacao.MEDIA_SIMPLES;
        this.modoDeParticipacao = Modalidade.PRESENCIAL;
        this.horarioDeAula = new HashMap<>();
        this.capacidade = 0;
        this.sala = 0;
        this.maxAlunos = 190;
    }

    public Turma(Professor professor, Integer semestre, MetodoDeAvaliacao metodoDeAvaliacao,
            Modalidade modoDeParticipacao, Integer capacidade, Integer maxAlunos) {
        this.professor = professor;
        this.semestre = semestre;
        this.metodoDeAvaliacao = metodoDeAvaliacao;
        this.modoDeParticipacao = modoDeParticipacao;
        this.capacidade = capacidade;
        setSala();
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

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public Integer getSala() {
        return sala;
    }

    public void setSala() {
        if (modoDeParticipacao == Modalidade.valueOf(2))
            this.sala = null;
    }

    public Integer getMaxAlunos() {
        return maxAlunos;
    }

    public void setMaxAlunos(Integer maxAlunos) {
        this.maxAlunos = maxAlunos;
    }

    public void setHorarioDeAula(DayOfWeek dia, int hora, int minuto) {
        horarioDeAula.put(dia, LocalTime.of(hora, minuto));
    }

    public Map<DayOfWeek, LocalTime> getHorarioDeAula() {
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
                + "," + getCapacidade() + "," + getSala() + "," + getMaxAlunos();
    }
}
