package main.model;

import java.util.ArrayList;
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
    private String conteudo;

    public Livro(String nome, String generolivro, String descricao, Autor autor, int numeroPaginas, boolean disponibilidade, Status status, String conteudo) {
        this.nome = nome; 
        this.listaGenero = (List.of(generolivro)); 
        this.descricao = descricao; 
        this.autor = autor; 
        if (numeroPaginas <= 0) {
            throw new IllegalArgumentException("O número de páginas deve ser maior que zero.");
        }
        this.numeroPaginas = numeroPaginas;
        this.disponibilidade = disponibilidade;
        this.status = status;  
        this.conteudo = conteudo;
    }

    public String getNome() {
        return nome;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do livro não pode ser nulo ou vazio.");
        }
        this.nome = nome;
    }

    public void setConteudo(String conteudo) {
        if (conteudo == null) {
            throw new IllegalArgumentException("O conteúdo do livro não pode ser nulo.");
        }
        this.conteudo = conteudo;
    }

    public void setListaGenero(List<String> listaGenero) {
        if (listaGenero == null || listaGenero.isEmpty()) {
            throw new IllegalArgumentException("A lista de gêneros não pode ser nula ou vazia.");
        }
        this.listaGenero = new ArrayList<>(listaGenero); 
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

    public String getGenero() {
        return String.join(", ", listaGenero);
    }

    public void setGenero(List<String> listaGenero) {
        if (listaGenero == null || listaGenero.isEmpty()) {
            throw new IllegalArgumentException("A lista de gêneros não pode ser nula ou vazia.");
        }
        this.listaGenero = new ArrayList<>(listaGenero);
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        if (autor == null) {
            throw new IllegalArgumentException("O autor não pode ser nulo.");
        }
        this.autor = autor;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public Status getStatus() {
        return status;
    }

    public List<String> getListaGenero() {
        return new ArrayList<>(listaGenero);
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public void lerLivro(int tempoLeitura, int paginasLidas) {
        if (tempoLeitura < 0) {
            throw new IllegalArgumentException("O tempo de leitura não pode ser negativo.");
        }
        if (paginasLidas < 0 || paginasLidas > numeroPaginas) {
            throw new IllegalArgumentException("O número de páginas lidas deve ser maior ou igual a zero e menor ou igual ao número total de páginas.");
        }
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
