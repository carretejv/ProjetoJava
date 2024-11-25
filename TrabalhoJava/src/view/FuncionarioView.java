package view;

import controller.FuncionarioController;
import model.*;

import java.util.Scanner;

public class FuncionarioView {
    public static void main(String[] args) {
        FuncionarioController controller = new FuncionarioController();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Adicionar Funcionário");
            System.out.println("2. Listar Funcionários");
            System.out.println("3. Atualizar Funcionário");
            System.out.println("4. Remover Funcionário");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            if (opcao == 5) break;

            switch (opcao) {
                case 1:
                    System.out.println("1. Desenvolvedor  2. Gerente  3. Treinador  4. Gerente Desenvolvedor");
                    int tipo = scanner.nextInt();
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Salário: ");
                    double salario = scanner.nextDouble();

                    Funcionario funcionario;
                    switch (tipo) {
                        case 1 -> funcionario = new Desenvolvedor(id, nome, salario);
                        case 2 -> funcionario = new Gerente(id, nome, salario);
                        case 3 -> funcionario = new Treinador(id, nome, salario);
                        case 4 -> funcionario = new GerenteDesenvolvedor(id, nome, salario);
                        default -> {
                            System.out.println("Tipo inválido!");
                            continue;
                        }
                    }
                    controller.adicionarFuncionario(funcionario);
                    break;
                case 2:
                    controller.listarFuncionarios();
                    break;
                case 3:
                    System.out.print("ID do Funcionário: ");
                    int atualizarId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Novo Nome: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Novo Salário: ");
                    double novoSalario = scanner.nextDouble();
                    controller.atualizarFuncionario(atualizarId, novoNome, novoSalario);
                    break;
                case 4:
                    System.out.print("ID do Funcionário: ");
                    int removerId = scanner.nextInt();
                    controller.removerFuncionario(removerId);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
