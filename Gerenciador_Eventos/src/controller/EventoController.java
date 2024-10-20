import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EventoController {
    // Atributo que representa a visão (interface) dos eventos
    private EventoView view;
    
    // Lista para armazenar os eventos
    private List<EventoModel> eventos;
    
    // Nome do arquivo onde os eventos serão salvos
    private String arquivoEventos = "eventos.txt"; 

    // Construtor da classe EventoController, que inicializa a visão e carrega os eventos do arquivo
    public EventoController(EventoView view) {
        this.view = view;
        this.eventos = new ArrayList<>();

        // Carrega os eventos do arquivo ao iniciar
        carregarEventosDoArquivo();
        
        // Define o listener para o botão de adicionar evento
        this.view.setAdicionarEventoListener(new AdicionarEventoListener());
    }

    // Classe interna que implementa ActionListener para adicionar um evento
    private class AdicionarEventoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Obtém os dados do evento a partir da visão
            String nome = view.getNome();
            String dataHora = view.getDataHora();
            String local = view.getLocal();
    
            // Valida o formato da data e hora
            if (validarDataHora(dataHora)) {
                // Cria um novo objeto EventoModel e o adiciona à lista de eventos
                EventoModel evento = new EventoModel(nome, dataHora, local);
                eventos.add(evento);
                
                // Atualiza a visão com os dados do novo evento
                view.addEvento(evento.getNome() + " - " + evento.getDataHora() + " - " + evento.getLocal());
                
                // Salva o evento no arquivo
                salvarEventoNoArquivo(evento);
            } else {
                // Exibe uma mensagem de erro se o formato estiver inválido
                JOptionPane.showMessageDialog(view, "Formato de data e hora inválido. Use o formato DD/MM/AAAA - HH:MM.");
            }
        }
    }

    // Método para validar o formato da data e hora
    private boolean validarDataHora(String dataHora) {
        // Validação para o formato brasileiro DD/MM/AAAA - HH:MM
        return dataHora.matches("\\d{2}/\\d{2}/\\d{4} - \\d{2}:\\d{2}");
    }

    // Método para salvar um evento no arquivo
    private void salvarEventoNoArquivo(EventoModel evento) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoEventos, true))) {
            // Escreve os dados do evento no arquivo, separados por ponto e vírgula
            writer.write(evento.getNome() + ";" + evento.getDataHora() + ";" + evento.getLocal());
            writer.newLine(); // Adiciona uma nova linha após o evento
        } catch (IOException ex) {
            // Trata exceções de I/O
            ex.printStackTrace();
        }
    }

    // Método para carregar eventos do arquivo ao iniciar
    private void carregarEventosDoArquivo() {
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivoEventos))) {
            String linha;
            // Lê cada linha do arquivo até o final
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";"); // Divide a linha em dados
                // Verifica se a linha contém três partes (nome, dataHora, local)
                if (dados.length == 3) {
                    // Cria um novo objeto EventoModel com os dados do arquivo
                    EventoModel evento = new EventoModel(dados[0], dados[1], dados[2]);
                    eventos.add(evento); // Adiciona o evento à lista
                    // Atualiza a visão com os dados do evento
                    view.addEvento(evento.getNome() + " - " + evento.getDataHora() + " - " + evento.getLocal());
                }
            }
        } catch (FileNotFoundException ex) {
            // Arquivo não existe ainda, será criado quando o primeiro evento for salvo
            System.out.println("Nenhum arquivo de eventos encontrado. Ele será criado automaticamente.");
        } catch (IOException ex) {
            // Trata exceções de I/O
            ex.printStackTrace();
        }
    }
}
