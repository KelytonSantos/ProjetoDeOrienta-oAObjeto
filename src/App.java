import model.Emprestimo;
import model.Livro;
import model.Usuario;

public class App {
    public static void main(String[] args) throws Exception {
        Usuario pessoa1 = new Usuario("Santos", "333.333.333-33", "lucassantos@lucas.com");
        Livro livro = new Livro("1984", "George Orwell", 1949);
        Emprestimo newEmprestimo = new Emprestimo(livro, pessoa1, 3);

        newEmprestimo.showInfo();
    }
}
