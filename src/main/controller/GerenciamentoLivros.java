package main.controller;

import java.util.ArrayList;
import java.util.List;
import main.model.Autor;
import main.model.Livro;
import main.model.Status;

public class GerenciamentoLivros {

    private final ArrayList<Livro> livros = new ArrayList<>();

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
        System.out.println("Livro adicionado: " + livro.getNome());
    }

    public void removerLivro(String nome) {
        livros.removeIf(livro -> livro.getNome().equals(nome));
        System.out.println("Livro removido: " + nome);
    }

    public Livro buscarLivro(String nome) {
        for (Livro livro : livros) {
            if (livro.getNome().equals(nome)) {
                return livro;
            }
        }
        System.out.println("Livro não encontrado: " + nome);
        return null;
    }

    public void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro disponível.");
        } else {
            for (Livro livro : livros) {
                System.out.println(livro.getNome());
            }
        }
    }

    public static void main(String[] args) {
        GerenciamentoLivros gerenciamento = new GerenciamentoLivros();
        Autor autor = new Autor("J.K. Rowling", List.of("Harry Potter e a Pedra Filosofal", "Harry Potter e a Câmara Secreta"), "Escritora britânica", "5 estrelas");
        Livro livro = new Livro("Harry Potter e a Pedra Filosofal", List.of("Fantasia", "Aventura"), "Primeiro livro da série Harry Potter.", autor, 40, true, new Status());

        gerenciamento.adicionarLivro(livro);
        gerenciamento.listarLivros();

        Livro encontrado = gerenciamento.buscarLivro("Harry Potter e a Pedra Filosofal");
        if (encontrado != null) {
            System.out.println("Livro encontrado: " + encontrado.getDescricao());
        }

        gerenciamento.removerLivro("Harry Potter e a Pedra Filosofal");
        gerenciamento.listarLivros();
    }
}
