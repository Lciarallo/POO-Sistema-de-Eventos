package src.model.participantes;

import java.util.List;

import javax.swing.JOptionPane;

import src.model.Participante;

public class Organizador extends Participante {

    private String area_de_atuacao;
    private String departamento;

    // Método Construtor
    public Organizador(String nome, String data_de_nascimento, String cpf, String area_de_atuacao,
            String departamento) {
        super(nome, data_de_nascimento, cpf);
        this.area_de_atuacao = area_de_atuacao;
        this.departamento = departamento;
    }

    // Métodos Getters e Setters

    public String getArea_de_atuacao() {
        return area_de_atuacao;
    }

    public void setArea_de_atuacao(String area_de_atuacao) {
        this.area_de_atuacao = area_de_atuacao;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void listarOrganizadores(List<Organizador> organizadores) {
        super.listarParticipantes(organizadores);

        for (Organizador o : organizadores) {
            JOptionPane.showMessageDialog(null,
                    "Organizadores:\nÁrea de Atuação: " + o.getArea_de_atuacao() + "\n"
                            + "Departamento: " + o.getDepartamento());
        }
    }

}
