package main.model;

import java.util.List;

public class Autor {

    private String nome;
    private final List<String> publicacoes;
    private final String descricao;
    private String avaliacaoAutor;

    public Autor(String nome, List<String> publicacoes, String descricao, String avaliacaoAutor) {
        this.nome = nome;
        this.publicacoes = publicacoes;
        this.descricao = descricao;
        this.avaliacaoAutor = avaliacaoAutor;
    }

    public void adicionarLivro(String livro) {
        this.publicacoes.add(livro);
    }

    public void definirAvaliacao(String avaliacao) {
        this.avaliacaoAutor = avaliacao;
    }

    public List<String> listarPublicacoes() {
        return this.publicacoes;
    }

    public String obterAvaliacao() {
        return this.avaliacaoAutor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static void main(String[] args) {
        Autor autor = new Autor("J.K. Rowling",
                List.of("Harry Potter e a Pedra Filosofal",
                        "Harry Potter e a Câmara Secreta"),
                "Escritora britânica", "5 estrelas");

        System.out.println(autor.getNome());
        System.out.println(autor.listarPublicacoes());
        System.out.println(autor.obterAvaliacao());
    }
}
