package conta;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DigitaConta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numeroConta = -1; // Inicializa com um valor inválido
        boolean continuar = true;

        do {
            System.out.println("Digite o número da conta (Digite 0 para sair): ");
            try {
                numeroConta = scanner.nextInt();
                
                if (numeroConta == 0) {
                    continuar = false; // Encerra o programa
                    break;
                }

                // Criando uma nova conta poupança
                ContaPoupanca conta = new ContaPoupanca(numeroConta);

                System.out.println("Digite o nome do titular: ");
                scanner.nextLine(); // Consumir o restante da linha
                String titular = scanner.nextLine();
                conta.setTitular(titular);

                System.out.println("Deseja sacar ou depositar? (1 para sacar, 2 para depositar): ");
                int operacao = scanner.nextInt();

                if (operacao == 1) {
                    System.out.println("Digite o valor a ser sacado: ");
                    double valor = scanner.nextDouble();
                    conta.saqueConta(valor);
                } else if (operacao == 2) {
                    System.out.println("Digite o valor a ser depositado: ");
                    double valor = scanner.nextDouble();
                    conta.depositoConta(valor);
                } else {
                    System.out.println("Operação inválida.");
                }

                // Mostra o saldo atual
                System.out.println("Saldo atual: " + conta.getSaldo());
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Por favor, digite números inteiros para o número da conta.");
                scanner.nextLine(); // Limpa o buffer do scanner
            }

        } while (continuar);

        System.out.println("Programa encerrado.");
        scanner.close();
    }
}