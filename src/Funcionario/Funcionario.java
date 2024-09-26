package Funcionario;

public class Funcionario {
    private String nome;
    private String cargo;
    private Double salario;

    public Funcionario(String nome) {
        this.nome = nome;
    }

    public Funcionario(String nome, String cargo, Double salario) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    public void mostrarFuncionario() {
        System.out.println("Nome: " + nome);
        System.out.println("Cargo: " + cargo);
        System.out.println("Salário: " + salario);
    }

    public void demitirFuncionario() {
        this.nome = null;
        this.cargo = null;
        this.salario = null;
        System.out.println("Funcionário demitido.");
    }

    public void promoverFuncionario(String novoCargo, double aumento) {
        this.cargo = novoCargo;
        this.salario += aumento;
        System.out.println("Funcionário promovido para o cargo de " + novoCargo + " com aumento de salário.");
    }

    public String funcionarioNome() {
        return this.nome;
    }

    public String funcionarioCargo() {
        return this.cargo;
    }

    public void mudaNome(String novoNome) {
        this.nome = novoNome;
        System.out.println("Nome alterado para " + novoNome);
    }

    public void mudaSalario(Double novoSalario) {
        this.salario = novoSalario;
        System.out.println("Salário alterado para " + novoSalario);
    }
}

