import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class InscreverPessoaController {
    private InscreverPessoaView view;
    private List<Evento_PessoaModel> inscricoes;
    private String arquivoInscricoes = "evento_pessoa.txt";
    private String arquivoPessoas = "pessoas.txt";
    private String arquivoEventos = "eventos.txt";
    private HashSet<String> cpfs;
    private HashSet<String> eventos; 

    public InscreverPessoaController(InscreverPessoaView view) {
        this.view = view;
        this.inscricoes = new ArrayList<>();
        this.cpfs = new HashSet<>();
        this.eventos = new HashSet<>();

        carregarInscricoesDoArquivo();
        carregarCPFsDoArquivo();
        carregarEventosDoArquivo(); 
        this.view.setInscreverPessoaListener(new InscreverPessoaListener());
    }

    private void carregarCPFsDoArquivo() {
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivoPessoas))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length >= 2) { // Verifique se tem ao menos um CPF
                    cpfs.add(dados[1]);  // Supondo que o CPF está na segunda posição
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Nenhum arquivo de pessoas encontrado.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void carregarEventosDoArquivo() {
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivoEventos))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length >= 1) {  // Verifica se há pelo menos um campo
                    eventos.add(dados[0].trim());  // Adiciona o nome do evento, removendo espaços em branco
                }
            }
            System.out.println("Eventos carregados: " + eventos);  // Debug para ver os eventos carregados
        } catch (FileNotFoundException ex) {
            System.out.println("Nenhum arquivo de eventos encontrado.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    

    private class InscreverPessoaListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String cpfPessoa = view.getNomePessoa();
            String nomeEvento = view.getNomeEvento();
            System.out.println("CPF digitado: " + cpfPessoa);
            System.out.println("Evento digitado: " + nomeEvento);
            System.out.println("Eventos disponíveis: " + eventos);
            // Verifica se o CPF e o nome do evento existem
            if (!cpfs.contains(cpfPessoa)) {
                JOptionPane.showMessageDialog(view, "CPF " + cpfPessoa + " não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!eventos.contains(view.getNomeEvento())) {
                JOptionPane.showMessageDialog(view, "Evento " + nomeEvento + " não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
    
            // Se ambos existem, prossegue com a inscrição
            Evento_PessoaModel inscricao = new Evento_PessoaModel(cpfPessoa, nomeEvento);
            inscricoes.add(inscricao);
            salvarInscricaoNoArquivo(inscricao);
    
            JOptionPane.showMessageDialog(view, "Pessoa " + cpfPessoa + " inscrita no evento " + nomeEvento + "!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void salvarInscricaoNoArquivo(Evento_PessoaModel inscricao) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoInscricoes, true))) {
            writer.write(inscricao.getCpf_pessoa() + ";" + inscricao.getNome_evento());
            writer.newLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void carregarInscricoesDoArquivo() {
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivoInscricoes))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length == 3) {
                    Evento_PessoaModel inscricao = new Evento_PessoaModel(dados[0], dados[1]);
                    inscricoes.add(inscricao);
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Nenhum arquivo de inscrição encontrado.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
