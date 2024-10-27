import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CadastrarPessoaController {
    private CadastrarPessoaView view;
    private List<PessoaModel> pessoas;
    private String arquivoPessoas = "pessoas.txt";

    public CadastrarPessoaController(CadastrarPessoaView view) {
        this.view = view;
        this.pessoas = new ArrayList<>();
        carregarPessoasDoArquivo();
        this.view.setSalvarPessoaListener(new SalvarPessoaListener());
    }

    private class SalvarPessoaListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nome = view.getNome();
            String cpf = view.getCpf();
            String email = view.getEmail();
    
            PessoaModel pessoa = new PessoaModel(nome, cpf, email);
            pessoas.add(pessoa);
            salvarPessoaNoArquivo(pessoa);
    
            JOptionPane.showMessageDialog(view, "Pessoa salva com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void salvarPessoaNoArquivo(PessoaModel pessoa) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoPessoas, true))) {
            writer.write(pessoa.getNome() + ";" + pessoa.getCpf() + ";" + pessoa.getEmail());
            writer.newLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void carregarPessoasDoArquivo() {
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivoPessoas))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length == 3) {
                    PessoaModel pessoa = new PessoaModel(dados[0], dados[1], dados[2]);
                    pessoas.add(pessoa);
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Nenhum arquivo de pessoas encontrado.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
