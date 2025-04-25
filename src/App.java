import java.util.Scanner;

import entidades.Aluno;
import repositories.AlunoRepository;

public class App {

    public static AlunoRepository alunoRepository = new AlunoRepository();

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

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
                        System.out.println("Deseja matrícular aluno ou editar? (1 para matricular, 2 para editar)");
                        escolha = sc.nextInt();
                        if (escolha == 1)
                            // matricularAluno();
                            editarAluno();
                        else if (escolha == 2) {
                            // buscar do banco
                        } else {
                            System.out.println("Numero invalido!");
                        }
                        break;
                    case 2:

                        break;
                    case 3:

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

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite a matrícula do aluno: ");
        Integer matricula = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite o nome do Aluno: ");
        String nome = sc.nextLine();

        System.out.println("Digite o nome do curso: ");
        String curso = sc.nextLine();

        Aluno aluno = new Aluno(nome, matricula, curso, Boolean.valueOf(false));

        alunoRepository.save(aluno);

        sc.close();
    }

    public static void editarAluno() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite a matricula do aluno: ");
        Integer matricula = sc.nextInt();

        if (alunoRepository.getByMatriccula(matricula) != null) {
            System.out.println("");
        }
        sc.close();

    }
}
