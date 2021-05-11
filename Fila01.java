package atividade;

import java.util.Scanner;

public class Fila01 {

	public static void main(String[] args) {
		String Nomes[] = new String[20];

		int Idade[] = new int[20];

		int Digito;

		String Primeiro = null, Ultimo;

		String Descri[] = new String[20];

		Scanner Entrada = new Scanner(System.in);

		int contador = 0; // Variavel para contar as pessoas
		
		int atender; // Variavel usada para atender as pessoas
		
		
		do {
			System.out.println("----------------------------------");
			System.out.println("GERENCIAMENTO DA FILA DO POSTINHO");
			System.out.println("1 - Incluir Pacientes" + "\n" + "2 - Atender Paciente" + "\n" + "3 - Sair");
			System.out.println("----------------------------------");
			Digito = Entrada.nextInt();

			switch (Digito) {
			case 1:

				System.out.println("Nome do Paciente: ");
				Nomes[contador] = Entrada.next();
				System.out.println("Idade: ");
				Idade[contador] = Entrada.nextInt();
				System.out.println("Descrição do Atendimento: ");
				Descri[contador] = Entrada.next();

				System.out.println("Paciente na posição " + (contador + 1) + ": (" + Nomes[contador] + ")"
						+ " foi incluído na Fila de Atendimento");

				contador++;

				break;
			case 2:

				if (Nomes[0] == null) {
					System.out.println("Fila vazia, insira pessoas na fila para continuar o atendimento");
					break;
					
				} else {

					System.out.println("Digite o Numero do Paciente que deseja atender");
					atender = Entrada.nextInt();
					
					if(Nomes[atender] == null) {
						
						System.out.println("\nNão existe um paciente de Numero " +atender);
						
					}else {
						
					System.out.println("\nO paciente " + Nomes[atender] + " foi atendido.");
					
					int j = atender + 1;

					for (; atender < 19; atender++) {

						Nomes[atender] = Nomes[j];
						Idade[atender] = Idade[j];
						Descri[atender] = Descri[j];

						j++;
					}

					Nomes[19] = null;
					Idade[19] = 0;
					Descri[19] = null;

					contador--;

					}
					
	
							break;

				}
						}

			System.out.println("----------------------------------");
			for (int i = 0; i < 20; i++) {

					System.out.println("Fila Atualizada no Momento: " + Nomes[i]);
			}

		} while (Digito < 3);

	}


}


