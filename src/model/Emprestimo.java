package model;

public class Emprestimo {
    private Livro livro;
    private Usuario usuario;
    private Integer borrowDays;

    public Emprestimo() {
    }

    public Emprestimo(Livro livro, Usuario usuario, Integer borrowDays) {
        this.livro = livro;
        this.usuario = usuario;
        this.borrowDays = borrowDays;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getDays() {
        return borrowDays;
    }

    public void setDays(Integer days) {
        this.borrowDays = days;
    }

    public void showInfo() {
        System.out
                .println("The user is: " + getUsuario().getName() + " with associated email: " + getUsuario().getEmail()
                        + " subscribed with the CPF: " + getUsuario().getCpf() + " has borrowed the book : "
                        + getLivro().getTitle() +
                        " released in: " + getLivro().getReleaseYear() + " by the author: " + getLivro().getAuthor()
                        + " for: " + getDays() + " days");
    }

}
