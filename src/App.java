import java.util.Scanner;

import entidades.Aluno;
import entidades.Professor;
import entidades.Turma;
import entidades.ENUM.MetodoDeAvaliacao;
import entidades.ENUM.Modalidade;
import repositories.AlunoRepository;
import repositories.ProfessorRepository;

public class App {
    public static Scanner sc = new Scanner(System.in);
    public static AlunoRepository alunoRepository = new AlunoRepository();
    public static ProfessorRepository professorRepository = new ProfessorRepository();

    public static void main(String[] args) throws Exception {

        System.out.println("Escolha um modo: ");
        System.out.println("1 - Modo Aluno (Normal e Especial)");
        System.out.println("2 - Modo Disciplina/Turma");
        System.out.println("3 - Modo Avaliação/Frequencia");

        int escolha = sc.nextInt();

        switch (escolha) {
            case 1:
                System.out.println("O que deseja fazer?");
                System.out.println("1 - Cadastrar Aluno ou editar aluno");
                System.out.println("2 - Matricular Alunos em disciplinas");
                System.out.println("3 - Ver alunos cadastrados");

                escolha = sc.nextInt();

                switch (escolha) {
                    case 1:
                        System.out.println(
                                "Deseja matrícular aluno/aluno especial ou editar? (1 para matricular, 2 para editar)");
                        escolha = sc.nextInt();
                        if (escolha == 1)
                            matricularAluno();

                        else if (escolha == 2) {
                            editarAluno();
                        } else {
                            System.out.println("Numero invalido!");
                        }
                        break;
                    case 2: // fazer depois de criar func de matricular turma

                        break;
                    case 3:
                        for (Aluno aluno : alunoRepository.getAlunos()) {
                            System.out.println("Matricula: " + aluno.getMatricula() + " Nome: " + aluno.getNome()
                                    + " Curso: " + aluno.getCurso());
                        }
                        break;
                    default:
                        break;
                }
                break;

            case 2:
                System.out.println("O que deseja fazer?");
                System.out.println("1 - Cadastrar Disciplina");
                System.out.println("2 - Criar turmas");
                System.out.println("3 - Ver Turmas disponíveis");
                switch (escolha) {
                    case 1:

                        break;
                    case 2:
                        criarTurma();
                        break;
                    case 3:

                        break;
                    default:
                        break;
                }
                break;

            case 3:
                System.out.println("O que deseja fazer?");
                System.out.println("1 - Lançar Notas ou lançar presença");
                System.out.println("2 - Ver boletim individual");
                System.out.println("3 - Ver boletim com dados da turma");
                switch (escolha) {
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    default:
                        break;
                }
                break;

            default:
                break;
        }

        sc.close();

    }

    public static void matricularAluno() {
        System.out.println("O aluno que deseja matricular é especial (s ou n)?");
        char escolha = sc.next().charAt(0);

        if (escolha == 's' || escolha == 'S') {
            System.out.println("Digite a matrícula do novo aluno especial: ");
            int matricula = sc.nextInt();

        } else {

            System.out.println("Digite a matrícula do aluno: ");
            Integer matricula = sc.nextInt();
            sc.nextLine();
            System.out.println("Digite o nome do Aluno: ");
            String nome = sc.nextLine();

            System.out.println("Digite o nome do curso: ");
            String curso = sc.nextLine();

            Aluno aluno = new Aluno(nome, matricula, curso, Boolean.valueOf(false));

            alunoRepository.save(aluno);
        }
    }

    public static void editarAluno() {

        Aluno alunoParaEditar = new Aluno();
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite a matricula do aluno: ");
        Integer matricula = sc.nextInt();

        sc.nextLine();

        if ((alunoParaEditar = alunoRepository.getAlunoByMatricula(matricula)) != null) {
            System.out.println("Deseja trocar de curso ou trancar (digite 1 para trocar ou 2 para trancar): ");
            int escolha = sc.nextInt();

            sc.nextLine();

            if (escolha == 1) {
                System.out.println("Digite o novo curso: ");
                String curso = sc.nextLine();
                alunoParaEditar.setCurso(curso);
            } else if (escolha == 2) {

                System.out.println("Voce quer trancar o curso? (s ou qualquer tecla para n)");
                char c = sc.next().charAt(0);

                if (c == 's' || c == 'S') {
                    alunoParaEditar.setTrancamentoDeCurso(Boolean.valueOf(true));
                    System.out.println("Voce trancou o curso!");
                }
            }
        }
        sc.close();

    }

    public static void criarTurma() {

        Professor novoProfessor = new Professor();

        System.out.println("Digite a matricula do professor que dara esta materia: ");
        Integer matriculaProfessor = sc.nextInt();

        novoProfessor = professorRepository.getProfessorByMatricula(matriculaProfessor);

        if (novoProfessor.getMatricula() != null) {
            System.out.println("Professor não existente, cadastre primeiro um professor!");
        } else {

            System.out.println("Digite o semestre em que a matéria esta dísponivel: ");
            Integer semestre = sc.nextInt();

            sc.nextLine();

            System.out.println("Digite o metodo de avaliação do professor: ");
            String metodoDeAval = sc.nextLine();

            System.out.println("Digite o modo de participação na materia (online ou presencial): ");
            String modoDePartici = sc.nextLine();

            System.out.println(
                    "Defina o dia da semana, o horario e os minutos em que serão ministradas as aulas (ex: QUINTA, 14, 00)");
            String diaDaSemana = sc.next();
            Integer hora = sc.nextInt();
            sc.nextLine();
            Integer minutos = sc.nextInt();

            System.out.println("Defina a capacidade maxima de alunos: ");
            Integer capacidadeMax = sc.nextInt();

            Turma novaTurma = new Turma(novoProfessor, semestre, MetodoDeAvaliacao.valueOf(metodoDeAval),
                    Modalidade.valueOf(modoDePartici), capacidadeMax);

            novaTurma.setHorarioDeAula(diaDaSemana, hora, minutos);
        }
    }
}
