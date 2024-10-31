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

        this.biblioteca = new ArrayList<>();
        this.limiteAcesso = definirLimiteAcesso(tipoAssinatura);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser nulo ou vazio.");
        }
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public boolean validacaoCPF(String cpf) {
        return cpf != null && cpf.length() == 11; 
    }

    public void setCpf(String cpf) {
        if (validacaoCPF(cpf)) {
            this.cpf = cpf;
        } else {
            throw new IllegalArgumentException("CPF inválido");
        }
    }

    public List<String> getGeneros() {
        return generos != null ? new ArrayList<>(generos) : new ArrayList<>();
    }

    public void setGeneros(List<String> generos) {
        if (generos == null) {
            throw new IllegalArgumentException("A lista de gêneros não pode ser nula.");
        }
        this.generos = new ArrayList<>(generos); 
    }

    public List<Livro> getBiblioteca() {
        return new ArrayList<>(biblioteca); 
    }

    public String getTipoAssinatura() {
        return tipoAssinatura;
    }

    public void setTipoAssinatura(String tipoAssinatura) {
        if (tipoAssinatura == null || tipoAssinatura.trim().isEmpty()) {
            throw new IllegalArgumentException("O tipo de assinatura não pode ser nulo ou vazio.");
        }
        this.tipoAssinatura = tipoAssinatura;
        this.limiteAcesso = definirLimiteAcesso(tipoAssinatura);
    }

    public int getLimiteAcesso() {
        return limiteAcesso;
    }

    public void setLimiteAcesso(int limiteAcesso) {
        if (limiteAcesso < 0) {
            throw new IllegalArgumentException("O limite de acesso não pode ser negativo.");
        }
        this.limiteAcesso = limiteAcesso;
    }

    public void addLivro(Livro livro) {
        if (livro == null) {
            throw new IllegalArgumentException("O livro não pode ser nulo.");
        }
        this.biblioteca.add(livro);
    }

    private int definirLimiteAcesso(String tipoAssinatura) {
        if ("VIP".equals(tipoAssinatura) || "COLABORADOR".equals(tipoAssinatura)) {
            return Assinatura.getMaxAcessoConta();
        } else if ("FREE".equals(tipoAssinatura)) {
            return Assinatura.getMaxAcessoGratis();
        } else {
            return 0; 
        }
    }
}
