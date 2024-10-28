package main.model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String nome;
    private String cpf;
    private int limiteAcesso;
    private List<String> generos;
    private List<Livro> biblioteca;

    public Usuario(String nome, String cpf, int limiteAcesso) {
        this.nome = nome;
        this.cpf = cpf;
        this.limiteAcesso = limiteAcesso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public boolean validacaoCPF(String cpf) {
        if (cpf == null) {
            return false;
        }
        return cpf.length() == 11;
    }

    public void setCpf(String cpf) {
        if (validacaoCPF(cpf)) {
            this.cpf = cpf;
        } else {
            throw new IllegalArgumentException("CPF inválido");
        }
    }

    public int getLimiteAcesso() {
        return limiteAcesso;
    }

    public void setLimiteAcesso(int limiteAcesso) {
        this.limiteAcesso = limiteAcesso;
    }

    public List<String> getGeneros() {
        return generos;
    }

    public void setGeneros(List<String> generos) {
        this.generos = generos;
    }

    public List<Livro> getBiblioteca() {
        return biblioteca;
    }

    public void addLivro(Livro livro) {
        if (this.biblioteca == null) {
            this.biblioteca = new ArrayList<>();
        }
        if (livro != null) {
            this.biblioteca.add(livro);
        }
    }
}
