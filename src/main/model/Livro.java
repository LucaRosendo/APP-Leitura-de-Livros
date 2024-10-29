package main.model;

import java.util.List;
import java.util.Map;

public class Livro {

    private String nome;
    private List<String> listaGenero;
    private String descricao;
    private Autor autor;
    private final int numeroPaginas;
    private boolean disponibilidade;
    private final Status status;

    public Livro(String nome, List<String> listaGenero, String descricao, Autor autor, int numeroPaginas, boolean disponibilidade, Status status) {
        this.nome = nome;
        this.listaGenero = listaGenero;
        this.descricao = descricao;
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
        this.disponibilidade = disponibilidade;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setListaGenero(List<String> listaGenero) {
        if (this.listaGenero != null) {
            this.listaGenero.addAll(listaGenero);
        } else {
            this.listaGenero = listaGenero;
        }
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public Status getStatus() {
        return status;
    }

    public List<String> getListaGenero() {
        return listaGenero;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public void lerLivro(int tempoLeitura, int paginasLidas) {
        status.registrarTempo(this.nome, tempoLeitura);
        status.registrarPaginasLidas(paginasLidas);
    }

    public boolean disponibilidadeAssinatura() {
        return disponibilidade;
    }

    public Map<String, Object> obterInformacoes() {
        return Map.of(
                "\nnome ", nome,
                "\nlistaGenero ", listaGenero.toString(),
                "\ndescricao ", descricao,
                "\nautor ", autor,
                "\nnumeroPaginas ", String.valueOf(numeroPaginas),
                "\ndisponibilidade ", String.valueOf(disponibilidade),
                "\nstatus ", status.obterEstatisticas()
        );
    }

    public static void main(String[] args) {
        Autor autor = new Autor("J.K. Rowling", List.of("Harry Potter e a Pedra Filosofal", "Harry Potter e a Câmara Secreta"), "Escritora britânica", "5 estrelas");
        Livro livro = new Livro("Harry Potter e a Pedra Filosofal", List.of("Fantasia", "Aventura"), "Harry Potter e a Pedra Filosofal é o primeiro livro da série Harry Potter de J.K. Rowling.", autor, 40, true, new Status());

        livro.lerLivro(60, 10);
        System.out.println(livro.obterInformacoes());
    }
}
