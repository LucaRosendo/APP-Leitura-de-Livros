package main.model;

import java.util.ArrayList;
import java.util.List;

public class Autor {
    private String nome;
    private List<String> publicacoes;
    private String descricao;
    private String avaliacaoAutor;

    public Autor(String nome, List<String> publicacoes, String descricao, String avaliacaoAutor) {
        this.nome = nome;
        this.publicacoes = new ArrayList<>(publicacoes != null ? publicacoes : new ArrayList<>());
        this.descricao = descricao;
        this.avaliacaoAutor = avaliacaoAutor; 
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do autor não pode ser nulo ou vazio.");
        }
        this.nome = nome;
    }

    public void setPublicacoes(List<String> publicacoes) {
        if (publicacoes == null) {
            throw new IllegalArgumentException("A lista de publicações não pode ser nula.");
        }
        this.publicacoes = new ArrayList<>(publicacoes);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("A descrição não pode ser nula ou vazia.");
        }
        this.descricao = descricao;
    }

    public String getAvaliacaoAutor() {
        return avaliacaoAutor;
    }

    public void setAvaliacaoAutor(String avaliacaoAutor) {
        if (avaliacaoAutor == null || avaliacaoAutor.trim().isEmpty()) {
            throw new IllegalArgumentException("A avaliação do autor não pode ser nula ou vazia.");
        }
        this.avaliacaoAutor = avaliacaoAutor;
    }

    public void adicionarPublicacao(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("Título da publicação não pode ser nulo ou vazio.");
        }
        if (!publicacoes.contains(titulo)) {
            publicacoes.add(titulo);
        }
    }

    public List<String> getPublicacoes() {
        return new ArrayList<>(publicacoes); 
    }
}
