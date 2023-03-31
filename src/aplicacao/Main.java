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

        JOptionPane.showInternalMessageDialog(null,
                "Bem vindo ao Event System!\nPor favor clique em 'ok' para continuar");
        Object[] pessoa = { "Discente", "Docente", "Sair" };
        Object[] pessoaEvento = { "Discente", "Docente", "Evento", "Sair" };
        Object[] eventoOp = { "Sim", "Não" };
        int op = 0;

        while (op != 4) {
            String option = JOptionPane.showInputDialog(null, """
                    Insira a opção desejada:\s
                    1 - Cadastrar Docente ou discente
                    2 - Cadastrar Evento
                    3 - Listar Eventos ou Pessoas
                    4 - Sair
                    """);
            op = Integer.parseInt(option);

            switch (op) {
                case 1:
                    op = JOptionPane.showOptionDialog(null, "Escolha uma opção a baixo: ", "Cadastro",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, pessoa, pessoa[0]);
                    switch (op) {
                        case 0:
                            JOptionPane.showInternalMessageDialog(null, "Você selecionou Discente");
                            discente.cadastrarDiscente();
                            break;
                        case 1:
                            JOptionPane.showInternalMessageDialog(null, "Você selecionou Docente");
                            docente.cadastrarDocente();
                            break;
                    }

                case 2:
                    evento.cadastrarEvento();
                    break;

                case 3:
                    op = JOptionPane.showOptionDialog(null, "Escolha uma opção a baixo: ", "Listar Dados",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, pessoaEvento,
                            pessoaEvento[0]);
                    switch (op) {
                        case 0:
                            discente.mostrarDiscente();
                            break;

                        case 1:
                            docente.mostrarDocente();
                            break;

                        case 2:
                            op = JOptionPane.showOptionDialog(null, "Deseja Iniciar o Evento? ", "Iniciar Evento",
                                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, eventoOp,
                                    eventoOp[0]);
                            if (op == 0) {
                                evento.iniciarEvento();
                                evento.mostrarEvento();
                            } else
                                evento.encerrarEvento();
                                evento.mostrarEvento();

                            break;
                    }

                case 4:
                    break;

            }

        }
    }
}
