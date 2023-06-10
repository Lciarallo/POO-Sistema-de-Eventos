package src.model.participantes;

import java.util.List;

import javax.swing.*;

import src.model.Participante;

//Impelmentar Herança com Participante

public class Docente extends Participante {

    // Atributos da classe Docente
    private String titulo;
    private float cargaHoraria;
    private String turno;
    private String especializacao;
    private String unidadeCurricular;

    public Docente(String nome, String data_de_nascimento, String cpf, String titulo, float cargaHoraria, String turno,
            String especializacao, String unidadeCurricular) {
        super(nome, data_de_nascimento, cpf);
        this.titulo = titulo;
        this.cargaHoraria = cargaHoraria;
        this.turno = turno;
        this.especializacao = especializacao;
        this.unidadeCurricular = unidadeCurricular;
    }

    // Métodos getter e setter da Classe Docente

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public float getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(float cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    public String getUnidadeCurricular() {
        return unidadeCurricular;
    }

    public void setUnidadeCurricular(String unidadeCurricular) {
        this.unidadeCurricular = unidadeCurricular;
    }

    // Métodos da Classe Docente

    public void listarDocente(List<Docente> docentes) {

        super.listarParticipantes(docentes);

        for (Docente d : docentes) {
            JOptionPane.showMessageDialog(null,
                    "\nDocentes:\n" + "Título: " + d.getTitulo() + "\n" +
                            "Carga Horária: " + d.getCargaHoraria() + "h" + "\n" +
                            "Turno: " + d.getTurno() +
                            "Especialização: " + d.getEspecializacao() + "\n" +
                            "Unidade Curricular: " + d.getUnidadeCurricular() + "\n");
        }
    }
}
