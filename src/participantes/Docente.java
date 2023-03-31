package src.participantes;

import javax.swing.*;

// Classe de Responsabilidade do Luiz
public class Docente {

    // Atributos da classe Docente
    private String nome;
    private String dataNascimento;
    private String cpf;
    private String titulo;
    private float cargaHoraria;
    private String turno;
    private String especializacao;
    private String unidadeCurricular;

    //Métodos getter e setter da Classe Docente
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

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
    public void cadastrarDocente(){
        setNome(JOptionPane.showInputDialog("Digite o nome do docente:"));
        setDataNascimento(JOptionPane.showInputDialog("Digite a data de nascimento do docente:"));
        setTitulo(JOptionPane.showInputDialog("Digite o título do docente:"));
        setCpf(JOptionPane.showInputDialog("Digite o número de CPF do docente:"));
        setCargaHoraria(Float.parseFloat(JOptionPane.showInputDialog("Digite a carga horária do docente:")));
        setEspecializacao(JOptionPane.showInputDialog("Digite a especializacao do docente:"));
        setTurno(JOptionPane.showInputDialog("Digite o turno do docente:"));
        setUnidadeCurricular(JOptionPane.showInputDialog(null,"Digite a unidade curricular do docente:"));
        JOptionPane.showMessageDialog(null, "Docente cadastrado com sucesso!");
    }
    public void mostrarDocente(){
        JOptionPane.showMessageDialog(null,
                "\nDados do Docente:\n" +
                        "Nome: "+ getNome() +"\n" +
                        "Data de nascimento: " + getDataNascimento() + "\n" +
                        "CPF: "+ getCpf() +"\n" +
                        "Título: " + getTitulo() +"\n"+
                        "Carga Horária: "+ getCargaHoraria() + "h" + "\n" +
                        "Turno: "+ getTurno() +
                        "Especialização: "+ getEspecializacao() +"\n" +
                        "Unidade Curricular: " + getUnidadeCurricular() + "\n");
    }
}
