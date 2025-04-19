package model;

public class Emprestimo {
    private Livro livro;
    private Usuario user;
    private Integer borrowDays;

    public Emprestimo() {
    }

    public Emprestimo(Livro livro, Usuario user) {
        this.livro = livro;
        this.user = user;
        this.borrowDays = 0;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Integer getBorrowDays() {
        return borrowDays;
    }

    public String emprestimo(Integer days) {
        this.borrowDays = days;
        return "livro emprestado";
    }

    public String devolver() {
        this.borrowDays = 0;
        return "Livro devolvido";
    }

    public Usuario getUsuario() {
        return user;
    }

    public void setUsuario(Usuario user) {
        this.user = user;
    }

    @Override
    public String toString() {

        if (getBorrowDays() > 0) {
            return "O usuario: " + user.getName() + " com o email: " + user.getEmail() + " pegou o livro "
                    + getLivro().getTitle()
                    + " emprestado por " + getBorrowDays() + " dias";
        } else {
            return "O usuario: " + user.getName() + " com o email: " + user.getEmail()
                    + " ainda não pegou nenhum livro emprestado";
        }
    }

}
