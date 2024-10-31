package main.controller;

import main.model.Usuario;
import java.util.List;
import java.util.ArrayList;
import main.model.Assinatura;

public class GerenciamentoUsuarios {

    private final ArrayList<Assinatura> assinaturas = new ArrayList<>();
    private List<Usuario> usuarios;

    public GerenciamentoUsuarios() {
        this.usuarios = new ArrayList<>();
    }

    public void adicionarUsuario(Usuario usuario) {
        if (usuarios.stream().anyMatch(u -> u.getNome().equals(usuario.getNome()))) {
            throw new IllegalArgumentException("Usuario ja existente: " + usuario.getNome());
        }
        usuarios.add(usuario);
        System.out.println("Usuario adicionado: " + usuario.getNome());
    }

    public void removerUsuario(String nome) {
        boolean removed = usuarios.removeIf(u -> u.getNome().equals(nome));
        if (removed) {
            System.out.println("Usuario removido: " + nome);
        } else {
            System.out.println("Usuario nao encontrado: " + nome);
        }
    }

    public void adicionarAssinatura(Assinatura assinatura) {
        assinaturas.add(assinatura);
        System.out.println("Assinatura adicionada: " + assinatura.getTitular().getNome());
    }

    public void removerAssinatura(String nome) {
        assinaturas.removeIf(a -> a.getTitular().getNome().equals(nome));
        System.out.println("Assinatura removida: " + nome);
    }

    public Assinatura buscarAssinatura(String nome) {
        for (Assinatura assinatura : assinaturas) {
            if (assinatura.getTitular().getNome().equals(nome)) {
                return assinatura;
            }
        }
        System.out.println("Assinatura nao encontrada: " + nome);
        return null;
    }

    public void listarAssinaturas() {
        if (assinaturas.isEmpty()) {
            System.out.println("Nenhuma assinatura disponivel.");
        } else {
            for (Assinatura assinatura : assinaturas) {
                System.out.println(assinatura.getTitular().getNome());
            }
        }
    }
}
