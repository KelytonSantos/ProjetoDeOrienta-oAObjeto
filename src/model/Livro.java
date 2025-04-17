package model;

public class Livro {
    private String title;
    private String author;
    private Integer releaseYear;

    public Livro() {
        this.title = "";
        this.author = "";
        this.releaseYear = 0;
    }

    public Livro(String title, String author, Integer releaseYear) {
        this.title = title;
        this.author = author;
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

}
