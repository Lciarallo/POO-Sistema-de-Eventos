package src.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import src.model.Evento;

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


    public void mostrarAgenda(List<Evento> eventos) {

        for (Evento e : eventos) {
            String aux = "\nNome: " + e.getNome() + "\nTítulo: " + e.getTitulo()
                    + "\nCategoria: " + e.getCategoria() + "\nLocal: " + e.getLocal() + "\nData de início: "
                    + e.getData_inicio() + "\nData de encerramento:" + e.getData_fim() + "\n";

            JOptionPane.showMessageDialog(null, "Agenda de Eventos: \n" + aux);

        }
    }
}
