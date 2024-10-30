import java.util.ArrayList;
import java.util.List;
import main.controller.GerenciamentoAutores;
import main.controller.GerenciamentoLivros;
import main.controller.GerenciamentoUsuarios;
import main.model.Autor;
import main.model.Livro;
import main.model.Status;
import main.model.Usuario;

public class Main {
    public static void main(String[] args) {
        List<Livro> livros = new ArrayList<>();
        List<Usuario> usuarios = new ArrayList<>();

        GerenciamentoLivros gerenciamentoLivros = new GerenciamentoLivros();
        GerenciamentoUsuarios gerenciamentoUsuarios = new GerenciamentoUsuarios();
        GerenciamentoAutores gerenciamentoAutores = new GerenciamentoAutores();

        try {
            // Criando autores com publicações
            Autor autor1 = new Autor("J.K. Rowling",
                    new ArrayList<>(List.of("Harry Potter e a Pedra Filosofal", "Harry Potter e a Câmara Secreta")),
                    "Escritora britânica", "5 estrelas");
            gerenciamentoAutores.adicionarAutor(autor1);

            Autor autor2 = new Autor("Monteiro Lobato",
                    new ArrayList<>(List.of("O Sítio do Picapau Amarelo", "Reinações de Narizinho")),
                    "Escritor brasileiro", "4 estrelas");
            gerenciamentoAutores.adicionarAutor(autor2);

            Autor autor3 = new Autor("Machado de Assis",
                    new ArrayList<>(List.of("Dom Casmurro", "Memórias Póstumas de Brás Cubas")),
                    "Escritor brasileiro", "5 estrelas");
            gerenciamentoAutores.adicionarAutor(autor3);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        Status status = new Status();

        try {
            // Adicionando livros e publicações
            /*Livro livro1 = new Livro("Harry Potter e a Pedra Filosofal", List.of("Fantasia"), "Fantasia",
                    gerenciamentoAutores.getAutores().get(0), 1997, true, status);
            livros.add(livro1);
            gerenciamentoAutores.getAutores().get(0).adicionarPublicacao(livro1.getNome());

            Livro livro2 = new Livro("Harry Potter e a Câmara Secreta", List.of("Fantasia"), "Fantasia",
                    gerenciamentoAutores.getAutores().get(0), 1998, true, status);
            livros.add(livro2);
            gerenciamentoAutores.getAutores().get(0).adicionarPublicacao(livro2.getNome());

            Livro livro3 = new Livro("Harry Potter e o Prisioneiro de Azkaban", List.of("Fantasia"), "Fantasia",
                    gerenciamentoAutores.getAutores().get(0), 1999, true, status);
            livros.add(livro3);
            gerenciamentoAutores.getAutores().get(0).adicionarPublicacao(livro3.getNome());
 */
            // Adicionando o novo livro "456"
            Livro livro4 = new Livro("456", List.of("Fantasia"), "Fantasia",
                    gerenciamentoAutores.getAutores().get(0), 2000, true, status);
            livros.add(livro4);
            gerenciamentoAutores.getAutores().get(0).adicionarPublicacao(livro4.getNome());
            Livro livro5 = new Livro("456", List.of("Fantasia"), "Fantasia",
                    gerenciamentoAutores.getAutores().get(0), 2000, true, status);
            livros.add(livro5);
            gerenciamentoAutores.getAutores().get(0).adicionarPublicacao(livro4.getNome());
/* 
            Livro livro5 = new Livro("O Sítio do Picapau Amarelo", List.of("Infantil"), "Infantil",
                    gerenciamentoAutores.getAutores().get(1), 1920, true, status);
            livros.add(livro5);
            gerenciamentoAutores.getAutores().get(1).adicionarPublicacao(livro5.getNome());

            Livro livro6 = new Livro("Reinações de Narizinho", List.of("Infantil"), "Infantil",
                    gerenciamentoAutores.getAutores().get(1), 1931, true, status);
            livros.add(livro6);
            gerenciamentoAutores.getAutores().get(1).adicionarPublicacao(livro6.getNome());

            Livro livro7 = new Livro("Caçadas de Pedrinho", List.of("Infantil"), "Infantil",
                    gerenciamentoAutores.getAutores().get(1), 1933, true, status);
            livros.add(livro7);
            gerenciamentoAutores.getAutores().get(1).adicionarPublicacao(livro7.getNome());

            Livro livro8 = new Livro("Dom Casmurro", List.of("Romance"), "Romance",
                    gerenciamentoAutores.getAutores().get(2), 1899, true, status);
            livros.add(livro8);
            gerenciamentoAutores.getAutores().get(2).adicionarPublicacao(livro8.getNome());
            Livro livro9 = new Livro("Memórias Póstumas de Brás Cubas", List.of("Romance"), "Romance",
            gerenciamentoAutores.getAutores().get(2), 1881, true, status);
    livros.add(livro9);
    gerenciamentoAutores.getAutores().get(2).adicionarPublicacao(livro9.getNome());*/

    // Printando informações dos autores e suas publicações
    for (Autor autor : gerenciamentoAutores.getAutores()) {
        System.out.println("Autor: " + autor.getNome());

        System.out.println("Publicações: " + autor.getPublicacoes());
        System.out.println();
    }

    // Printando informações dos livros
    /* 
    for (Livro livro : livros) {
        System.out.println("Título: " + livro.getNome());
  
        System.out.println("Autor: " + livro.getAutor().getNome());

        System.out.println();
    } */

} catch (IllegalArgumentException e) {
    System.err.println(e.getMessage());
}
}
}

           