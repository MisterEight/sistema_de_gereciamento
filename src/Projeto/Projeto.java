package Projeto;
import java.time.LocalDate;
import java.util.List;

public class Projeto {
    private String projeto_nome;
    private LocalDate prazo;
    private String funcionarioResponsavel;
    private List<String> funcionarios;


    public Projeto(String projeto_nome, LocalDate prazo, String funcionarioResponsavel) {
        this.projeto_nome = projeto_nome;
        this.prazo = prazo;
        this.funcionarioResponsavel = funcionarioResponsavel;
    }

    public void removeFuncionario(String funcionario) {
        if (funcionarios.remove(funcionario)) {
            System.out.println("Funcionário removido: " + funcionario);
        } else {
            System.out.println("Funcionário não encontrado: " + funcionario);
        }
    }

    public void verificaPrazo(String funcionario) {
        System.out.println("Verificando prazo para: " + funcionario);
    }

    public void mudaResponsavel(String funcionario) {
        System.out.println("Mudando responsável para: " + funcionario);
    }

    public void mostrarProjeto() {
        System.out.println("nome do Projeto: " + projeto_nome);
        System.out.println("Prazo: " + prazo);
        System.out.println("Funcionário Responsável: " + funcionarioResponsavel);
    }
}
