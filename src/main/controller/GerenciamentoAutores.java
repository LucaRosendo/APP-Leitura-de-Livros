package main.controller;

import java.util.ArrayList;
import java.util.Optional;
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
        autores.removeIf(a -> a.getNome().equals(nome));
        System.out.println("Autor removido: " + nome);
    }

    public Optional<Autor> buscarAutor(String nome) {
        Optional<Autor> autorEncontrado = autores.stream()
                .filter(autor -> autor.getNome().equals(nome))
                .findFirst();
    
        if (autorEncontrado.isPresent()) {
            return autorEncontrado;
        } else {
            System.out.println("Autor não encontrado: " + nome);
            return Optional.empty();
        }
    }
    

    public void listarAutores() {
        if (autores.isEmpty()) {
            System.out.println("Nenhum autor disponível.");
        } else {
            for (Autor autor : autores) {
                System.out.println("Autor encontrado: " + autor.getNome());
            }
        }
    }

    public ArrayList<Autor> getAutores() {
        return autores;
    }
}
