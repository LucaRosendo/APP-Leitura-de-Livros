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

    public String getGenero() {
        return String.join(", ", listaGenero);
    }

    public void setGenero(List<String> listaGenero) {
        this.listaGenero = listaGenero;
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
}
