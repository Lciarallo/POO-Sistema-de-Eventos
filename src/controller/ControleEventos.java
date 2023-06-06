package src.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import src.model.Evento;
import src.model.Participante;
import src.participantes.Organizador;

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

    public List<Evento> listarEventosDisponivelParaInscricao(List<Evento> eventos) {

        List<Evento> eventosDisponiveis = new ArrayList<>();
        for (Evento e : eventos) {

            if (e.validarEvento()) {
                eventosDisponiveis.add(e);
            }
        }

        if (eventosDisponiveis.size() > 0) {

            listarEventos(eventosDisponiveis);
        }

        return eventosDisponiveis;
    }

    public void ListarEventoComParticipantes(List<Evento> eventos) {
        for (Evento evento : eventos) {

            for (Participante participante : evento.getParticipantes()) {
                JOptionPane.showMessageDialog(null, "Evento: " + evento.getNome() + "\n"
                        + "Participantes: " + participante.getNome());
            }
        }
    }

    public void ListarEventoComParticipantesPresentes(List<Evento> eventos) {
        for (Evento evento : eventos) {

            for (Participante participante : evento.getParticipantesPresentes()) {
                JOptionPane.showMessageDialog(null, "Evento: " + evento.getNome() + "\n"
                        + "Participantes Presentes: " + participante.getNome());
            }
        }
    }

    // Buscar Evento

    public void pesquisarEvento(List<Evento> eventos) {
        String pesquisa;
        pesquisa = JOptionPane.showInputDialog("Insira o nome do evento que queira pesquisar:");
        for (Evento evento : eventos) {
            if (pesquisa.equals(evento.getNome())) {
                JOptionPane.showMessageDialog(null, "Evento: " + evento.getNome() + "\n");
            }
        }
    }

    // Gerar Relatório

    // Agenda de Eventos

}
