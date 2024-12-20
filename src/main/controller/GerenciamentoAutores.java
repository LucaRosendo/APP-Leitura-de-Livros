package main.controller;

import java.util.ArrayList;
import main.model.Autor;

public class GerenciamentoAutores {
    private final ArrayList<Autor> autores = new ArrayList<>();

    public void adicionarAutor(Autor autor) {
        if (autores.stream().anyMatch(a -> a.getNome().equals(autor.getNome()))) {
            throw new IllegalArgumentException("Autor já existente: " + autor.getNome());
        }
        autores.add(autor);
        System.out.println("Autor adicionado: " + autor.getNome());
        }

    public void removerAutor(String nome) {
        if (autores.removeIf(a -> a.getNome().equals(nome))) {
            System.out.println("Autor removido: " + nome);
        } else {
            System.out.println("Autor não encontrado: " + nome);
        }
    }

    public Autor buscarAutor(String nome) {
        for (Autor autor : autores) {
            if (autor.getNome().equals(nome)) {
                return autor;
            }
        }
        System.out.println("Autor não encontrado: " + nome);
        return null;
    }

    public void listarAutores() {
        if (autores.isEmpty()) {
            System.out.println("Nenhum autor disponível.");
        } else {
            for (Autor autor : autores) {
                System.out.println(autor.getNome());
            }
        }
    }

    public ArrayList<Autor> getAutores() {
        return autores;
    }
}
