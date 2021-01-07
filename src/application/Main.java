package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import entities.Account;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);

		Account conta;
		try {
			System.out.print("Entre com o número da conta: ");
			int numero = input.nextInt();
			
			System.out.print("Entre com o titular da conta: ");
			input.nextLine();
			String titular = input.nextLine();

			System.out.print("Haverá depósito inicial (s/n)? ");
			char resposta = input.next().charAt(0);

			if (resposta == 's' || resposta == 'S') {
				System.out.print("Entre com o depósito inicial: R$ ");
				double depositoInicial = input.nextDouble();
				conta = new Account(numero, titular, depositoInicial);
			} else {
				conta = new Account(numero, titular);
			}
			System.out.println("\nDados da conta:");
			System.out.println(conta);

			System.out.print("\nEntre com o valor de depósito: R$ ");
			conta.deposito(input.nextDouble());

			System.out.println("Dados da conta atualizados:");
			System.out.println(conta);

			System.out.print("\nEntre com o valor de saque: R$ ");
			conta.saque(input.nextDouble());

			System.out.println("Dados da conta atualizados:");
			System.out.println(conta);

		} catch (InputMismatchException e) {
			System.out.println("\n\nVocê inseriu um tipo de dado errado.");
			System.out.println("Reinicie o programa para tentar novamente");
		} catch (NullPointerException e) {
			System.out.println("\n\nVocê deixou de inserir um dado.");
			System.out.println("Reinicie o programa para tentar novamente");
		} finally {
			input.close();
		}
	}
}
