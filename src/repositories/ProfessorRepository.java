package repositories;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import entidades.Professor;

public class ProfessorRepository {
    public void save(Professor professor) {

        try {
            FileWriter arquivo = new FileWriter("Alunos.csv", true);

            Professor professorToCompare = getProfessorByMatricula(professor.getMatricula());

            if (professor.getMatricula() == professorToCompare.getMatricula()) {
                System.out.println("Professor ja existe!");

            } else {
                arquivo.write(professor.toString());
                arquivo.write("\n");
                arquivo.close();
            }

        } catch (IOException error) {
            System.out.println("Erro ao tentar salvar" + error.getMessage());
        }

    }

    public Professor getProfessorByMatricula(Integer matricula) {

        try (Scanner leitor = new Scanner(new FileReader("Professor.csv"))) {

            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String[] colunas = linha.split(",");

                if (matricula.equals(Integer.parseInt(colunas[0]))) {
                    String nome = colunas[1];
                    Professor professor = new Professor(nome, matricula); // supondo construtor

                    return professor;
                }
            }

            System.out.println("Matrícula não encontrada");

        } catch (IOException error) {
            System.out.println("Erro ao tentar encontrar professor pela matrícula: " + error.getMessage());
        }

        return null;
    }

}
