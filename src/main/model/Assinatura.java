package main.model;

import java.util.ArrayList;
import java.util.List;

public class Assinatura {

    private String contrato = null;
    private Usuario titular = null; // Usuário responsável pelo contrato
    private TipoAssinatura tipoAssinatura;
    private ArrayList<Usuario> usuarios = null;
    private List<String> beneficios;
    private boolean status; //Assinatura ativa ou não

    private static final int MAX_ACESSO_CONTA = 100;
    private static final int MAX_ACESSO_GRATIS = 50;

    public enum TipoAssinatura {
        FREE, VIP, COLABORADOR
    }

    public Assinatura(String contrato, String nome, String cpf, TipoAssinatura tipoAssinatura, boolean status) {
        this.contrato = contrato;
        this.setUsuario(nome, cpf);
        this.tipoAssinatura = tipoAssinatura;
        this.status = status;
    }

    public String getContrato() {
        return contrato;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }

    public Usuario getTitular() {
        return this.titular;
    }

    public Usuario getUsuario() {
        return this.titular;
    }

    public void setUsuario(String nome, String cpf) {
        this.titular = new Usuario(nome, cpf, MAX_ACESSO_CONTA);
        this.usuarios.add(this.titular);
    }

    public TipoAssinatura getTipoAssinatura() {
        return tipoAssinatura;
    }

    public void setTipoAssinatura(TipoAssinatura tipoAssinatura) {
        this.tipoAssinatura = tipoAssinatura;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
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

    public static int getMaxAcessoConta() {
        return MAX_ACESSO_CONTA;
    }

    public static int getMaxAcessoGratis() {
        return MAX_ACESSO_GRATIS;
    }

}
