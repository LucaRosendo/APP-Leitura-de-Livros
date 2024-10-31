import java.util.ArrayList;
import java.util.List;
import main.controller.GerenciamentoAutores;
import main.controller.GerenciamentoLivros;
import main.controller.GerenciamentoUsuarios;
import main.model.Autor;
import main.model.Livro;
import main.model.Status;
import main.model.Usuario;
import main.model.Administrador;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
                List<Livro> livros = new ArrayList<>();
                List<Usuario> usuarios = new ArrayList<>();

                GerenciamentoLivros gerenciamentoLivros = new GerenciamentoLivros();
                GerenciamentoUsuarios gerenciamentoUsuarios = new GerenciamentoUsuarios();
                GerenciamentoAutores gerenciamentoAutores = new GerenciamentoAutores();

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
                        Livro livro1 = new Livro("Harry Potter e a Pedra Filosofal", List.of("Fantasia"), "Fantasia",
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

                        Livro livro4 = new Livro("456", List.of("Fantasia"), "Fantasia",
                                        gerenciamentoAutores.getAutores().get(0), 2000, true, status);
                        livros.add(livro4);
                        gerenciamentoAutores.getAutores().get(0).adicionarPublicacao(livro4.getNome());

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
                        gerenciamentoAutores.getAutores().get(2).adicionarPublicacao(livro9.getNome());

                } catch (IllegalArgumentException e) {
                        System.err.println(e.getMessage());
                }

                try {
                        Usuario usuario1 = new Usuario("Lucas Rosendo", "123456789", "Premium");
                        gerenciamentoUsuarios.adicionarUsuario(usuario1);

                        Usuario usuario2 = new Usuario("Maria Silva", "987654321", "Basic");
                        gerenciamentoUsuarios.adicionarUsuario(usuario2);

                        Usuario usuario3 = new Usuario("João Souza", "456789123", "Premium");
                        gerenciamentoUsuarios.adicionarUsuario(usuario3);

                        Usuario admin = new Usuario("Admin", "admin123", "Admin");
                        gerenciamentoUsuarios.adicionarUsuario(admin);

                } catch (IllegalArgumentException e) {
                        System.err.println(e.getMessage());
                }

                Administrador adm = new Administrador("Admin", "admin123");
                usuarios.add(adm);

                usuarios.add(new Usuario("Lucas Rosendo", "123456789", "Premium"));
                usuarios.add(new Usuario("Maria Silva", "987654321", "Basic"));

                Scanner scanner = new Scanner(System.in);
                Usuario loggedUser = login(scanner, usuarios);

                if (loggedUser != null) {
                        if (loggedUser instanceof Administrador) {
                                administradorMenu(gerenciamentoAutores, gerenciamentoLivros, gerenciamentoUsuarios, scanner);
                        } else {
                                usuarioMenu(gerenciamentoUsuarios, livros, scanner, loggedUser);
                        }
                }

                scanner.close();
        }

        private static Usuario login(Scanner scanner, List<Usuario> usuarios) {
                System.out.println("=========== LOGIN ===========");
                System.out.print("Digite seu nome de usuario: ");
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
                return null;
        }

        private static void administradorMenu(GerenciamentoAutores gerenciamentoAutores, GerenciamentoLivros gerenciamentoLivros, GerenciamentoUsuarios gerenciamentoUsuarios, Scanner scanner) {
                boolean exit = false;

                while (!exit) {
                        System.out.println("=============MENU PRINCIPAL ADMINSTRADOR=============");
                        System.out.println("1. Adicionar");
                        System.out.println("2. Atualizar");
                        System.out.println("3. Remover");
                        System.out.println("4. Listar");
                        System.out.println("5. Buscar");
                        System.out.println("6. Sair");
                        System.out.println("========================================");
                        System.out.print("Escolha uma opcao: \n");
                        int mainOption = scanner.nextInt();
                        scanner.nextLine();

                        switch (mainOption) {
                                case 1:
                                        while (!exit) {
                                                System.out.println("=============MENU ADICIONAR=============");
                                                System.out.println("1. Autor");
                                                System.out.println("2. Livro");
                                                System.out.println("3. Voltar");
                                                System.out.println("========================================");
                                                System.out.print("Escolha uma opcao: \n");
                                                int addOption = scanner.nextInt();
                                                scanner.nextLine();

                                                switch (addOption) {
                                                        case 1:
                                                                System.out.println("Digite o nome do autor: ");
                                                                String autorNome = scanner.nextLine();
                                                                gerenciamentoAutores.adicionarAutor(new Autor(autorNome, new ArrayList<>(), "", ""));
                                                                break;
                                                }
                                        }
                                        break;
                                case 2:
                                        System.out.println("=============MENU ATUALIZAR=============");
                                        System.out.println("1. Autor");
                                        System.out.println("2. Livro");
                                        System.out.println("3. Voltar");
                                        System.out.println("========================================");
                                        System.out.print("Escolha uma opcao: \n");
                                        int updateOption = scanner.nextInt();
                                        scanner.nextLine();
                                        // Implementar lógica para atualizar Autor, Usuario ou Livro
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
                                                        gerenciamentoAutores.buscarAutor(autorNome);
                                                        break;
                                                case 2:
                                                        System.out.println("Digite o nome do usuário: ");
                                                        String usuarioNome = scanner.nextLine();
                                                        gerenciamentoUsuarios.buscarAssinatura(usuarioNome);
                                                        break;
                                                case 3:
                                                        System.out.println("Digite o nome do livro: ");
                                                        String livroNome = scanner.nextLine();
                                                        gerenciamentoLivros.buscarLivro(livroNome);
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
                        System.out.println("\n============= USUARIO =============");
                        System.out.println("1. Visualizar Biblioteca");
                        System.out.println("2. Configurar Perfil");
                        System.out.println("3. Sair");
                        System.out.print("Escolha uma opcao: \n");
                        int userOption = scanner.nextInt();
                        scanner.nextLine(); // clear the buffer

                        switch (userOption) {
                                case 1: {
                                        System.out.println("\nBiblioteca:");
                                        for (int i = 0; i < livros.size(); i++) {
                                                System.out.println((i + 1) + ". " + livros.get(i).getNome());
                                                if (user.getTipoAssinatura().equals("FREE") && i >= 4) {
                                                        System.out.println("(Limite de visualizacao para conta FREE)");
                                                        break;
                                                }
                                        }
                                }
                                case 2: {
                                        System.out.println("Configuraoes do Perfil:");
                                        System.out.println("Nome: " + user.getNome());
                                        System.out.println("Tipo de Assinatura: " + user.getTipoAssinatura());
                                }
                                case 3: exit = true;
                                default: System.out.println("Opcao invalida. Tente novamente.");
                        }
                }
        }
}
