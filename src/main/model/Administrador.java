package main.model;

import java.util.ArrayList;
import java.util.List;

public class Administrador {

    private String nome;
    private String senhaAcesso;
    private List<Autor> autores;
    private List<Livro> livros;

    public Administrador(String nome, String senhaAcesso) {
        this.nome = nome;
        this.senhaAcesso = senhaAcesso;
        this.autores = new ArrayList<>();
        this.livros = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenhaAcesso() {
        return senhaAcesso;
    }

    public void setSenhaAcesso(String senhaAcesso) {
        this.senhaAcesso = senhaAcesso;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public void adicionarAutor(String autorNome) {
        Autor autor = new Autor(autorNome, new ArrayList<>(), "", "");
        this.autores.add(autor);
    }

    public void removerAutor(String autorNome) {

    }

    public void adicionarLivro(String livroNome, boolean disponibilidade) {
        Livro livro = new Livro(livroNome, new ArrayList<>(), "", "", disponibilidade);
        this.livros.add(livro);
    }

    public void removerLivro(String livroNome) {

    }

    public static void main(String[] args) {
        Administrador admin = new Administrador("Admin", "senha123");

        Autor autores = new Autor("Monteiro Lobato", new ArrayList<>(), "Primeio autor", "5");
        Livro livros = new Livro("Sítio do picapau amarelo", List.of("Ficção Científica", "Aventura"), "Primeiro Livro", "Monteiro LObato", true);

        System.out.println(admin.getNome());
        System.out.println(autores.getNome());
        System.out.println(livros.getNome());
    }
}
