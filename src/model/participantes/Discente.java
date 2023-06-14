package src.model.participantes;

import java.util.List;

import javax.swing.*;

import src.model.Participante;

public class Discente extends Participante {

    // Atributos
    private long numero_de_matricula;
    private String curso;

    // Método Construtor
    public Discente(String nome, String data_de_nascimento, String cpf, long numero_de_matricula, String curso) {
        super(nome, data_de_nascimento, cpf);
        this.numero_de_matricula = numero_de_matricula;
        this.curso = curso;
    }

    // Métodos Getters e Setters
    public long getNumero_de_matricula() {
        return numero_de_matricula;
    }

    public void setNumero_de_matricula(long numero_de_matricula) {
        this.numero_de_matricula = numero_de_matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    // Métodos da Classe Discente
    public void listarDiscente(List<Discente> discentes) {

        super.listarParticipantes(discentes);

        for (Discente d : discentes) {
            JOptionPane.showMessageDialog(null,
                    "\nDiscentes:\n" + "Número de Matrícula: " + d.getNumero_de_matricula() + "\n" +
                            "Curso: " + d.getCurso() + "\n");
        }
    }

}