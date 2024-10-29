package main.controller;

import java.util.ArrayList;
import main.model.Assinatura;

public class GerenciamentoUsuarios {

    private final ArrayList<Assinatura> assinaturas = new ArrayList<>();

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

    public static void main(String[] args) {
        GerenciamentoUsuarios gerenciamento = new GerenciamentoUsuarios();

        Assinatura.TipoAssinatura tipo = Assinatura.TipoAssinatura.VIP;
        Assinatura assinatura = new Assinatura("Contrato123", "Lucas", "12345678900", tipo, true);

        gerenciamento.adicionarAssinatura(assinatura);
        gerenciamento.listarAssinaturas();

        Assinatura encontrada = gerenciamento.buscarAssinatura("Lucas");
        if (encontrada != null) {
            System.out.println("Assinatura encontrada: " + encontrada.getTitular().getNome());
        }

        gerenciamento.removerAssinatura("Lucas");
        gerenciamento.listarAssinaturas();
    }
}
