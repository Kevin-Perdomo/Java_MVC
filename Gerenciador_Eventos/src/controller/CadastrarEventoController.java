import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CadastrarEventoController {
    private CadastrarEventoView view;
    private List<EventoModel> eventos;
    private String arquivoEventos = "eventos.txt";

    public CadastrarEventoController(CadastrarEventoView view) {
        this.view = view;
        this.eventos = new ArrayList<>();

        carregarEventosDoArquivo();
        this.view.setSalvarEventoListener(new SalvarEventoListener());
    }

    private class SalvarEventoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nome = view.getNome();
            String tipo = view.getTipo();
            String local = view.getLocal();

            EventoModel evento = new EventoModel(nome, tipo, local);
            eventos.add(evento);
            salvarEventoNoArquivo(evento);

            JOptionPane.showMessageDialog(view, "Evento salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void salvarEventoNoArquivo(EventoModel evento) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoEventos, true))) {
            writer.write(evento.getNome() + ";" + evento.getTipo() + ";" + evento.getLocal());
            writer.newLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void carregarEventosDoArquivo() {
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivoEventos))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length == 3) {
                    EventoModel evento = new EventoModel(dados[0], dados[1], dados[2]);
                    eventos.add(evento);
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Nenhum arquivo de eventos encontrado.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
