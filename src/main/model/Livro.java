package main.model;

import java.util.List;
import java.util.Map;

public class Livro {

    private String nome;
    private List<String> listaGenero;
    private String descricao;
    private String autor;
    private boolean disponibilidade;

    public Livro(String nome, List<String> listaGenero, String descricao, String autor, boolean disponibilidade) {
        this.nome = nome;
        this.listaGenero = listaGenero;
        this.descricao = descricao;
        this.autor = autor;
        this.disponibilidade = disponibilidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<String> getListaGenero() {
        return listaGenero;
    }

    public void setListaGenero(List<String> listaGenero) {
        this.listaGenero = listaGenero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public void lerLivro() {
        // Implementação do método para ler o livro
    }

    public boolean disponibilidadeAssinatura() {
        // Implementação do método para verificar a disponibilidade da assinatura
        return disponibilidade;
    }

    public Map<String, String> obterInformacoes() {
        return Map.of(
                "\nnome", nome,
                "\nlistaGenero", listaGenero.toString(),
                "\ndescricao", descricao,
                "\nautor", autor,
                "\ndisponibilidade", String.valueOf(disponibilidade)
        );
    }

    public static void main(String[] args) {
        Livro livro = new Livro("Livro 1",
                List.of("Ficção Científica", "Aventura"),
                "Descrição do livro",
                "J.K. Rowling",
                true);

        System.out.println(livro.obterInformacoes());
    }
}
