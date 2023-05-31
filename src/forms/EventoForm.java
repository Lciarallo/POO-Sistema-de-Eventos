package src.forms;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import src.eventos.ControleEventos;
import src.eventos.Evento;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

public class EventoForm extends JFrame {

    private static JComboBox<String> comboBox;

    public EventoForm(List<Evento> list) {

        setTitle("Inscrição de Participantes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        comboBox = new JComboBox<>(list.toArray(new String[0]));

        panel.add(comboBox);
        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {

        ControleEventos cEventos = new ControleEventos();

        ArrayList<Evento> eventos = new ArrayList<>();
        eventos.addAll(cEventos.listarEventosNaoOcorridos(eventos));

        new EventoForm(eventos);
    }

    public static JComboBox<String> getComboBox() {
        return comboBox;
    }

}
