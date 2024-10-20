public class EventoModel {
    // Atributo que representa o nome do evento
    private String nome;
    
    // Atributo que representa a data e hora do evento
    private String dataHora;
    
    // Atributo que representa o local do evento
    private String local;

    // Construtor da classe EventoModel, que inicializa os atributos com os valores fornecidos
    public EventoModel(String nome, String dataHora, String local) {
        this.nome = nome;
        this.dataHora = dataHora;
        this.local = local;
    }

    // Getters e Setters

    // Retorna o nome do evento
    public String getNome() {
        return nome;
    }

    // Retorna a data e hora do evento
    public String getDataHora() {
        return dataHora;
    }

    // Retorna o local do evento
    public String getLocal() {
        return local;
    }
}
