import javax.swing.*;

public class MainView extends JFrame {
    private JTabbedPane tabbedPane;

    // Instâncias das views
    private CadastrarPessoaView cadastrarPessoaView;
    private CadastrarEventoView cadastrarEventoView;
    private InscreverPessoaView inscreverPessoaView;
    private ListarInscritosView listarInscritosView;

    public MainView() {
        // Configurações da janela principal
        setTitle("Gerenciamento de Eventos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Criação do JTabbedPane
        tabbedPane = new JTabbedPane();

        // Instanciando as views
        cadastrarPessoaView = new CadastrarPessoaView();
        cadastrarEventoView = new CadastrarEventoView();
        inscreverPessoaView = new InscreverPessoaView();
        listarInscritosView = new ListarInscritosView();

        // Adicionando as abas com as views
        tabbedPane.addTab("Inscrever Pessoa em Evento", inscreverPessoaView);
        tabbedPane.addTab("Cadastrar Pessoa", cadastrarPessoaView);
        tabbedPane.addTab("Cadastrar Evento", cadastrarEventoView);
        tabbedPane.addTab("Listar Inscritos", listarInscritosView);

        // Adiciona o tabbedPane à janela principal
        add(tabbedPane);

        // Inicializa o controlador
        new MainController(this);

        setVisible(true);
    }

    public CadastrarPessoaView getCadastrarPessoaView() {
        return cadastrarPessoaView; // Retorna a instância existente
    }

    public CadastrarEventoView getCadastrarEventoView() {
        return cadastrarEventoView; // Retorna a instância existente
    }

    public InscreverPessoaView getInscreverPessoaView() {
        return inscreverPessoaView; // Retorna a instância existente
    }

    public ListarInscritosView getListarInscritosView() {
        return listarInscritosView; // Retorna a instância existente
    }

    public static void main(String[] args) {
        // Executa a aplicação
        new MainView();
    }
}
