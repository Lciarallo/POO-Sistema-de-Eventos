package src.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import src.model.Evento;
import src.model.Participante;
import src.model.participantes.Organizador;

public class ControleEventos {

    private List<Evento> eventos = new ArrayList<>();

    // Métodos

    public List<Evento> getEventos() {
        return eventos;
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

}
