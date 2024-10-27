public class PessoaModel {
    // Atributo que representa o nome do evento
    private String nome;
    
    // Atributo que representa o tipo do evento
    private String cpf;
    
    // Atributo que representa o local do evento
    private String email;

    // Construtor da classe PessoaModel, que inicializa os atributos com os valores fornecidos
    public PessoaModel(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }
}
