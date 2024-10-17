package main.model;

import java.util.List;

public class Assinatura {

    private int limiteAcesso;
    private List<String> beneficios;
    private boolean status;

    public Assinatura(int limiteAcesso, List<String> beneficios, boolean status) {
        this.limiteAcesso = limiteAcesso;
        this.beneficios = beneficios;
        this.status = status;
    }

    public void iniciarSistema() {
        // Implementação do método para iniciar o sistema
    }

    public boolean verificaAcesso() {
        // Implementação do método para verificar acesso
        return status && limiteAcesso > 0;
    }

    public List<String> listaBeneficio() {
        // Implementação do método para listar benefícios
        return beneficios;
    }

    public void atualizarAssinatura(int novoLimiteAcesso, List<String> novosBeneficios, boolean novoStatus) {
        this.limiteAcesso = novoLimiteAcesso;
        this.beneficios = novosBeneficios;
        this.status = novoStatus;
    }

    public void cancelarAssinatura() {
        this.status = false;
    }

    // Getters e Setters
    public int getLimiteAcesso() {
        return limiteAcesso;
    }

    public void setLimiteAcesso(int limiteAcesso) {
        this.limiteAcesso = limiteAcesso;
    }

    public List<String> getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(List<String> beneficios) {
        this.beneficios = beneficios;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
