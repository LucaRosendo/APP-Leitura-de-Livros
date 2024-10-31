package main.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Administrador extends Usuario {

    private String senhaAcesso;
    private final List<Autor> autores;
    private final List<Livro> livros;

    public Administrador(String nome, String senhaAcesso) {
        super(nome, senhaAcesso, "VIP");
        this.senhaAcesso = senhaAcesso;
        this.autores = new ArrayList<>();
        this.livros = new ArrayList<>();
    }

    public String getSenhaAcesso() {
        return senhaAcesso;
    }

    public void setSenhaAcesso(String senhaAcesso) {
        if (senhaAcesso == null || senhaAcesso.isEmpty()) {
            throw new IllegalArgumentException("A senha de acesso não pode ser nula ou vazia.");
        }
        this.senhaAcesso = senhaAcesso;
    }

    public List<Autor> getAutores() {
        return Collections.unmodifiableList(autores);
    }

    public void adicionarAutor(String autorNome) {
        if (autorNome == null || autorNome.isEmpty()) {
            throw new IllegalArgumentException("Nome do autor não pode ser nulo ou vazio.");
        }
        Autor autor = new Autor(autorNome, new ArrayList<>(), "", "");
        this.autores.add(autor);
    }

    public void removerAutor(String autorNome) {
        if (autorNome == null || autorNome.isEmpty()) {
            throw new IllegalArgumentException("Nome do autor não pode ser nulo ou vazio.");
        }
        this.autores.removeIf(autor -> autor.getNome().equals(autorNome));
    }

    public List<Livro> getLivros() {
        return Collections.unmodifiableList(livros);
    }

    public void adicionarLivro(String livroNome, boolean disponibilidade) {
        if (livroNome == null || livroNome.isEmpty()) {
            throw new IllegalArgumentException("Nome do livro não pode ser nulo ou vazio.");
        }
        Livro livro = new Livro(livroNome, "", "", null, 0, disponibilidade, new Status(), "");
        this.livros.add(livro);
    }

    public void removerLivro(String livroNome) {
        if (livroNome == null || livroNome.isEmpty()) {
            throw new IllegalArgumentException("Nome do livro não pode ser nulo ou vazio.");
        }
        this.livros.removeIf(livro -> livro.getNome().equals(livroNome));
    }
}
