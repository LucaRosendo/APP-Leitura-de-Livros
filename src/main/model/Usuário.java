package main.model;

import java.util.ArrayList;
import java.util.List;

public class Usuário {

    private String nome;
    private String senha;
    private List<String> generos;
    private List<String> biblioteca;

    public Usuário(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
        this.generos = new ArrayList<>();
        this.biblioteca = new ArrayList<>();
    }

    public boolean fazerLogin(String nome, String senha) {
        return this.nome.equals(nome) && this.senha.equals(senha);
    }

    public void adicionarLivro(String livro) {
        biblioteca.add(livro);
    }

    public void removerLivro(String livro) {
        biblioteca.remove(livro);
    }

    public void adicionarGenero(String genero) {
        generos.add(genero);
    }

    public void removerGenero(String genero) {
        generos.remove(genero);
    }

    public List<String> listarGeneros() {
        return new ArrayList<>(generos);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }
}
