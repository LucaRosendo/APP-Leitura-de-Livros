package main.model;

import java.util.ArrayList;
import java.util.List;

public class Administrador extends Usuario{

 //   private String nome;
    private String senhaAcesso;
    private List<Autor> autores;
    private List<Livro> livros;

    public Administrador(String nome, String senhaAcesso ) {
        super(nome ,senhaAcesso,"VIP");

        this.autores = new ArrayList<>();
        this.livros = new ArrayList<>();
    }

 /*   public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
*/
    public String getSenhaAcesso() {
        return senhaAcesso;
    }

    public void setSenhaAcesso(String senhaAcesso) {
        this.senhaAcesso = senhaAcesso;
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

    public void adicionarAutor(String autorNome) {
        Autor autor = new Autor(autorNome, new ArrayList<>(), "", "");
        this.autores.add(autor);
    }

    public void removerAutor(String autorNome) {
        this.autores.removeIf(autor -> autor.getNome().equals(autorNome));
    }

    public void adicionarLivro(String livroNome, boolean disponibilidade) {
        Livro livro = new Livro(livroNome,"","", null, 0, disponibilidade, new Status(),"");
        this.livros.add(livro);
    }

    public void removerLivro(String livroNome) {
        this.livros.removeIf(livro -> livro.getNome().equals(livroNome));
    }
}
