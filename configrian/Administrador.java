
import java.util.List;

public class Administrador {

    private String nome;
    private String senhaAcesso;
    private List<Autor> autores;
    private List<Livro> livros;

    public Administrador(String nome, String senhaAcesso, List<Autor> autores, List<Livro> livros) {
        this.nome = nome;
        this.senhaAcesso = senhaAcesso;
        this.autores = autores;
        this.livros = livros;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenhaAcesso() {
        return senhaAcesso;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public void setSenhaAcesso(String senhaAcesso) {
        this.senhaAcesso = senhaAcesso;
    }

    public void adicionarAutor(String autorNome) {
        Autor autor = new Autor(autorNome, List.of(), "", "");
        this.autores.add(autor);
    }

    public void adicionarLivro(String livroNome, boolean disponibilidade) {
        Livro livro = new Livro(livroNome, List.of(), "", "", disponibilidade);
        this.livros.add(livro);
    }

    public void removerAutor(String autor) {

    }

    public void removerLivro(String livro) {

    }

    public static void main(String[] args) {
        Administrador administrador = new Administrador("Lucas", "Lucas123",
                List.of(new Autor("Monteiro Lobato", List.of(), "", "")),
                List.of(new Livro("Sítio do Pica-pau Amarelo", List.of(), "", "", true)));

        //administrador.adicionarAutor("Monteiro Lobato");
        //administrador.adicionarLivro("Sítio do Pica-pau Amarelo", true);
        System.out.println(administrador.getNome());
        System.out.println(administrador.getAutores());
        System.out.println(administrador.getLivros());
    }
}
