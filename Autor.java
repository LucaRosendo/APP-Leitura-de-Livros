import java.util.ArrayList;
import java.util.List;

public class Autor {

    private String nome;
    private List<String> publicacoes;
    private String descricao;
    private String avaliacaoAutor;

    public Autor(String nome, List<String> publicacoes, String descricao, String avaliacaoAutor) {
        this.nome = nome;
        // Tornando a lista mutável
        this.publicacoes = new ArrayList<>(publicacoes);
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

    @Override
    public String toString() {
        return "Autor: " + nome + ", Avaliação: " + avaliacaoAutor;
    }

    public static void main(String[] args) {
        Autor autor = new Autor("J.K. Rowling",
                List.of("Harry Potter e a Pedra Filosofal",
                        "Harry Potter e a Câmara Secreta"),
                "Escritora britânica", "5 estrelas");

        // Testando adicionar um livro
        autor.adicionarLivro("Harry Potter e o Prisioneiro de Azkaban");

        System.out.println(autor.getNome());
        System.out.println(autor.listarPublicacoes());
        System.out.println(autor.obterAvaliacao());
        System.out.println(autor);  // Exibe o toString()
    }
}
