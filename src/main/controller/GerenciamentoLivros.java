package main.controller;

import java.util.ArrayList;
import java.util.Optional;
import main.model.Autor;
import main.model.Livro;

public class GerenciamentoLivros {

    private final ArrayList<Livro> livros = new ArrayList<>();
    private final GerenciamentoAutores gerenciamentoAutores;

    public GerenciamentoLivros(GerenciamentoAutores gerenciamentoAutores) {
        this.gerenciamentoAutores = gerenciamentoAutores; 
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
        System.out.println("Livro adicionado: " + livro.getNome());
    }

    public void removerLivro(String nome) {
        livros.removeIf(livro -> livro.getNome().equals(nome));
        System.out.println("Livro removido: " + nome);
    }

    public Optional<Livro> buscarLivro(String nome) {
        String nomeNormalizado = nome.trim().toLowerCase();
        
        for (Autor autor : gerenciamentoAutores.getAutores()) { 
            for (String publicacao : autor.getPublicacoes()) { 
                if (publicacao.toLowerCase().equals(nomeNormalizado)) {
                    return livros.stream()
                                 .filter(livro -> livro.getNome().equalsIgnoreCase(nome))
                                 .findFirst();
                }
            }
        }
        
        System.out.println("Livro não encontrado: " + nome);
        return Optional.empty(); 
    }
    public void listarLivros() {
        Optional.of(livros)
            .filter(lista -> !lista.isEmpty())
            .ifPresentOrElse(
                lista -> {
                    System.out.println("Lista de Livros:");
                    lista.forEach(livro -> System.out.println(livro.getNome()));
                },
                () -> System.out.println("Nenhum livro disponível.")
            );
    }
}
