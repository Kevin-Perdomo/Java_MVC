import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class EventoView extends JFrame {
    // Campos para inserir os dados do evento
    private JTextField nomeField;
    private JTextField dataHoraField;
    private JTextField localField;
    
    // Área de texto para mostrar a lista de eventos adicionados
    private JTextArea eventosArea;
    
    // Botão para adicionar um novo evento
    private JButton adicionarButton;

    // Construtor que configura a interface gráfica (View)
    public EventoView() {
        // Configurações básicas da janela principal
        setTitle("Gerenciamento de Eventos"); // Define o título da janela
        setSize(400, 300); // Define o tamanho da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha a aplicação ao clicar no botão de fechar
        setLayout(new FlowLayout()); // Define o layout como FlowLayout, onde os componentes são organizados em sequência

        // Inicializa os campos de texto com tamanho de 20 colunas
        nomeField = new JTextField(20);
        dataHoraField = new JTextField(20);
        localField = new JTextField(20);
        
        // Inicializa a área de texto para exibir eventos e define um tamanho padrão (10 linhas, 30 colunas)
        eventosArea = new JTextArea(10, 30);
        // Inicializa o botão de adicionar evento
        adicionarButton = new JButton("Adicionar Evento");

        // Adiciona os componentes à janela (JFrame) com rótulos
        add(new JLabel("Nome:")); // Rótulo para o campo de nome
        add(nomeField); // Campo de nome
        add(new JLabel("Data e Hora (DD/MM/AAAA - HH:MM):")); // Rótulo para o campo de data e hora
        add(dataHoraField); // Campo de data e hora
        add(new JLabel("Local:")); // Rótulo para o campo de local
        add(localField); // Campo de local
        add(adicionarButton); // Botão de adicionar evento
        
        // Adiciona a área de texto (com barra de rolagem) para exibir eventos
        add(new JScrollPane(eventosArea));

        // Torna a janela visível para o usuário
        setVisible(true);
    }

    // Métodos getter para obter o texto inserido nos campos de nome, data/hora e local
    public String getNome() {
        return nomeField.getText();
    }

    public String getDataHora() {
        return dataHoraField.getText();
    }

    public String getLocal() {
        return localField.getText();
    }

    // Método para adicionar um evento à área de texto (exibe o evento na interface)
    public void addEvento(String evento) {
        eventosArea.append(evento + "\n");
    }

    // Método para adicionar um listener (ouvinte) ao botão "Adicionar Evento"
    // Este listener será definido pelo controlador (Controller)
    public void setAdicionarEventoListener(ActionListener listener) {
        adicionarButton.addActionListener(listener);
    }
}
