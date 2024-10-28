import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import main.controller.GerenciamentoLivros;
import main.controller.GerencimentoUsuarios;
import main.model.Autor;
import main.model.Livro;
import main.model.Status;
import main.model.Usuario;
import java.util.HashMap;



public class Main {
    Scanner input =new Scanner(System.in);

    static ArrayList<Livro> biblioteca = new ArrayList<Livro>();
    static HashMap< String , Autor> ListaAutores= new HashMap<>();



    static void carregaLivros() {
  


        Autor autor1 = new Autor("J.K. Rowling", List.of("Harry Potter e a Pedra Filosofal", "Harry Potter e a Câmara Secreta"), "Escritora britânica", "5 estrelas");
        Autor autor2 = new Autor("George Orwell", List.of("1984", "A Revolução dos Bichos"), "Escritor britânico", "5 estrelas");
        Autor autor3 = new Autor("J.R.R. Tolkien", List.of("O Senhor dos Anéis", "O Hobbit"), "Escritor britânico", "5 estrelas");
        Autor autor4 = new Autor("Agatha Christie", List.of("E Não Sobrou Nenhum", "O Assassinato de Roger Ackroyd"), "Rainha do Crime", "5 estrelas");
        Autor autor5 = new Autor("F. Scott Fitzgerald", List.of("O Grande Gatsby"), "Romancista americano", "5 estrelas");

  /*
ListaAutores.put(autor1.getNome(), autor1);
        ListaAutores.put(autor2.getNome(), autor2);
        ListaAutores.put(autor3.getNome(), autor3);
        ListaAutores.put(autor4.getNome(), autor4);
        ListaAutores.put(autor5.getNome(), autor5);   */      







        Livro livro1 = new Livro("Harry Potter e a Pedra Filosofal", List.of("Fantasia", "Aventura"), "Harry Potter e a Pedra Filosofal é o primeiro livro da série Harry Potter de J.K. Rowling.", autor1, 223, true, new Status());
        Livro livro2 = new Livro("1984", List.of("Ficção Científica", "Distopia"), "Uma crítica à sociedade totalitária.", autor2, 328, true, new Status());
        Livro livro3 = new Livro("O Senhor dos Anéis: A Sociedade do Anel", List.of("Fantasia"), "O início da jornada épica pela Terra-média.", autor3, 423, true, new Status());
        Livro livro4 = new Livro("O Hobbit", List.of("Fantasia", "Aventura"), "A aventura de Bilbo Bolseiro.", autor3, 310, true, new Status());
        Livro livro5 = new Livro("E Não Sobrou Nenhum", List.of("Mistério"), "Um grupo de pessoas é convidado para uma ilha e começa a morrer um por um.", autor4, 264, true, new Status());
        Livro livro6 = new Livro("O Grande Gatsby", List.of("Ficção"), "A história de Jay Gatsby e sua busca por amor.", autor5, 180, true, new Status());

        biblioteca.add(livro1);
        biblioteca.add(livro2);
        biblioteca.add(livro3);
        biblioteca.add(livro4);
        biblioteca.add(livro5);
        biblioteca.add(livro6);
        
        
        
 
        
 
        
 
        
 
        


    }

    public static void main(String[] args) throws Exception {
        carregaLivros();

/*         Usuario user = new Usuario(null, null, 0);
        user.setBiblioteca(biblioteca);
*/
      // Exibir informações dos livros na biblioteca
      for (Livro livro : biblioteca) {
            System.out.println(livro.obterInformacoes());
           
        } 
        Autor autor = ListaAutores.get("J.K. Rowling");
            System.out.println(autor);
            if (autor != null) {
                System.out.println("Nome: " + autor.getNome());
                System.out.println("Descrição: " + autor.getDescricao());
                System.out.println("Publicações: " + autor.listarPublicacoes());
            }


    }
}
