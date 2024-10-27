import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CadastrarPessoaView extends JPanel {
    private JTextField nomeField;
    private JTextField cpfField;
    private JTextField emailField;
    private JButton salvarButton;

    public CadastrarPessoaView() {
        // Define o layout
        setLayout(new GridBagLayout());
        setBackground(Color.YELLOW); // Cor de fundo alterada para amarelo

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Margem maior para o espaçamento
        gbc.anchor = GridBagConstraints.CENTER; // Centraliza o conteúdo

        // Cria os componentes
        nomeField = new JTextField(25);
        cpfField = new JTextField(25);
        emailField = new JTextField(25);
        salvarButton = new JButton("Salvar");

        // Estiliza o botão
        salvarButton.setPreferredSize(new Dimension(80, 30)); // Dimensões do botão
        salvarButton.setBackground(Color.WHITE);
        salvarButton.setForeground(Color.BLUE);
        salvarButton.setFont(new Font("Arial", Font.BOLD, 12));

        // Adiciona os componentes ao painel
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Nome"), gbc);

        gbc.gridx = 1;
        add(nomeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("CPF"), gbc);

        gbc.gridx = 1;
        add(cpfField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Email"), gbc);

        gbc.gridx = 1;
        add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2; // O botão ocupa duas colunas
        gbc.anchor = GridBagConstraints.CENTER; // Centraliza o botão
        add(salvarButton, gbc);
    }

    // Métodos para obter os valores inseridos
    public String getNome() {
        return nomeField.getText();
    }

    public String getCpf() {
        return cpfField.getText();
    }

    public String getEmail() {
        return emailField.getText();
    }

    public void setSalvarPessoaListener(ActionListener listener) {

        // Remove todos os listeners antes de adicionar o novo
        for (ActionListener al : salvarButton.getActionListeners()) {

            salvarButton.removeActionListener(al);
        
        }
        // Adiciona o listener ao botão
        salvarButton.addActionListener(listener);
    }
}
