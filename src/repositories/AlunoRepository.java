package repositories;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entidades.Aluno;

public class AlunoRepository {

    public void save(Aluno aluno) {
        try {
            FileWriter arquivo = new FileWriter("Alunos.csv", true);

            arquivo.write(aluno.toString());
            arquivo.write("\n");
            arquivo.close();

        } catch (IOException error) {
            System.out.println("Erro " + error.getMessage());

        }
    }

    public List<Aluno> getAlunos() {
        List<Aluno> alunos = new ArrayList<>();

        try {
            FileReader arquivo = new FileReader("Alunos.csv");
            Scanner leitor = new Scanner(arquivo);

            while (leitor.hasNextLine()) {

                String linha = leitor.nextLine();

                String[] colunas = linha.split(",");
                Integer matricula = Integer.parseInt(colunas[0]);
                String nome = colunas[1];
                String curso = colunas[2];
                Boolean trancamento = Boolean.parseBoolean(colunas[3]);

                Aluno novoAluno = new Aluno(nome, matricula, curso, trancamento);
                alunos.add(novoAluno);
            }

            arquivo.close();
            leitor.close();
        } catch (IOException error) {
            System.out.println("Erro " + error.getMessage());
        }

        return alunos;

    }

    public Aluno getByMatriccula(Integer matricula) {
        Aluno aluno = new Aluno();
        try {
            FileReader arquivo = new FileReader("Alunos.csv");
            Scanner leitor = new Scanner(arquivo);

            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();

                String[] colunas = linha.split(",");

                if (matricula == Integer.parseInt(colunas[0])) {
                    String nome = colunas[1];
                    String curso = colunas[2];
                    Boolean trancamentp = Boolean.parseBoolean(colunas[3]);

                    aluno.setNome(nome);
                    aluno.setCurso(curso);
                    aluno.setTrancamentoDeCurso(trancamentp);
                }
            }

            arquivo.close();
            leitor.close();

            if (aluno.getMatricula() == null) {
                System.out.println("Matricula não encontrada");
                return null;
            } else {
                return aluno;
            }
        } catch (IOException error) {
            System.out.println("Erro " + error.getMessage());
        }

        return aluno;
    }
}
