package src.aplicacao;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import src.eventos.ControleEventos;
import src.eventos.Evento;
import src.forms.cadastroforms.CadastroDocente;
import src.forms.cadastroforms.CadastroEvento;
import src.participantes.Docente;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menu extends JFrame {

    // -------------- Instância dos Objetos ----------------------
    ControleEventos cEventos = new ControleEventos();
    // EventoForm eventoForm = new EventoForm(cEventos.getEventos());



    // ----------- Listas ---------------
    List<Docente> docentes;
    List<Evento> eventosNaoOcorridos = new ArrayList<>();
    ArrayList<JButton> botoes = new ArrayList<>();

    public Menu() {

        setTitle("Sistema de Controle de Eventos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);

        ImageIcon imageIcon = new ImageIcon("src/img/logo.png");

        JPanel panel = new JPanel(new FlowLayout(10, 10, 10));
        panel.setBorder(new EmptyBorder(10, 40, 10, 40));

        JPanel buttonPanel = new JPanel(new GridLayout(0, 2, 12, 12));
        buttonPanel.setBorder(new EmptyBorder(20, 20, 10, 40));

        JLabel op = new JLabel("Escolha uma opção:");
        JLabel label = new JLabel(imageIcon);
        label.checkImage(getIconImage(), 600, 200, label);
        label.setBorder(new EmptyBorder(10, 20, 10, 20));

        panel.add(label);
        panel.add(op);
        panel.add(buttonPanel);

        JButton btnCadastrarEvento = new JButton("Cadastrar Evento");
        JButton btnCadastrarParticipante = new JButton("Cadastrar Participante");
        JButton btnInscreverParticipante = new JButton("Inscrever Participante no Evento");
        JButton btnRegistrarPresenca = new JButton("Registrar Presença do participante");
        JButton btnBuscarEvento = new JButton("Buscar por Evento");
        JButton btnAgendaEventos = new JButton("Agenda de Eventos");
        JButton btnRelatorio = new JButton("Relatório");
        JButton btnSair = new JButton("Sair");

        botoes.addAll(Arrays.asList(btnCadastrarEvento, btnCadastrarParticipante, btnInscreverParticipante,
                btnRegistrarPresenca, btnBuscarEvento, btnAgendaEventos, btnRelatorio, btnSair));

        for (JButton botao : botoes) {
            botao.setSelected(true);
            botao.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            buttonPanel.add(botao);
        }
        // ----------- Cadastrar Evento -------------------------
        btnCadastrarEvento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                CadastroEvento formulario = new CadastroEvento(cEventos.getEventos());
                formulario.setVisible(true);
            }

        });
        setVisible(true);

        // ----------- Cadastrar Participante -------------------------
        btnCadastrarParticipante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastroDocente cadastroDocente = new CadastroDocente(docentes);
                cadastroDocente.setVisible(true);

            }
        });

        // ----------- Inscrever Participante -------------------------
        btnInscreverParticipante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                eventosNaoOcorridos = cEventos.listarEventosNaoOcorridos(cEventos.getEventos());
                System.out.println(cEventos.getEventos().size());

                if (eventosNaoOcorridos.size() <= 0) {
                    JOptionPane.showMessageDialog(null, "Não há eventos disponíveis para inscrição!");
                }

                else {

                    String indexEvento = JOptionPane.showInputDialog(null, "Qual evento deseja-se inscrever?");
                    int indiceEvento = Integer.parseInt(indexEvento);

                    if (indiceEvento < 0 || indiceEvento >= cEventos.getEventos().size()) {
                        JOptionPane.showMessageDialog(null, "Índice de evento inválido.");
                    } else {
                        /*
                         * listar participantes cadastrados
                         * 
                         * // JComboBox<String> comboBox = EventoForm.getComboBox();
                         * // comboBox.getSelectedIndex();
                         * 
                         * String indexPart = JOptionPane.showInputDialog(null,
                         * "Qual participante deseja-se inscrever?")
                         * int indiceParticipante = Integer.parseInt(indexPart);
                         * 
                         * if (indiceParticipante < 0 || indiceParticipante >= participantes.size()) {
                         * JOptionPane.showMessageDialog(null, "Índice de participante inválido.");
                         * }
                         * else {
                         * eventos.get(indiceEvento);
                         * participantes.get(indiceParticipante);
                         * evento.inscreverParticipante(indiceEvento, indiceParticipante);
                         * JOptionPane.showMessageDialog(null, "Inscrição realizada com sucesso!");
                         * }
                         */
                    }

                }
            }
        });

        getContentPane().add(panel, BorderLayout.CENTER);
        setLocationRelativeTo(null);

        setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Menu();
            }
        });
    }

}
