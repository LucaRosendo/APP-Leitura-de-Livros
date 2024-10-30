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
            throw new IllegalArgumentException("Usuário já existente: " + usuario.getNome());
        }
        usuarios.add(usuario);
        System.out.println("Usuário adicionado: " + usuario.getNome());
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
        System.out.println("Assinatura não encontrada: " + nome);
        return null;
    }

    public void listarAssinaturas() {
        if (assinaturas.isEmpty()) {
            System.out.println("Nenhuma assinatura disponível.");
        } else {
            for (Assinatura assinatura : assinaturas) {
                System.out.println(assinatura.getTitular().getNome());
            }
        }
    }
}
