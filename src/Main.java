import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Banco banco = new Banco("Banco Digital");

		while (true) {
			System.out.println("\n=== MENU ===");
			System.out.println("1 - Cadastrar novo cliente");
			System.out.println("2 - Ver extratos");
			System.out.println("0 - Sair");
			System.out.print("Escolha uma opção: ");
			
			int opcao = scanner.nextInt();
			scanner.nextLine(); // Consumir quebra de linha

			switch (opcao) {
				case 1:
					System.out.print("Nome do cliente: ");
					String nome = scanner.nextLine();

					Cliente cliente = new Cliente();
					cliente.setNome(nome);

					Conta cc = new ContaCorrente(cliente);
					Conta poupanca = new ContaPoupanca(cliente);

					System.out.print("Valor para depósito inicial na Conta Corrente: ");
					double deposito = scanner.nextDouble();
					cc.depositar(deposito);

					banco.adicionarConta(cc);
					banco.adicionarConta(poupanca);

					System.out.println("Cliente e contas criados com sucesso!");
					break;

				case 2:
					for (Conta conta : banco.getContas()) {
						conta.imprimirExtrato();
						System.out.println();
					}
					break;

				case 0:
					System.out.println("Encerrando programa.");
					scanner.close();
					System.exit(0);
					break;

				default:
					System.out.println("Opção inválida.");
			}
		}
	}

}
