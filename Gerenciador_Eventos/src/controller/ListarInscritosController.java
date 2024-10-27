import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ListarInscritosController {
    private ListarInscritosView view;
    private List<Evento_PessoaModel> inscricoes;
    private String arquivoInscricoes = "evento_pessoa.txt";
    private String arquivoPessoas = "pessoas.txt";  // Adiciona a referência ao arquivo de pessoas

    public ListarInscritosController(ListarInscritosView view) {
        this.view = view;
        this.inscricoes = new ArrayList<>();

        // Carrega as inscrições do arquivo no início
        carregarInscricoesDoArquivo();

        // Adiciona ação ao botão de buscar
        this.view.getBuscarButton().addActionListener(new BuscarInscritosListener());
    }

    // ActionListener para o botão de buscar
    private class BuscarInscritosListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            buscarInscritosPorEvento();
        }
    }

    private void buscarInscritosPorEvento() {
        String nomeEvento = view.getNomeEvento().trim();  // Remove espaços em branco extras
        view.limparInscritos(); // Limpa a área de texto antes de mostrar os novos resultados

        boolean eventoEncontrado = false;

        // Percorre as inscrições e busca pelo nome do evento
        for (Evento_PessoaModel inscricao : inscricoes) {
            String nomeEventoInscricao = inscricao.getNome_evento().trim();  // Remove espaços em branco

            if (nomeEventoInscricao.equalsIgnoreCase(nomeEvento)) {
                // Encontra o nome da pessoa usando o CPF
                String nomePessoa = buscarNomePorCPF(inscricao.getCpf_pessoa());

                if (nomePessoa != null) {
                    view.addInscrito(nomePessoa); // Exibe o nome da pessoa inscrita
                } else {
                    view.addInscrito("Pessoa com CPF " + inscricao.getCpf_pessoa() + " não encontrada.");
                }
                eventoEncontrado = true;
            }
        }

        if (!eventoEncontrado) {
            JOptionPane.showMessageDialog(view, "Nenhum inscrito encontrado para o evento: " + nomeEvento, "Evento não encontrado", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para carregar as inscrições a partir do arquivo
    private void carregarInscricoesDoArquivo() {
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivoInscricoes))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length >= 2) {  // Verifica se a linha contém pelo menos o CPF e o nome do evento
                    String cpfPessoa = dados[0].trim();   // Remove espaços em branco do CPF
                    String nomeEvento = dados[1].trim();  // Remove espaços em branco do nome do evento
                    Evento_PessoaModel inscricao = new Evento_PessoaModel(cpfPessoa, nomeEvento);
                    inscricoes.add(inscricao);
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Nenhum arquivo de inscrições encontrado.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Método para buscar o nome da pessoa no arquivo pessoas.txt pelo CPF
    private String buscarNomePorCPF(String cpf) {
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivoPessoas))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dadosPessoa = linha.split(";");  // Supondo que as colunas sejam nomePessoa;cpfPessoa;emailPessoa
                if (dadosPessoa.length >= 2) {  // Verifica se a linha tem ao menos o nome e CPF
                    String cpfPessoa = dadosPessoa[1].trim();  // CPF está na segunda posição
                    if (cpfPessoa.equals(cpf)) {
                        return dadosPessoa[0].trim();  // Retorna o nome da pessoa que está na primeira posição
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo de pessoas não encontrado.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return null;  // Retorna null se o CPF não for encontrado
    }
}
