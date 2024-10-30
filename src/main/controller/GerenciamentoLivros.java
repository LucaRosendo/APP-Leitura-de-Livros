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
}
