package main.model;

import java.util.ArrayList;
import java.util.List;

public class Autor{
    private String nome;
    private List<String> publicacoes;
    private String descricao;
    private String avaliacaoAutor;

    public Autor(String nome, List<String> publicacoes, String descricao, String avaliacaoAutor) {
        this.nome = nome;
        this.publicacoes = new ArrayList<>(publicacoes);
        this.descricao = descricao;
        this.avaliacaoAutor = avaliacaoAutor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPublicacoes(List<String> publicacoes) {
        this.publicacoes = publicacoes;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAvaliacaoAutor() {
        return avaliacaoAutor;
    }

    public void setAvaliacaoAutor(String avaliacaoAutor) {
        this.avaliacaoAutor = avaliacaoAutor;
    }

    public void adicionarPublicacao(String livro) {
        if (publicacoes.contains(livro)) {
            throw new IllegalArgumentException("\nLivro já existente: " + livro);
        }else{
            System.out.println("\nLivro adicionado: " + livro);
            publicacoes.add(livro);
        }
    }

    public List<String> getPublicacoes() {
        return publicacoes;
    }
}
