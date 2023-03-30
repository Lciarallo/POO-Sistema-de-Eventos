
package src.eventos;

import java.time.LocalTime;

import javax.swing.JOptionPane;

public class Evento {
    private String nome;
    private String titulo;
    private String data_inicio;
    private String data_fim;
    private String local;
    private LocalTime horario_inicio;
    private LocalTime horario_fim;
    private double carga_horaria;
    private String organizadores;
    private String descricao;
    private String categoria;
    private int limite_convidados;
    private int num_interessados;
    private boolean iniciado = false;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(String data_inicio) {
        this.data_inicio = data_inicio;
    }

    public String getData_fim() {
        return data_fim;
    }

    public void setData_fim(String data_fim) {
        this.data_fim = data_fim;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public LocalTime getHorario_inicio() {
        return horario_inicio;
    }

    public void setHorario_inicio(LocalTime horario_inicio) {
        this.horario_inicio = horario_inicio;
    }

    public LocalTime getHorario_fim() {
        return horario_fim;
    }

    public void setHorario_fim(LocalTime horario_fim) {
        this.horario_fim = horario_fim;
    }

    public double getCarga_horaria() {
        return carga_horaria;
    }

    public void setCarga_horaria(double carga_horaria) {
        this.carga_horaria = carga_horaria;
    }

    public String getOrganizadores() {
        return organizadores;
    }

    public void setOrganizadores(String organizadores) {
        this.organizadores = organizadores;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getLimite_convidados() {
        return limite_convidados;
    }

    public void setLimite_convidados(int limite_convidados) {
        this.limite_convidados = limite_convidados;
    }

    public int getNum_interessados() {
        return num_interessados;
    }

    public void setNum_interessados(int num_interessados) {
        this.num_interessados = num_interessados;
    }

    public boolean isIniciado() {
        return iniciado;
    }

    public void setIniciado(boolean iniciado) {
        this.iniciado = iniciado;
    }

    public void iniciarEvento() {
        this.iniciado = true;
    }

    public void mostrarEvento() {

        JOptionPane.showMessageDialog(null,
                "Informações Sobre o Evento:\nEvento Iniciado: " + isIniciado() + "\n" + "Nome: " + getNome() + "\n"
                        + "Título: " + getTitulo() + "\n"
                        + "Data de Início: " + getData_inicio() + "\n" + "Data de Término: " + getData_fim() + "\n"
                        + "Local: " + getLocal() + "\n" + "Horário de Início: " + getHorario_inicio() + "h" + "\n"
                        + "Horário de Término: " + getHorario_fim() + "h" + "\n" + "Carga Horária: "
                        + getCarga_horaria() + "h"
                        + "\n"
                        + "Organizadores: " + getOrganizadores() + "\n" + "Descrição: " + getDescricao() + "\n"
                        + "Categoria: " + getCategoria() + "\n" + "Número de Participantes: " + getLimite_convidados()
                        + "\n"
                        + "Número de Interessados: " + getNum_interessados());
    }

}
