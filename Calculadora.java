import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean executando = true;

        while (executando) {
            exibirMenu();
            int opcao = lerOpcao(scanner);

            if (opcao == 0) {
                System.out.println("\nEncerrando a calculadora. Até logo!");
                executando = false;
                continue;
            }

            if (opcao < 0 || opcao > 6) {
                System.out.println("\n[!] Opção inválida! Escolha uma opção entre 0 e 6.\n");
                continue;
            }

            double a = lerNumero(scanner, "Digite o primeiro número (A): ");
            double b = lerNumero(scanner, "Digite o segundo número (B): ");

            executarOperacao(opcao, a, b);

            System.out.println("\n-------------------------------------------");
        }

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n===========================================");
        System.out.println("            CALCULADORA JAVA               ");
        System.out.println("===========================================");
        System.out.println("  1 - Somar (+)");
        System.out.println("  2 - Subtrair (-)");
        System.out.println("  3 - Multiplicar (*)");
        System.out.println("  4 - Dividir (/)");
        System.out.println("  5 - Potenciação (A ^ B)");
        System.out.println("  6 - Resto da Divisão (A % B)");
        System.out.println("  0 - Sair");
        System.out.println("===========================================");
        System.out.print("Escolha uma opção: ");
    }

    private static int lerOpcao(Scanner scanner) {
        String entrada = scanner.next();
        try {
            return Integer.parseInt(entrada.trim());
        } catch (NumberFormatException e) {
            return -1; // Retorna opção inválida
        }
    }

    private static double lerNumero(Scanner scanner, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String entrada = scanner.next();
            try {
                // Aceita tanto ponto (.) quanto vírgula (,) como separador decimal
                return Double.parseDouble(entrada.trim().replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.println("[!] Entrada inválida! Por favor, digite um número válido (ex: 10 ou 3.5).");
            }
        }
    }

    private static void executarOperacao(int opcao, double a, double b) {
        switch (opcao) {
            case 1:
                double soma = somar(a, b);
                System.out.printf("%n-> Resultado: %.2f + %.2f = %.2f%n", a, b, soma);
                break;

            case 2:
                double subtracao = subtrair(a, b);
                System.out.printf("%n-> Resultado: %.2f - %.2f = %.2f%n", a, b, subtracao);
                break;

            case 3:
                double multiplicacao = multiplicar(a, b);
                System.out.printf("%n-> Resultado: %.2f * %.2f = %.2f%n", a, b, multiplicacao);
                break;

            case 4:
                if (b == 0) {
                    System.out.println("\n[!] Erro: Divisão por zero não é permitida!");
                } else {
                    double divisao = dividir(a, b);
                    System.out.printf("%n-> Resultado: %.2f / %.2f = %.2f%n", a, b, divisao);
                }
                break;

            case 5:
                double potencia = potenciar(a, b);
                System.out.printf("%n-> Resultado: %.2f ^ %.2f = %.2f%n", a, b, potencia);
                break;

            case 6:
                if (b == 0) {
                    System.out.println("\n[!] Erro: Resto de divisão por zero não é permitido!");
                } else {
                    double resto = restoDivisao(a, b);
                    System.out.printf("%n-> Resultado: %.2f %% %.2f = %.2f%n", a, b, resto);
                }
                break;
        }
    }

    // Métodos modulares para cada operação matemática
    public static double somar(double a, double b) {
        return a + b;
    }

    public static double subtrair(double a, double b) {
        return a - b;
    }

    public static double multiplicar(double a, double b) {
        return a * b;
    }

    public static double dividir(double a, double b) {
        return a / b;
    }

    public static double potenciar(double a, double b) {
        return Math.pow(a, b);
    }

    public static double restoDivisao(double a, double b) {
        return a % b;
    }
}
