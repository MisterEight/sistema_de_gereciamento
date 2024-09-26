import Funcionario.*;
import Projeto.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Funcionario> funcionarios = new ArrayList<>();
        List<Projeto> projetos = new ArrayList<>();
        
        
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Mostrar Funcionários");
            System.out.println("2. Adicionar Funcionário");
            System.out.println("3. Criar Projeto");
            System.out.println("4. Mostrar Projetos");
            System.out.println("5. Alterar Prazo do Projeto");
            System.out.println("6. Verificar Prazo do Projeto");
            System.out.println("7. Mudar Responsável do Projeto");
            System.out.println("8. Promover Funcionário");
            System.out.println("9. Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcao) {
                case 1:
                    if (funcionarios.isEmpty()) {
                        System.out.println("Não há funcionários para mostrar!");
                        break;
                    }

                    for (Funcionario funcionario : funcionarios) {
                        funcionario.mostrarFuncionario();
                    }
                    break;
                case 2:
                    System.out.print("Digite o nome do funcionário: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o cargo do funcionário: ");
                    String cargo = scanner.nextLine();
                    System.out.print("Digite o salário do funcionário: ");
                    double salario = scanner.nextDouble();
                    funcionarios.add(new Funcionario(nome, cargo, salario));
                    System.out.println("Funcionário adicionado com sucesso!");
                    break;
                case 3:
                
                    System.out.print("Digite o nome do projeto: ");
                    String nomeProjeto = scanner.nextLine();
                    System.out.print("Digite o prazo do projeto (YYYY-MM-DD): ");
                    String dataPrazo = scanner.nextLine();
                    LocalDate prazoProjeto = LocalDate.parse(dataPrazo);
                    System.out.print("Digite o nome do funcionário responsável: ");
                    String responsavel = scanner.nextLine();
                    Boolean funcionarioEncontrado = false;
                    for (Funcionario funcionario : funcionarios) {
                        if (funcionario.funcionarioNome().equalsIgnoreCase(responsavel)) {
                            if (funcionario.funcionarioCargo().equalsIgnoreCase("Gerente")) {
                                Projeto novoProjeto = new Projeto(nomeProjeto, prazoProjeto, funcionario);
                                projetos.add(novoProjeto);
                                System.out.println("Projeto criado com sucesso!");
                                funcionarioEncontrado = true;
                                break;
                            } else {
                                System.out.println("O responsável deve ser um gerente.");
                                funcionarioEncontrado = true;
                                break;
                            }
                        }
                    }
                    if (funcionarioEncontrado == false) {
                        System.out.println("O funcionário não existe!");
                    }

                    break;
                case 4:
                    if (projetos.isEmpty()) {
                        System.out.println("Não há projetos para mostrar!");
                        break;
                    }

                    System.out.println("Projetos:");
                    for (int i = 0; i < projetos.size(); i++) {
                        System.out.println("Projeto " + i + ": ");
                        projetos.get(i).mostrarProjeto();
                    }
                    break;
                case 5:
                    System.out.print("Digite o índice do projeto que deseja alterar (0 a " + (projetos.size() - 1) + "): ");
                    int indiceProjeto = scanner.nextInt();
                    scanner.nextLine();
                    if (indiceProjeto >= 0 && indiceProjeto < projetos.size()) {
                        System.out.print("Digite o novo prazo (YYYY-MM-DD): ");
                        String novoData = scanner.nextLine();
                        LocalDate novoPrazo = LocalDate.parse(novoData);
                        projetos.get(indiceProjeto).mudaPrazo(novoPrazo);
                    } else {
                        System.out.println("Índice inválido!");
                    }
                    break;
                case 6:
                    System.out.print("Digite o índice do projeto para verificar o prazo (projetos de 0 a " + (projetos.size() - 1) + "): ");
                    int indiceVerificacao = scanner.nextInt();
                    scanner.nextLine();
                    if (indiceVerificacao >= 0 && indiceVerificacao < projetos.size()) {
                        System.out.print("Digite a data de verificação (YYYY-MM-DD): ");
                        String dataVerificacao = scanner.nextLine();
                        LocalDate dataVerif = LocalDate.parse(dataVerificacao);
                        projetos.get(indiceVerificacao).verificaPrazo(dataVerif);
                    } else {
                        System.out.println("Índice inválido!");
                    }
                    break;
                case 7:
                    System.out.print("Digite o índice do projeto para mudar o responsável (projetos de 0 a " + (projetos.size() - 1) + "): ");
                    int indiceResponsavel = scanner.nextInt();
                    scanner.nextLine();
                    if (indiceResponsavel >= 0 && indiceResponsavel < projetos.size()) {
                        System.out.print("Digite o novo responsável do projeto: ");
                        String novoResponsavel = scanner.nextLine();
                        boolean funcionarioAtualEncontrado = false;
                        for (Funcionario funcionario : funcionarios) {
                            if (funcionario.funcionarioNome().equalsIgnoreCase(novoResponsavel)) {
                                if (funcionario.funcionarioCargo().equalsIgnoreCase("Gerente")) {
                                    projetos.get(indiceResponsavel).mudaResponsavel(funcionario);
                                    System.out.println("Responsável do projeto alterado com sucesso!");
                                    funcionarioAtualEncontrado = true;
                                    break;
                                } else {
                                    System.out.println("O responsável deve ser um gerente.");
                                    funcionarioAtualEncontrado = true;
                                    break;
                                }
                            }
                        }

                        if (funcionarioAtualEncontrado == false) {
                            System.out.println("Funcionário não existe!");
                            break;
                        }
                    } else {
                        System.out.println("Índice inválido!");
                    }
                    break;                
                case 8:
                    System.out.print("Digite o nome do funcionário: ");
                    String nome_funcionario = scanner.nextLine();

                    System.out.print("Digite o novo cargo: ");
                    String novo_cargo = scanner.nextLine();

                    System.out.print("Digite o aumento para o salário: ");
                    Double aumento = scanner.nextDouble();
                    Boolean funcionarioPromovido = false;
                    for (Funcionario funcionario : funcionarios) {
                        if (funcionario.funcionarioNome().equalsIgnoreCase(nome_funcionario)) {
                            funcionario.promoverFuncionario(novo_cargo, aumento);
                            funcionarioPromovido = true;
                        }
                    }
                    if (funcionarioPromovido == false) {
                        System.err.println("Funcionário não encontrado!");
                    }
                    break;
                case 9:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}
