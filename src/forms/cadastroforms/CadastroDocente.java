package src.forms.cadastroforms;
import src.participantes.Docente;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CadastroDocente extends JFrame {
    private JTextField textFieldNome;
    private JTextField textFieldData_de_nascimento;
    private JTextField textFieldCpf;
    private JTextField textFieldTitulo;
    private JTextField textUnidadeCurricular;
    private JTextField textFieldCarga_horaria;
    private JTextField textFieldEspecializacao;
    private JTextField textFieldTurno;

    public CadastroDocente(List<Docente> docentes){
        setTitle("Cadastro de Docente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        panel.setPreferredSize(new Dimension(450, 400));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 5, 5);
        //Nome
        JLabel labelNome = new JLabel("Nome:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(labelNome, constraints);

        textFieldNome = new JTextField(40);
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(textFieldNome, constraints);
        //Data de Nascimento
        JLabel labelDataDeNascimento = new JLabel("Data de Nascimento:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(labelDataDeNascimento, constraints);

        textFieldData_de_nascimento = new JTextField(10);
        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(textFieldData_de_nascimento, constraints);
        //CPF
        JLabel labelCPF = new JLabel("CPF:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(labelCPF, constraints);

        textFieldCpf = new JTextField(20);
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(textFieldCpf, constraints);
        //Titulo
        JLabel labelTitulo = new JLabel("Titulo:");
        constraints.gridx = 1;
        constraints.gridy = 2;
        panel.add(labelTitulo, constraints);

        textFieldTitulo = new JTextField(40);
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(textFieldTitulo, constraints);
        //Turno

        JLabel labelTurno = new JLabel("Turno:");
        constraints.gridx = 1;
        constraints.gridy = 3;
        panel.add(labelTurno, constraints);

        textFieldTurno = new JTextField(40);
        constraints.gridx = 0;
        constraints.gridy = 4;
        panel.add(textFieldTurno, constraints);
        //Unidade Curricular

        JLabel labelUnidadeCurricular = new JLabel("Unidade Curricular:");
        constraints.gridx = 1;
        constraints.gridy = 4;
        panel.add(labelUnidadeCurricular, constraints);

        textUnidadeCurricular = new JTextField(40);
        constraints.gridx = 0;
        constraints.gridy = 5;
        panel.add(textUnidadeCurricular, constraints);
        //Especialização
        JLabel labelEspecializacao = new JLabel("Especialização:");
        constraints.gridx = 1;
        constraints.gridy = 5;
        panel.add(labelEspecializacao, constraints);

        textFieldEspecializacao = new JTextField(40);
        constraints.gridx = 0;
        constraints.gridy = 6;
        panel.add(textFieldEspecializacao, constraints);
        //Carga Horária
        JLabel labelCarga_horaria = new JLabel("Carga Horária:");
        constraints.gridx = 1;
        constraints.gridy = 6;
        panel.add(labelUnidadeCurricular, constraints);

        textFieldCarga_horaria = new JTextField(40);
        constraints.gridx = 0;
        constraints.gridy = 7;
        panel.add(textFieldCarga_horaria, constraints);





    }

    public void CadastroEvento(){
        String nome = textFieldNome.getText();
        String titulo = textFieldTitulo.getText();
        String Data_de_nascimento = textFieldData_de_nascimento.getText();
        String cpf = textFieldCpf.getText();
        String UnidadeCurricular = textUnidadeCurricular.getText();
        String CargaHoraria = textFieldCarga_horaria.getText();
        String Especializacao = textFieldEspecializacao.getText();
        String turno = textFieldTurno.getText();



    }

}
