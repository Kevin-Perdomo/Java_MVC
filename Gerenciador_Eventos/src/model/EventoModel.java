public class EventoModel {
    // Atributo que representa o nome do evento
    private String nome;
    
    // Atributo que representa o tipo do evento
    private String tipo;
    
    // Atributo que representa o local do evento
    private String local;

    // Construtor da classe EventoModel, que inicializa os atributos com os valores fornecidos
    public EventoModel(String nome, String tipo, String local) {
        this.nome = nome;
        this.tipo = tipo;
        this.local = local;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public String getLocal() {
        return local;
    }
}
