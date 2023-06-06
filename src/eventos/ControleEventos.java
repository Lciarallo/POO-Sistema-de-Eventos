package src.eventos;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import src.participantes.Organizador;
import src.participantes.Participante;

public class ControleEventos {

    private Evento evento = new Evento();
    private List<Evento> eventos = new ArrayList<>();

    // Métodos

    public List<Evento> getEventos() {
        return eventos;
    }

    public void listarEventoCompleto(List<Evento> eventos, List<Organizador> organizadores) {

        String aux = "";
        for (Evento e : eventos) {
            for (Organizador o : organizadores) {

                aux = aux + "Indice: " + eventos.indexOf(e) + "\nNome: " + e.getNome() + "\nTítulo: " + e.getTitulo()
                        + "\nDescrição: " + e.getDescricao()
                        + "\nCategoria: " + e.getCategoria() + "\nLocal: " + e.getLocal() + "\nData de início: "
                        + e.getData_inicio() + "\nData de encerramento:" + e.getData_fim()
                        + "\nHorário: " + e.getHorario_inicio() + "h" + "\nCarga Horária: " + e.getCarga_horaria() + "h"
                        + "\nLimite de Participantes" + e.getLimite_participantes() + "\nOrganizador: " + o.getNome();
            }
        }

        JOptionPane.showMessageDialog(null,
                "Lista de Eventos:\n" + aux);
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

    public void pesquisarEvento(List<Evento> eventos){
        String pesquisa;
        pesquisa = JOptionPane.showInputDialog("Insira o nome do evento que queira pesquisar:");
        for (Evento evento : eventos){
            if (pesquisa.equals(evento.getNome())){
                JOptionPane.showMessageDialog(null, "Evento: " + evento.getNome() + "\n");
            }
        }
    }

}
    // Gerar Relatório

    // Agenda de Eventos

