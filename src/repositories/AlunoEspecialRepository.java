package repositories;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entidades.AlunoEspecial;

public class AlunoEspecialRepository {

    public void save(AlunoEspecial alunoEspecial) {
        try {
            FileWriter arquivo = new FileWriter("AlunoEspecial.csv", true);

            AlunoEspecial alunoEspecialToCompare = getAlunoByMatricula(alunoEspecial.getMatricula());

            if (alunoEspecial.getMatricula() == alunoEspecialToCompare.getMatricula()) {
                System.out.println("Aluno ja existe!");

            } else {
                arquivo.write(alunoEspecial.toString());
                arquivo.write("\n");
                arquivo.close();
            }

        } catch (IOException error) {
            System.out.println("Erro ao tentar salvar" + error.getMessage());

        }
    }

    public List<AlunoEspecial> getAlunos() {
        List<AlunoEspecial> alunos = new ArrayList<>();

        try (Scanner leitor = new Scanner(new FileReader("AlunoEspecial.csv"))) {

            while (leitor.hasNextLine()) {

                String linha = leitor.nextLine();

                String[] colunas = linha.split(",");
                Integer matricula = Integer.parseInt(colunas[0]);
                String nome = colunas[1];
                String curso = colunas[2];
                Boolean trancamento = Boolean.parseBoolean(colunas[3]);

                AlunoEspecial novoAluno = new AlunoEspecial(nome, matricula, curso, trancamento);
                alunos.add(novoAluno);
            }

        } catch (IOException error) {
            System.out.println("Erro ao tentar buscar alunos" + error.getMessage());
        }

        return alunos;

    }

    public AlunoEspecial getAlunoByMatricula(Integer matricula) {

        try (Scanner leitor = new Scanner(new FileReader("AlunoESpecial.csv"))) {

            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();

                String[] colunas = linha.split(",");

                if (matricula.equals(Integer.parseInt(colunas[0]))) {
                    String nome = colunas[1];
                    String curso = colunas[2];
                    Boolean trancamento = Boolean.parseBoolean(colunas[3]);

                    AlunoEspecial aluno = new AlunoEspecial(nome, matricula, curso, trancamento);

                    return aluno;
                }

                System.out.println("Matricula não encontrada");
            }
        } catch (IOException error) {
            System.out.println("Erro ao tentar encontrar aluno pela matrícula:" + error.getMessage());
        }

        return null;
    }
}
