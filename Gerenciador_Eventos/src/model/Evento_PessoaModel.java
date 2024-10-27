public class Evento_PessoaModel {
    private String cpf_pessoa;
    private String nome_evento;

    // Construtor da classe EventoModel, que inicializa os atributos com os valores fornecidos
    public Evento_PessoaModel(String cpf_pessoa, String nome_evento) {
        this.cpf_pessoa = cpf_pessoa;
        this.nome_evento = nome_evento;
    }

    // Getters e Setters
    public String getCpf_pessoa() {
        return cpf_pessoa;
    }

    public String getNome_evento() {
        return nome_evento;
    }

}
