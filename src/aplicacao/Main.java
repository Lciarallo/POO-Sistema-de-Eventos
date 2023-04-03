package src.aplicacao;

import src.eventos.Evento;
import src.participantes.Discente;
import src.participantes.Docente;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        // Instanciação dos objetos das classes Evento, Discente e Docente
        Evento evento = new Evento();
        Discente discente = new Discente();
        Docente docente = new Docente();

        // Variáveis de Controle
        int eventoCadastrado = 0;
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
                    3 - Listar evento cadastrado
                    4 - Listar participante cadastrado
                    5 - Sair"""));

            switch (op) {
                case 1:
                    evento.cadastrarEvento();
                    eventoCadastrado++;
                    break;

                case 2: {
                    int opcao = Integer.parseInt(JOptionPane.showInputDialog("""
                            Selecione o tipo de participante:
                            1 - Cadastrar um discente
                            2 - Cadastrar um docente"""));
                    switch (opcao) {
                        case 1:
                            discente.cadastrarDiscente();
                            discenteCadastrado++;
                            break;
                        case 2:
                            docente.cadastrarDocente();
                            docenteCadastrado++;
                            break;
                    }

                    break;
                }

                case 3:
                    if (eventoCadastrado > 0) {
                        evento.mostrarEvento();
                    } else {
                        JOptionPane.showMessageDialog(null, "Não há evento cadastrado!");
                    }

                    break;

                case 4: {
                    int opcao = Integer.parseInt(JOptionPane.showInputDialog("""
                            Selecione o tipo de participante:
                            1 - Listar discente cadastrado
                            2 - Listar docente cadastrado"""));
                    switch (opcao) {
                        case 1:
                            if (discenteCadastrado > 0) {
                                discente.mostrarDiscente();
                            } else {
                                JOptionPane.showMessageDialog(null, "Não há discente cadastrado!");
                            }

                            break;
                        case 2:
                            if (docenteCadastrado > 0) {
                                docente.mostrarDocente();
                            } else {
                                JOptionPane.showMessageDialog(null, "Não há docente cadastrado!");
                            }

                            break;
                    }

                    break;
                }
                case 5:
                    JOptionPane.showMessageDialog(null, "Saindo...\n" +
                            "Pressione 'ENTER' para sair.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
                    break;
            }
        } while (op != 5);
    }
}
