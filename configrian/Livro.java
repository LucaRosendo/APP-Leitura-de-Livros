import java.util.List;

public class Livro {

    private String id;
    private List<String> listaGenero;
    private String descricao;
    private String autor;
    private boolean disponibilidade;

    public Livro(String id, List<String> listaGenero, String descricao, String autor, boolean disponibilidade) {
        this.id = id;
        this.listaGenero = listaGenero;
        this.descricao = descricao;
        this.autor = autor;
        this.disponibilidade = disponibilidade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    // Retorno de informações em formato de string
    public String obterInformacoes() {
        return "ID: " + id +
                "\nGêneros: " + listaGenero +
                "\nDescrição: " + descricao +
                "\nAutor: " + autor +
                "\nDisponibilidade: " + (disponibilidade ? "Disponível" : "Indisponível");
    }

    // Adicionado: Método toString()
    @Override
    public String toString() {
        return "Livro: " + id + 
               ", Autor: " + autor + 
               ", Disponibilidade: " + (disponibilidade ? "Disponível" : "Indisponível");
    }

    public static void main(String[] args) {
        Livro livro = new Livro("Livro 1",
                List.of("Ficção Científica", "Aventura"),
                "Descrição do livro",
                "J.K. Rowling",
                true);

        System.out.println(livro.obterInformacoes());
        System.out.println(livro);  // Exibe o toString()
    }
}
