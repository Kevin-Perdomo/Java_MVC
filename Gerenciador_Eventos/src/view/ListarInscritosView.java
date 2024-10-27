import javax.swing.*;
import java.awt.*;

public class ListarInscritosView extends JPanel {
    private JTextArea inscritosArea;
    private JTextField nomeEventoField;
    private JButton buscarButton;

    public ListarInscritosView() {
        // Define o layout
        setLayout(new BorderLayout());
        setBackground(new Color(230, 190, 255)); // Cor de fundo alterada para roxo claro

        // Painel superior para buscar evento
        JPanel buscaPanel = new JPanel();
        buscaPanel.setLayout(new FlowLayout());
        buscaPanel.setBackground(new Color(230, 190, 255));

        // Adiciona o label e o campo de texto
        JLabel nomeEventoLabel = new JLabel("Nome do Evento:");
        nomeEventoField = new JTextField(15); // Campo para entrada do nome do evento
        buscarButton = new JButton("Buscar"); // Botão para realizar a busca

        // Adiciona componentes ao painel de busca
        buscaPanel.add(nomeEventoLabel);
        buscaPanel.add(nomeEventoField);
        buscaPanel.add(buscarButton);

        // Adiciona o painel de busca na parte superior
        add(buscaPanel, BorderLayout.NORTH);

        // Cria o JTextArea para exibir os inscritos
        inscritosArea = new JTextArea(10, 30);
        inscritosArea.setEditable(false);
        inscritosArea.setLineWrap(true); // Permite quebra de linha
        inscritosArea.setWrapStyleWord(true); // Quebra de linha por palavra

        // Adiciona o JTextArea ao painel, dentro de um JScrollPane
        JScrollPane scrollPane = new JScrollPane(inscritosArea);
        add(scrollPane, BorderLayout.CENTER);

        // Adiciona uma borda para melhorar a aparência
        scrollPane.setBorder(BorderFactory.createTitledBorder("Inscritos"));
    }

    // Método para adicionar um inscrito à área de texto
    public void addInscrito(String inscrito) {
        inscritosArea.append(inscrito + "\n");
    }

    // Método para limpar a lista de inscritos
    public void limparInscritos() {
        inscritosArea.setText("");
    }

    // Getter para obter o nome do evento inserido
    public String getNomeEvento() {
        return nomeEventoField.getText().trim();
    }

    // Getter para obter o botão de busca
    public JButton getBuscarButton() {
        return buscarButton;
    }
}
