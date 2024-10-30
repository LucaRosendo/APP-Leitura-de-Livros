package main.model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String nome;
    private String cpf;
    private List<String> generos;
    private List<Livro> biblioteca;
    private int limiteAcesso;
    private String tipoAssinatura;

    public Usuario(String nome, String cpf, String tipoAssinatura) {
        this.nome = nome;
        this.cpf = cpf;
        this.tipoAssinatura = tipoAssinatura;
        if (tipoAssinatura.equals("VIP") || tipoAssinatura.equals("COLABORADOR")) {
            this.limiteAcesso = Assinatura.getMaxAcessoConta();
        } else if (tipoAssinatura.equals("FREE")) {
            this.limiteAcesso = Assinatura.getMaxAcessoGratis();
        } else {
            this.limiteAcesso = 0; 
        }
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

    public List<String> getGeneros() {
        return generos;
    }

    public void setGeneros(List<String> generos) {
        this.generos = generos;
    }

    public List<Livro> getBiblioteca() {
        return biblioteca;
    }

    public String getTipoAssinatura() {
        return tipoAssinatura;
    }

    public void setTipoAssinatura(String tipoAssinatura) {
        this.tipoAssinatura = tipoAssinatura;
    }

    public int getLimiteAcesso() {
        return limiteAcesso;
    }

    public void setLimiteAcesso(int limiteAcesso) {
        this.limiteAcesso = limiteAcesso;
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