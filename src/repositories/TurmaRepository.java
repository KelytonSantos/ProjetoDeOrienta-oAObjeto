package repositories;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entidades.Aluno;
import entidades.Turma;

public class TurmaRepository {

    public void save() {
        try {
            FileWriter arquivo = new FileWriter("Turma.csv", true);

            Turma novTurma = new Turma();

            arquivo.write(novTurma.toString());
            arquivo.write("\n");
            arquivo.close();

        } catch (IOException error) {
            System.out.println("Erro ao tentar salvar " + error.getMessage());
        }
    }

    public List<Turma> getTurmas() {
        List<Turma> turmas = new ArrayList<>();
        
        Turma turma = 
        
        return
    }

}
