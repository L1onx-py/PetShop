import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InventarioPetshop inventario = new InventarioPetshop();
        Scanner scanner = new Scanner(System.in);

        exibirMenu();
        int opcao = scanner.nextInt();

        while (opcao != 2) {
            escolherServico();
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1 -> registrarBanho(inventario, scanner);
                case 2 -> registrarHospedagem(inventario, scanner);
                case 3 -> registrarTosa(inventario, scanner);
                default -> System.out.println("Opção inválida. Tente novamente.");
            }

            exibirMenu();
            opcao = scanner.nextInt();
        }

        System.out.println("📝 Resumo dos serviços cadastrados:");
        System.out.println(inventario.listaServicos());
    }

    private static void registrarBanho(InventarioPetshop inventario, Scanner scanner) {
        System.out.print("Código do serviço: ");
        int codigo = scanner.nextInt();
        Tamanho tamanho = selecionarTamanho(scanner);
        Pelo pelo = selecionarPelo(scanner);

        ServicoPetshop banho = new Banho(codigo, tamanho, pelo);
        inventario.adicionaServico(banho);
        System.out.println(inventario.descricaoServico(banho));
    }

    private static void registrarHospedagem(InventarioPetshop inventario, Scanner scanner) {
        System.out.print("Código da hospedagem: ");
        int codigo = scanner.nextInt();
        Tamanho tamanho = selecionarTamanho(scanner);
        System.out.print("Horas de permanência: ");
        int horas = scanner.nextInt();

        ServicoPetshop hospedagem = new Hotel(codigo, tamanho, horas);  // Usando a classe Hotel
        inventario.adicionaServico(hospedagem);
        System.out.println(inventario.descricaoServico(hospedagem));
    }

    private static void registrarTosa(InventarioPetshop inventario, Scanner scanner) {
        System.out.print("Código da tosa: ");
        int codigo = scanner.nextInt();
        Tamanho tamanho = selecionarTamanho(scanner);

        ServicoPetshop tosa = new Tosa(codigo, tamanho, "Tosa do pet");
        inventario.adicionaServico(tosa);
        System.out.println(inventario.descricaoServico(tosa));
    }

    private static void exibirMenu() {
        System.out.println("\n🐶 Bem-vindo ao Petshop! 🐱");
        System.out.println("1 - Adicionar novo serviço");
        System.out.println("2 - Finalizar e exibir registros");
        System.out.print("Escolha uma opção: ");
    }

    private static void escolherServico() {
        System.out.println("📌 Selecione o serviço desejado:");
        System.out.println("1 - Banho");
        System.out.println("2 - Hospedagem");
        System.out.println("3 - Tosa");
        System.out.print("Digite a opção: ");
    }

    private static Tamanho selecionarTamanho(Scanner scanner) {
        System.out.println("🐾 Escolha o tamanho do pet:");
        System.out.println("1 - Pequeno");
        System.out.println("2 - Médio");
        System.out.println("3 - Grande");
        int escolha = scanner.nextInt();
        return switch (escolha) {
            case 1 -> Tamanho.PEQUENO;
            case 2 -> Tamanho.MEDIO;
            case 3 -> Tamanho.GRANDE;
            default -> throw new IllegalArgumentException("Opção inválida!");
        };
    }

    private static Pelo selecionarPelo(Scanner scanner) {
        System.out.println("🐾 Escolha o tipo de pelo:");
        System.out.println("1 - Curto");
        System.out.println("2 - Médio");
        System.out.println("3 - Longo");
        int escolha = scanner.nextInt();
        return switch (escolha) {
            case 1 -> Pelo.CURTO;
            case 2 -> Pelo.MEDIO;
            case 3 -> Pelo.LONGO;
            default -> throw new IllegalArgumentException("Opção inválida!");
        };
    }
}
