package src.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import src.participantes.Organizador;

public class Evento {

    // Atributos da Classe Evento
    private String nome;
    private String titulo;
    private String data_inicio;
    private String data_fim;
    private String local;
    private String horario_inicio;
    private String carga_horaria;
    private String descricao;
    private String categoria;
    private int limite_participantes;

    private List<Participante> participantes = new ArrayList<>();
    private List<Participante> participantesPresentes = new ArrayList<>();
    private List<Organizador> organizadores = new ArrayList<>();
    private Participante participante;

    // Método Construtor

    public Evento() {

    }

    public Evento(String nome, String titulo, String descricao,
            String categoria, String local, String data_inicio, String data_fim,
            String horario_inicio, String carga_horaria, int limite_participantes) {
        this.nome = nome;
        this.titulo = titulo;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.local = local;
        this.horario_inicio = horario_inicio;
        this.carga_horaria = carga_horaria;
        this.descricao = descricao;
        this.categoria = categoria;
        this.limite_participantes = limite_participantes;
    }

    // Métodos getters e setters da Classe Evento
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

    public String getHorario_inicio() {
        return horario_inicio;
    }

    public void setHorario_inicio(String horario_inicio) {
        this.horario_inicio = horario_inicio;
    }

    public String getCarga_horaria() {
        return carga_horaria;
    }

    public void setCarga_horaria(String carga_horaria) {
        this.carga_horaria = carga_horaria;
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

    public int getLimite_participantes() {
        return limite_participantes;
    }

    public void setLimite_participantes(int limite_participantes) {
        this.limite_participantes = limite_participantes;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }

    public List<Organizador> getOrganizadores() {
        return organizadores;
    }

    public void setOrganizadores(List<Organizador> organizadores) {
        this.organizadores = organizadores;
    }

    public boolean validarEvento() {
        boolean valido = true;

        LocalDate dataAtual = LocalDate.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate dataInicio = LocalDate.parse(getData_inicio(), formatter);

        if (dataInicio.isBefore(dataAtual)) {
            valido = false;
        }

        if (valido) {
            return true;
        } else {
            return false;
        }

    }

    // Registrar Presença

    public void registrarPresenca() {
        String i;
        participante.listarParticipantes(participantes);
        i = JOptionPane.showInputDialog("Insira o cpf do participante:");
        for (Participante participante : participantesPresentes){
            if (i.equals(participante.getCpf())){
                participantesPresentes.add(participante);
            }
        }
    }

}
