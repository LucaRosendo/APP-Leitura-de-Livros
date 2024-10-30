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

    public void adicionarPublicacao(String titulo) {
        if (titulo != null && !titulo.isEmpty()) {
            if (publicacoes.indexOf(titulo)==-1){
               publicacoes.add(titulo);  
            } 
           
        } else {
            throw new IllegalArgumentException("Título da publicação não pode ser nulo ou vazio.");
        }
    }

    public List<String> getPublicacoes() {
        return publicacoes;
    }
}
