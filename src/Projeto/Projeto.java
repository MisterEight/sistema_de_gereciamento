package Projeto;
import Funcionario.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Projeto {
    private String projeto_nome;
    private LocalDate prazo;
    private Funcionario funcionarioResponsavel;

    public Projeto(String projeto_nome) {
        this.projeto_nome = projeto_nome;
    }

    public Projeto(String projeto_nome, LocalDate prazo, Funcionario funcionarioResponsavel) {
        this.projeto_nome = projeto_nome;
        this.prazo = prazo;
        this.funcionarioResponsavel = funcionarioResponsavel;
    }

    public void verificaPrazo(LocalDate dataVerificacao) {
        if (dataVerificacao.isAfter(prazo)) {
            System.out.println("O prazo do projeto " + projeto_nome + " já passou.");
        } else {
            System.out.println("O prazo do projeto " + projeto_nome + " ainda não passou.");
        }
    }

    public void mudaNome(String novoNome) {
        this.projeto_nome = novoNome;
        System.out.println("Nome do projeto alterado para: " + novoNome);
    }

    public void mudaPrazo(LocalDate novoPrazo) {
        this.prazo = novoPrazo;
        System.out.println("Prazo do projeto alterado para: " + novoPrazo);
    }

    public void mudaResponsavel(Funcionario novoResponsavel) {
        this.funcionarioResponsavel = novoResponsavel;
        System.out.println("Responsável do projeto alterado para: " + novoResponsavel.funcionarioNome());
    }

    public void mostrarProjeto() {
        System.out.println("Nome do Projeto: " + projeto_nome);
        System.out.println("Prazo: " + prazo);
        System.out.println("Funcionário Responsável: " + funcionarioResponsavel.funcionarioNome());
    }
}
