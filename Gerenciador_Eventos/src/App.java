public class App {
    public static void main(String[] args) {
        // Cria uma instância da interface gráfica do evento (view)
        EventoView view = new EventoView();
        
        // Cria uma instância do controlador que conecta a interface com a lógica do programa
        // O controlador gerencia as ações entre a view (interface gráfica) e os dados (modelo)
        // A anotação @SuppressWarnings("unused") é usada para suprimir o aviso de que a variável 'controller' não está sendo usada diretamente
        @SuppressWarnings("unused")
        EventoController controller = new EventoController(view);
    }
}
