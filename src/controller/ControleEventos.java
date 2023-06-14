package src.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import src.model.Evento;
import src.model.Participante;
import src.model.participantes.Organizador;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;


public class ControleEventos {

    private List<Evento> eventos = new ArrayList<>();

    // Métodos

    public List<Evento> getEventos() {
        return eventos;
    }

    public void listarEventoCompleto(List<Evento> eventos, List<Organizador> organizadores) {

        for (Evento e : eventos) {
            String aux = "\nIndice: " + eventos.indexOf(e) + "\nNome: " + e.getNome() + "\nTítulo: " + e.getTitulo()
                    + "\nDescrição: " + e.getDescricao()
                    + "\nCategoria: " + e.getCategoria() + "\nLocal: " + e.getLocal() + "\nData de início: "
                    + e.getData_inicio() + "\nData de encerramento:" + e.getData_fim()
                    + "\nHorário: " + e.getHorario_inicio() + "h" + "\nCarga Horária: " + e.getCarga_horaria() + "h"
                    + "\nLimite de Participantes: " + e.getLimite_participantes() + "\n";

            String x = "\nOrganizadores:";
            List<Organizador> organizadoresAssociados = e.getOrganizadores();
            for (Organizador o : organizadoresAssociados) {
                x += "\n" + o.getNome();
            }

            JOptionPane.showMessageDialog(null, "Lista de Eventos:\n" + aux + x + "\n");
        }

    }

    public void listarEventos(List<Evento> eventos) {

        String aux = "";
        for (Evento e : eventos) {
            aux = aux + eventos.indexOf(e) + " " + e.getNome() + " " + e.getData_inicio() + "\n";
        }

        JOptionPane.showMessageDialog(null,
                "Lista de Eventos:\n" + aux);
    }

    public List<Evento> listarEventosNaoOcorridos(List<Evento> eventos) {

        List<Evento> eventosNaoOcorridos = new ArrayList<>();
        for (Evento e : eventos) {

            if (e.validarEvento()) {
                eventosNaoOcorridos.add(e);
            }
        }

        if (eventosNaoOcorridos.size() > 0) {

            listarEventos(eventosNaoOcorridos);
        }

        return eventosNaoOcorridos;
    }

    public void ListarEventoComParticipantes(List<Evento> eventos) {
        for (Evento evento : eventos) {

            for (Participante participante : evento.getParticipantes()) {
                JOptionPane.showMessageDialog(null, "Evento: " + evento.getNome() + "\n"
                        + "Participantes: " + participante.getNome());
            }
        }
    }

    // Buscar Evento

    public void pesquisarEvento(List<Evento> eventos, String pesquisa) {
        pesquisa = JOptionPane.showInputDialog("Insira o nome do evento que queira pesquisar:");
        for (Evento evento : eventos) {
            if (pesquisa.equals(evento.getNome())) {
                JOptionPane.showMessageDialog(null,
                        "Evento: " + evento.getNome() + "\n" +
                        "Categoria: " + evento.getCategoria() + "\n" +
                        "Data Início: " + evento.getData_inicio() + "\n" +
                        "Data Fim: " + evento.getData_fim() + "\n" +
                        "Descrição: " + evento.getDescricao() + "\n" +
                        "Titulo: " + evento.getTitulo() + "\n" +
                        "Local do Evento: " + evento.getLocal() + "\n" +
                        "Limite de participantes: " + evento.getLimite_participantes() + "\n" +
                        "Carga Horária: " + evento.getCarga_horaria() + "\n" +
                        "Horário Inicio: " + evento.getHorario_inicio() + "\n");

            }
        }
    }

    public void relatorioEventos(List<Evento> eventos, List<Organizador> organizadores) {

        for (Evento e : eventos) {
            String aux = "\nIndice: " + eventos.indexOf(e) + "\nNome: " + e.getNome() + "\nTítulo: " + e.getTitulo()
                    + "\nDescrição: " + e.getDescricao()
                    + "\nCategoria: " + e.getCategoria() + "\nLocal: " + e.getLocal() + "\nData de início: "
                    + e.getData_inicio() + "\nData de encerramento:" + e.getData_fim()
                    + "\nHorário: " + e.getHorario_inicio() + "h" + "\nCarga Horária: " + e.getCarga_horaria() + "h"
                    + "\nLimite de Participantes: " + e.getLimite_participantes() + "\n"
                    + "\nParticipantes Inscritos: " + e.getParticipantes() + "\n"
                    + "\nParticipantes Presentes: " + e.getParticipantesPresentes() + "\n";

            String x = "\nOrganizadores:";
            List<Organizador> organizadoresAssociados = e.getOrganizadores();
            for (Organizador o : organizadoresAssociados) {
                x += "\n" + o.getNome();
            }

            JOptionPane.showMessageDialog(null, "Lista de Eventos:\n" + aux + x + "\n");
        }

    }

    public void mostrarAgenda(List<Evento> eventos){

        for (Evento e : eventos) {
            String aux = "\nIndice: " + eventos.indexOf(e) + "\nNome: " + e.getNome() + "\nTítulo: " + e.getTitulo()
                    + "\nDescrição: " + e.getDescricao()
                    + "\nCategoria: " + e.getCategoria() + "\nLocal: " + e.getLocal() + "\nData de início: "
                    + e.getData_inicio() + "\nData de encerramento:" + e.getData_fim() + "\n";

        }
    }

}
