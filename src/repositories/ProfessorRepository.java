package repositories;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entidades.Professor;

public class ProfessorRepository {
    public void save(Professor professor) {

        try {
            FileWriter arquivo = new FileWriter("Professor.csv", true);

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

    public List<Professor> getProfessores() {
        List<Professor> professores = new ArrayList<>();

        try (Scanner leitor = new Scanner(new FileReader("Professor.csv"))) {

            while (leitor.hasNextLine()) {

                String linha = leitor.nextLine();

                String[] colunas = linha.split(",");
                Integer matricula = Integer.parseInt(colunas[0]);
                String nome = colunas[1];

                Professor novoProfessor = new Professor(nome, matricula);
                professores.add(novoProfessor);
            }

        } catch (IOException error) {
            System.out.println("Erro ao tentar buscar professores" + error.getMessage());
        }

        return professores;
    }

    public Professor getProfessorByMatricula(Integer matricula) {

        try (Scanner leitor = new Scanner(new FileReader("Professor.csv"))) {

            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String[] colunas = linha.split(",");

                if (matricula.equals(Integer.parseInt(colunas[0]))) {
                    String nome = colunas[1];
                    Professor professor = new Professor(nome, matricula);

                    return professor;
                }
            }

        } catch (IOException error) {
            System.out.println("Erro ao tentar encontrar professor pela matrícula: " + error.getMessage());
        }

        return null;
    }

}
