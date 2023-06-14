package src.view.aplicacao;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import src.controller.ControleEventos;
import src.model.Evento;
import src.view.BuscarEvento;
import src.view.cadastroforms.CadastroOrganizador;
import src.view.cadastroforms.CadastroParticipante;
import src.view.InscricaoEvento;
import src.view.RegistroPresenca;
import src.view.RelatorioEventos;
import src.view.cadastroforms.CadastroEvento;

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
    Evento evento = new Evento();

    // ----------- Listas ---------------
    List<Evento> eventosNaoOcorridos = new ArrayList<>();
    List<Evento> eventosOcorridos = new ArrayList<>();
    ArrayList<JButton> botoes = new ArrayList<>();

    // ---------- Variáveis de Controle -----------------------
    int organizadorCadastrado = 0;
    int eventoCadastrado = 0;
    int participanteCadastrado = 0;

    // ---------------------------------------------------------

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

        JButton btnCadastrarOrganizador = new JButton("Cadastrar Organizador");
        JButton btnCadastrarEvento = new JButton("Cadastrar Evento");
        JButton btnCadastrarParticipante = new JButton("Cadastrar Participante");
        JButton btnInscreverParticipante = new JButton("Inscrever Participante no Evento");
        JButton btnRegistrarPresenca = new JButton("Registrar Presença do participante");
        JButton btnBuscarEvento = new JButton("Buscar por Evento");
        JButton btnAgendaEventos = new JButton("Agenda de Eventos");
        JButton btnRelatorio = new JButton("Relatório");

        botoes.addAll(Arrays.asList(btnCadastrarOrganizador, btnCadastrarEvento, btnCadastrarParticipante,
                btnInscreverParticipante,
                btnRegistrarPresenca, btnBuscarEvento, btnAgendaEventos, btnRelatorio));

        for (JButton botao : botoes) {
            botao.setSelected(true);
            botao.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            buttonPanel.add(botao);
        }

        // ------------ Cadastrar Organizador ------------------------
        btnCadastrarOrganizador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                CadastroOrganizador cadastroOrganizador = new CadastroOrganizador(evento.getOrganizadores());
                cadastroOrganizador.setVisible(true);
                organizadorCadastrado++;
            }
        });

        // ----------- Cadastrar Evento -------------------------
        btnCadastrarEvento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (organizadorCadastrado > 0) {
                    CadastroEvento formulario = new CadastroEvento(cEventos.getEventos(), evento.getOrganizadores());
                    formulario.setVisible(true);
                    eventoCadastrado++;

                } else {
                    JOptionPane.showMessageDialog(null, "Não há organizadores cadastrados!");
                }

            }

        });

        // ----------- Cadastrar Participante -------------------------
        btnCadastrarParticipante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (eventoCadastrado > 0) {
                    CadastroParticipante cadastroParticipante = new CadastroParticipante(evento.getParticipantes());
                    cadastroParticipante.setVisible(true);
                    participanteCadastrado++;
                } else {
                    JOptionPane.showMessageDialog(null, "Não há eventos cadastrados!");
                }

            }
        });

        // ----------- Inscrever Participante -------------------------
        btnInscreverParticipante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (participanteCadastrado <= 0) {
                    JOptionPane.showMessageDialog(null, "Não há participantes disponíveis para inscrição!");
                } else {

                    eventosNaoOcorridos = cEventos.listarEventosNaoOcorridos(cEventos.getEventos());

                    if (eventosNaoOcorridos.size() <= 0) {
                        JOptionPane.showMessageDialog(null, "Não há eventos disponíveis para inscrição!");
                    }

                    else {

                        InscricaoEvento inscricaoEventoForm = new InscricaoEvento(eventosNaoOcorridos,
                                evento.getParticipantes());
                        inscricaoEventoForm.setVisible(true);

                    }
                }
            }

        });
        // ----------- Registrar Presença do Participante -------------------------
        btnRegistrarPresenca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (participanteCadastrado <= 0) {
                    JOptionPane.showMessageDialog(null, "Não há participantes disponíveis para inscrição de presença!");
                } else {
                    eventosNaoOcorridos = cEventos.listarEventosNaoOcorridos(cEventos.getEventos());

                    if (eventosNaoOcorridos.size() <= 0) {
                        JOptionPane.showMessageDialog(null, "Não há eventos disponíveis para inscrição!");
                    }

                    else {

                        RegistroPresenca registroPresencaForm = new RegistroPresenca(eventosNaoOcorridos, evento);
                        registroPresencaForm.setVisible(true);

                    }
                }
            }

        });
        // ----------- Buscar Evento -------------------------
        btnBuscarEvento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (eventoCadastrado > 0) {
                    BuscarEvento buscarEvento = new BuscarEvento(eventosNaoOcorridos);

                    buscarEvento.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Não há eventos disponíveis para busca!");
                }

            }
        });

        // ------Agenda de Eventos ---------------

        btnAgendaEventos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                eventosNaoOcorridos = cEventos.listarEventosNaoOcorridos(cEventos.getEventos());
            }
        });

        // ----------- Relatório -------------------------
        btnRelatorio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                eventosNaoOcorridos = cEventos.listarEventosNaoOcorridos(cEventos.getEventos());

                if (eventoCadastrado > 0 || evento.getParticipantesPresentes().size() > 0) {
                    RelatorioEventos relatorioEventos = new RelatorioEventos(eventosNaoOcorridos);

                    relatorioEventos.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Não há eventos disponíveis para relatório!");
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
