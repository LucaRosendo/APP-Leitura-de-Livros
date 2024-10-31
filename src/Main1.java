import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import main.controller.GerenciamentoAutores;
import main.controller.GerenciamentoLivros;
import main.controller.GerenciamentoUsuarios;
import main.model.Administrador;
import main.model.Assinatura;
import main.model.Autor;
import main.model.Livro;
import main.model.Status;
import main.model.Usuario;

public class Main1 {
    static List<Livro> livros = new ArrayList<>();
    static List<Usuario> usuarios = new ArrayList<>();
    static GerenciamentoAutores gerenciamentoAutores = new GerenciamentoAutores();
    static GerenciamentoLivros gerenciamentoLivros = new GerenciamentoLivros(gerenciamentoAutores); 
    static  GerenciamentoUsuarios gerenciamentoUsuarios = new GerenciamentoUsuarios();
    public static void main(String[] args) {
  

        

    

    try {
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
        Livro livro1 = new Livro("Harry Potter e a Pedra Filosofal",("Fantasia"), "Fantasia",
                        gerenciamentoAutores.getAutores().get(0), 1997, true, status,"Primeiro livro da série Harry Potter, onde Harry descobre que é um bruxo e inicia sua jornada na escola de magia Hogwarts, enfrentando desafios e fazendo amigos.");
        livros.add(livro1);
        gerenciamentoAutores.getAutores().get(0).adicionarPublicacao(livro1.getNome());

        Livro livro2 = new Livro("Harry Potter e a Câmara Secreta",("Fantasia"), "Fantasia",
                        gerenciamentoAutores.getAutores().get(0), 1998, true, status,"O segundo livro da série, onde Harry retorna a Hogwarts e investiga uma câmara secreta que ameaça os alunos da escola, revelando segredos sobre seu passado.");
        livros.add(livro2);
        gerenciamentoAutores.getAutores().get(0).adicionarPublicacao(livro2.getNome());

        Livro livro3 = new Livro("Harry Potter e o Prisioneiro de Azkaban","Fantasia", "Fantasia",
                        gerenciamentoAutores.getAutores().get(0), 1999, true, status,"No terceiro livro, Harry descobre mais sobre seus pais e enfrenta o fugitivo Sirius Black, enquanto aprende mais sobre a magia e seus próprios poderes.");
        livros.add(livro3);
        gerenciamentoAutores.getAutores().get(0).adicionarPublicacao(livro3.getNome());

        Livro livro4 = new Livro("456", "Fantasia", "Fantasia",
                        gerenciamentoAutores.getAutores().get(0), 2000, false, status,"Um título que pode ser fictício ou não muito conhecido, sem informações adicionais.");
        livros.add(livro4);
        gerenciamentoAutores.getAutores().get(0).adicionarPublicacao(livro4.getNome());

        Livro livro5 = new Livro("O Sítio do Picapau Amarelo","Infantil", "Infantil",
                        gerenciamentoAutores.getAutores().get(1), 1920, true, status,"Clássico da literatura infantil brasileira, que narra as aventuras de Narizinho e seus amigos no Sítio, abordando temas de fantasia e amizade.");
        livros.add(livro5);
        gerenciamentoAutores.getAutores().get(1).adicionarPublicacao(livro5.getNome());

        Livro livro7 = new Livro("Caçadas de Pedrinho","Infantil", "Infantil",
                        gerenciamentoAutores.getAutores().get(1), 1933, true, status,"Outro livro infantil de Monteiro Lobato, que continua as aventuras de personagens do Sítio do Picapau Amarelo, focando em Pedrinho e suas caçadas.");
        livros.add(livro7);
        gerenciamentoAutores.getAutores().get(1).adicionarPublicacao(livro7.getNome());

        Livro livro8 = new Livro("Dom Casmurro", "Romance", "Romance",
                        gerenciamentoAutores.getAutores().get(2), 1899, true, status,"Romance de Machado de Assis que narra a vida de Bentinho e suas inseguranças sobre o amor e a traição, explorando temas de ciúme e memória. ");
        livros.add(livro8);
        gerenciamentoAutores.getAutores().get(2).adicionarPublicacao(livro8.getNome());

        Livro livro9 = new Livro("Memórias Póstumas de Brás Cubas", "Romance", "Romance",
                        gerenciamentoAutores.getAutores().get(2), 1881, true, status,"Uma obra-prima de Machado de Assis, que apresenta a história de Brás Cubas, um defunto autor que narra sua vida e críticas à sociedade brasileira do século XIX, com uma narrativa inovadora e humorística. ");
        livros.add(livro9);
        gerenciamentoAutores.getAutores().get(2).adicionarPublicacao(livro9.getNome());

} catch (IllegalArgumentException e) {
        System.err.println(e.getMessage());
}






Administrador adm = new Administrador("admin", "admin123"); 
usuarios.add(adm);
usuarios.add(new Usuario("user1", "user123", "FREE")); 
usuarios.add(new Usuario("user2", "user456", "VIP"));  

Scanner scanner = new Scanner(System.in);
Usuario loggedUser  = login(scanner, usuarios);

if (loggedUser  != null) {
    if (loggedUser  instanceof Administrador) {
        administradorMenu(gerenciamentoAutores, gerenciamentoLivros, scanner);
    } else {
        usuarioMenu(gerenciamentoUsuarios, livros, scanner, loggedUser );
    }
}

scanner.close();
}

    private static Usuario login(Scanner scanner, List<Usuario> usuarios) {
        System.out.println("=========== LOGIN ===========");
        System.out.print("Digite seu nome de usuário: ");
        String nome = scanner.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();

        for (Usuario user : usuarios) {
            if (user.getNome().equals(nome) && user.getCpf().equals(senha)) {
                System.out.println("Login bem-sucedido! Bem-vindo, " + user.getNome() + ".");
                return user;
            }
        }
        
        System.out.println("Credenciais inválidas. Encerrando o programa.");
        return null;}



    private static void administradorMenu(GerenciamentoAutores gerenciamentoAutores, GerenciamentoLivros gerenciamentoLivros, Scanner scanner) {
        boolean exit = false;

        while (!exit) {
            System.out.println("=============MENU PRINCIPAL  ADMINSTRADOR=============");
            System.out.println("1. Adicionar");
            System.out.println("2. Atualizar");
            System.out.println("3. Remover");
            System.out.println("4. Listar");
            System.out.println("5. Buscar");
            System.out.println("6. Sair");
            System.out.println("========================================");
            System.out.print("Escolha uma opção: \n");  
            int mainOption = scanner.nextInt();
            scanner.nextLine(); 

            switch (mainOption) {
                    case 1:
                    boolean addExit = false;
                    while (!addExit) {
                        System.out.println("=============MENU ADICIONAR=============");
                        System.out.println("1. Autor");
                        System.out.println("2. Livro");
                        System.out.println("3. Voltar ");
                        System.out.print("Escolha uma opção: \n");
                        int addOption = scanner.nextInt();
                        scanner.nextLine();
    
                   

                                    switch(addOption){
                                        
                                            case 1: 
                                                    System.out.println("Digite o nome do autor: ");
                                                    String autorNome = scanner.nextLine();
                                                    System.out.println("Descrição do autor : ");
                                                    String descricaoautor= scanner.nextLine();
                                                    System.out.println("Avaliaçãdo Autor");
                                                    String avaliacaoautor = scanner.nextLine();
                                                    gerenciamentoAutores.adicionarAutor(new Autor(autorNome, new ArrayList<>(), descricaoautor, avaliacaoautor));

                                                    
                                                    break;
                                                    case 2:
                                                    Status status = new Status();
                                                    System.out.println("Digite o nome do Livro: ");
                                                    String livroNome = scanner.nextLine();
                                                    System.out.println("Descrição do Livro: ");
                                                    String livroDescricao = scanner.nextLine();
                                                    System.out.println("Gênero do Livro: ");
                                                    String generoLivro = scanner.nextLine();
                                                    System.out.println("Nome do autor do livro: ");
                                                    String Nomeautor = scanner.nextLine();
                                                    System.out.println("Ano de publicação: ");
                                                    int anoPublicacao = scanner.nextInt();
                                                    scanner.nextLine(); 
                                                    String conteudolivro= scanner.nextLine();
                                                
                                                    Autor autorLivro = null;
                                                    for (Autor autor : gerenciamentoAutores.getAutores()) {
                                                        if (autor.getNome().equalsIgnoreCase(Nomeautor)) {
                                                           autorLivro = autor;
                                                            break;
                                                        }
                                                    }
                                                
                                                    if (autorLivro != null) {
                                                        Livro novoLivro = new Livro(livroNome, generoLivro, livroDescricao, autorLivro, anoPublicacao, true, status,conteudolivro);
                                                        livros.add(novoLivro);
                                                        autorLivro.adicionarPublicacao(novoLivro.getNome());
                                                        System.out.println("Livro adicionado com sucesso!");
                                                    } else {
                                                        System.out.println("Autor não encontrado na lista.");
                                                    }
                                                    break;
                                                    case 3: 
                                                        addExit = true;
                                                        break;
                                                    
                                                   


                                    }
                           }
                           case 2:
                           System.out.println("=============MENU ATUALIZAR=============");
                           System.out.println("1. Autor");
                           System.out.println("2. Livro");
                           System.out.println("3. Voltar");
                           System.out.println("========================================");
                           System.out.print("Escolha uma opcao: \n");
                           int updateOption = scanner.nextInt();
                           scanner.nextLine();
                           
                           break;
                   case 3:
                           System.out.println("=============MENU REMOVER===============");
                           System.out.println("1. Autor");
                           System.out.println("2. Usuario");
                           System.out.println("3. Livro");
                           System.out.println("4. Voltar");
                           System.out.println("========================================");
                           System.out.print("Escolha uma opcao: \n");
                           int removeOption = scanner.nextInt();
                           scanner.nextLine();
                           
                           switch (removeOption) {
                                   case 1:
                                           System.out.println("Digite o nome do autor: ");
                                           String autorNome = scanner.nextLine();
                                           gerenciamentoAutores.removerAutor(autorNome);
                                           break;
                                   case 2:
                                           System.out.println("Digite o nome do usuário: ");
                                           String usuarioNome = scanner.nextLine();
                                           gerenciamentoUsuarios.removerUsuario(usuarioNome);
                                           break;
                                   case 3:
                                           System.out.println("Digite o nome do livro: ");
                                           String livroNome = scanner.nextLine();
                                           gerenciamentoLivros.removerLivro(livroNome);
                                           break;
                                   case 4:
                                           break;
                                   default:
                                           System.out.println("Opcao invalida. Tente novamente.");
                           }
                           break;
                   case 4:
                           System.out.println("=============MENU LISTAR================");
                           System.out.println("1. Autor");
                           System.out.println("2. Usuario");
                           System.out.println("3. Livro");
                           System.out.println("4. Voltar");
                           System.out.println("========================================");
                           System.out.print("Escolha uma opcao: \n");
                           int listOption = scanner.nextInt();
                           scanner.nextLine();
                           
                           switch (listOption) {
                                   case 1:
                                           gerenciamentoAutores.listarAutores();
                                           break;
                                   case 2:
                                           gerenciamentoUsuarios.listarAssinaturas();
                                           break;
                                   case 3:
                                           gerenciamentoLivros.listarLivros();
                                           break;
                                   case 4:
                                           break;
                                   default:
                                           System.out.println("Opcao invalida. Tente novamente.");
                           }
                           break;
                   case 5:
                           System.out.println("=============MENU BUSCAR================");
                           System.out.println("1. Autor");
                           System.out.println("2. Usuario");
                           System.out.println("3. Livro");
                           System.out.println("4. Voltar");
                           System.out.println("========================================");
                           System.out.print("Escolha uma opcao: \n");
                           int searchOption = scanner.nextInt();
                           scanner.nextLine();
                           
                           switch (searchOption) {
                                   case 1:
                                           System.out.println("Digite o nome do autor: ");
                                           String autorNome = scanner.nextLine();
    
                                           Optional<Autor> autorEncontrado = gerenciamentoAutores.buscarAutor(autorNome);
                                           autorEncontrado.ifPresentOrElse(
                                           autor -> System.out.println("Autor encontrado: " + autor.getNome()),
                                           () -> System.out.println("Autor não encontrado: " + autorNome));
                                           break;
                                        
                                   case 2:
                                            System.out.println("Digite o nome do usuário: ");
                                            String usuarioNome = scanner.nextLine();
    
                                            Optional<Assinatura> assinaturaEncontrada = gerenciamentoUsuarios.buscarAssinatura(usuarioNome);
                                            assinaturaEncontrada.ifPresentOrElse(
                                            assinatura -> System.out.println("Assinatura encontrada para o usuário: " + assinatura.getTitular().getNome()),
                                            () -> System.out.println("Usuário não encontrado: " + usuarioNome)
                                            );
                                            break;

                                    case 3:
                                            System.out.println("Digite o nome do livro: ");
                                            String livroNome = scanner.nextLine();
    
                                            Optional<Livro> livroEncontrado = gerenciamentoLivros.buscarLivro(livroNome);
                                            livroEncontrado.ifPresentOrElse(
                                            livro -> System.out.println("Livro encontrado: " + livro.getNome()),
                                            () -> System.out.println("Livro não encontrado: " + livroNome)
                                            );
                                            break;

                                   case 4:
                                           break;
                                   default:
                                           System.out.println("Opcao invalida. Tente novamente.");
                           }
                           break;
                   case 6:
                           exit = true;
                           break;
                   default:
                           System.out.println("Opcao invalida. Tente novamente.");
           }
   }

   scanner.close();
}
private static void usuarioMenu(GerenciamentoUsuarios gerenciamentoUsuarios, List<Livro> livros, Scanner scanner, Usuario user) {
    boolean exit = false;

    while (!exit) {
        System.out.println("\n============= USUÁRIO =============");
        System.out.println("1. Visualizar Biblioteca");
        System.out.println("2. Configurar Perfil");
        System.out.println("3. Sair");
        System.out.print("Escolha uma opção: ");
        int userOption = scanner.nextInt();
        scanner.nextLine();

        switch (userOption) {
            case 1 -> {
                System.out.println("\nBiblioteca:");
                for (int i = 0; i < livros.size(); i++) {
                    System.out.println((i + 1) + ". " + livros.get(i).getNome());
                }

                System.out.print("Escolha o número do livro para visualizar detalhes (ou 0 para voltar): ");
                int livroEscolhido = scanner.nextInt();
                scanner.nextLine(); 

                if (livroEscolhido > 0 && livroEscolhido <= livros.size()) {
                    Livro livro = livros.get(livroEscolhido - 1);
                    System.out.println("Título: " + livro.getNome());
                    System.out.println("Gênero: " + livro.getGenero());
                    System.out.println("Descrição: " + livro.getDescricao());


                    if (user.getTipoAssinatura().equals("VIP") && livro.isDisponibilidade()) {
                        System.out.println("Conteúdo: " + livro.getConteudo());
                    } else if (user.getTipoAssinatura().equals("FREE") && !livro.isDisponibilidade()) {
                        System.out.println("Conteúdo: " + livro.getConteudo());
                    } else {
                        System.out.println("Conteúdo indisponível para seu tipo de assinatura ou status do livro.");
                    }
                } else if (livroEscolhido == 0) {
                    System.out.println("Voltando ao menu principal...");
                } else {
                    System.out.println("Opção inválida. Tente novamente.");
                }
            }
            case 2 -> {
                System.out.println("Configurações do Perfil:");
                System.out.println("Nome: " + user.getNome());
                System.out.println("Tipo de Assinatura: " + user.getTipoAssinatura());
            }
            case 3 -> exit = true;
            default -> System.out.println("Opção inválida. Tente novamente.");
        }
    }
}}
