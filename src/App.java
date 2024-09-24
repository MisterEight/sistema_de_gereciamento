import Funcionario.*;
import Projeto.*;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Funcionario fun1 = new Funcionario("Leonardo", "Estágiario", 1200.99);
        Projeto pr1 = new Projeto("Quadro de tarefas", LocalDate.of(2024, 12, 31), "Leonardo");
    }
}
