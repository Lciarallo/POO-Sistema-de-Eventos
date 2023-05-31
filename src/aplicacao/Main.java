package src.aplicacao;

import src.participantes.Discente;
import src.participantes.Docente;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        // Instanciação dos objetos das classes Discente e Docente
        Discente discente = new Discente();
        Docente docente = new Docente();

        // Variáveis de Controle
        int discenteCadastrado = 0;
        int docenteCadastrado = 0;

        // Menu
        JOptionPane.showMessageDialog(null, "Sistema de Eventos!\n" +
                "Pressione 'ENTER' para continuar..");

        int op;

        do {
            op = Integer.parseInt(JOptionPane.showInputDialog("""
                    Selecione uma opção:
                    1 - Cadastrar Evento
                    2 - Cadastrar Participante
                    3 - Inscrever Participante no Evento
                    4 - Registrar Presença do participante
                    5 - Buscar por Evento
                    6 - Agenda de Eventos
                    7 - Relatório
                    8 - Sair"""));

            switch (op) {
                case 1 -> {

                }
                case 2 -> {
                    int opcao = Integer.parseInt(JOptionPane.showInputDialog("""
                            Selecione o tipo de participante:
                            1 - Cadastrar um discente
                            2 - Cadastrar um docente"""));
                    switch (opcao) {
                        case 1 -> {
                            discente.cadastrarDiscente();
                            discenteCadastrado++;
                        }
                        case 2 -> {
                            docente.cadastrarDocente();
                            docenteCadastrado++;
                        }
                    }

                }
                case 3 -> {

                }

                case 4 -> {
                    int opcao = Integer.parseInt(JOptionPane.showInputDialog("""
                            Selecione o tipo de participante:
                            1 - Listar discente cadastrado
                            2 - Listar docente cadastrado"""));
                    switch (opcao) {
                        case 1 -> {
                            if (discenteCadastrado > 0) {
                                discente.mostrarDiscente();
                            } else {
                                JOptionPane.showMessageDialog(null, "Não há discente cadastrado!");
                            }
                        }
                        case 2 -> {
                            if (docenteCadastrado > 0) {
                                docente.mostrarDocente();
                            } else {
                                JOptionPane.showMessageDialog(null, "Não há docente cadastrado!");
                            }
                        }
                    }
                }
                case 8 -> JOptionPane.showMessageDialog(null, "Saindo...\n" +
                        "Pressione 'ENTER' para sair.");
                default -> JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        } while (op != 5);
    }
}
