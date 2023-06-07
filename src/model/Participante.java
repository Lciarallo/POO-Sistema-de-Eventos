package src.model;

import java.util.List;
import javax.swing.JOptionPane;

public class Participante {

    private String nome;
    private String data_de_nascimento;
    private String cpf;

    // Método Construtor
    public Participante(String nome, String data_de_nascimento, String cpf) {
        this.nome = nome;
        this.data_de_nascimento = data_de_nascimento;
        this.cpf = cpf;
    }

    // Métodos Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData_de_nascimento() {
        return data_de_nascimento;
    }

    public void setData_de_nascimento(String data_de_nascimento) {
        this.data_de_nascimento = data_de_nascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // Métodos
    public void listarParticipantes(List<? extends Participante> participantes) {

        for (Participante p : participantes) {
            JOptionPane.showMessageDialog(null,
                    "Participantes:\nNome: " + p.getNome() + "\n"
                            + "Data de nascimento: " + p.getData_de_nascimento() + "\n"
                            + "CPF: " + p.getCpf());
        }
    }

}
