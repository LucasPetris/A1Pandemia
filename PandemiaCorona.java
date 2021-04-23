package atividade;

import java.io.IOException;
import java.util.Scanner;

public class PandemiaCorona {

	public static void nome() {
		System.out.println("Digite o seu nome: ");
	}
	
	public static void Data() {
		System.out.println("Digite o dia do seu nascimento: ");
	}
	
	public static void Mes() {
		System.out.println("Digite o mes de nascimento: ");
	}
	
	public static void Ano() {
		System.out.println("Digite o ano do seu nascimento: ");
	}
	
	public static void Categoria() {
		System.out.println("Digite sua categoria atual (Empregado [1], Empregador [2] ou Desempregado [3]): ");
	}
	
	public static void Beneficio() {
		System.out.println("Digite o valor do seu beneficio: ");
	}
	
	public static void UF() {
		System.out.println("Qual seu estado?: ");
	}
	
	public static void main(String[] args) throws IOException {
		String Nome, Estado,  maiorValor1 = null, maiorValor2 = null, maisTempo1 = null, maisTempo2 = null;
		char resp;
		double valorBene, novoValor = 0, IdadeAtual, BeneTotal = 0, S = 0, totalEmpregador = 0, totalAposentado = 0, pernambuco;
		int dataNascimento, mesNascimento, anoNascimento, Cont = 0, Funcionario, Meses, Categoria, Aposentado, ContBene = 0, Mes = 0;

		Scanner Entrada = new Scanner(System.in);
		
		do {
			nome();
			Nome = Entrada.next();
			Data();
			dataNascimento = Entrada.nextInt();
			Mes();
			mesNascimento = Entrada.nextInt();
			Ano();
			anoNascimento = Entrada.nextInt();
			IdadeAtual = 2021 - anoNascimento;
			if (IdadeAtual < 18) {
				RegraA();
				Cont = Cont + 1;
			} else {
			UF();
			Estado = Entrada.next();
			Beneficio();
			valorBene = Entrada.nextDouble();
			Categoria();
			Categoria = Entrada.nextInt();
			
			if (Categoria == 1 && IdadeAtual >= 18) {
				System.out.println("Aposentado? Sim[1] / Não [2]");
				Aposentado = Entrada.nextInt();
				ContBene = ContBene + 1;
				if (Aposentado == 1) {
				novoValor = valorBene;
				novoValor = RegraS(Estado, valorBene);
				Mes = 2;
				totalAposentado = RegraB(novoValor);
				BeneTotal = totalAposentado * Mes;
				System.out.println("Nome: " + Nome + "\n"
						+ "Data de Nascimento" + "[" + dataNascimento + "] " + "[" + mesNascimento + "] " + "[" + anoNascimento + "] " + "\n"
						+ "Categoria: Aposentado " + "\n"
						+ "Usuario tem " + IdadeAtual + " anos" + " e terá um beneficio de: " + totalAposentado + " durante " + Mes + " meses" + "\n"
						+ " com acréscimo de 30% sobre o beneficio");
				} else if (Aposentado == 2){
					novoValor = valorBene;
					novoValor = RegraS(Estado, valorBene);
					Mes = 3;
					BeneTotal = RegraU(novoValor, Mes);
				System.out.println("Nome: " + Nome + "\n"
							+ "Data de Nascimento" + "[" + dataNascimento + "] " + "[" + mesNascimento + "] " + "[" + anoNascimento + "] " + "\n"
							+ "Categoria: Empregado " + "\n"
							+ "Usuario tem " + IdadeAtual + " anos" + " e terá um beneficio de: " + novoValor + " durante " + Mes + " meses");
				}
		
			} else if (Categoria == 2 && IdadeAtual >= 18) {
				System.out.println("Quantos funcionários?: ");
				Funcionario = Entrada.nextInt();
				ContBene = ContBene + 1;
				novoValor = valorBene * Funcionario;
				novoValor = RegraS(Estado, valorBene);
				totalEmpregador = RegraC(Funcionario, novoValor);
				totalEmpregador = RegraD(Funcionario, novoValor);
				Mes = 4;
				BeneTotal = totalEmpregador * Mes;
				System.out.println("Nome: " + Nome + "\n"
						+ "Data de Nascimento" + "[" + dataNascimento + "] " + "[" + mesNascimento + "] " + "[" + anoNascimento + "] " + "\n"
						+ "Categoria: Empregador " + "\n"
						+ "Usuario tem " + IdadeAtual + " anos" + " e terá um beneficio de: " + totalEmpregador + " durante " + Mes + " meses");
		
			} else if (Categoria == 3 && IdadeAtual >= 18) {
				System.out.println("Há quantos meses está desempregado?: ");
				Meses = Entrada.nextInt();
				ContBene = ContBene + 1;
				novoValor = valorBene;
				novoValor = RegraS(Estado, valorBene);
				Mes = 6;
				BeneTotal = RegraL(novoValor, Mes);
				System.out.println("Nome: " + Nome + "\n"
						+ "Data de Nascimento" + "[" + dataNascimento + "] " + "[" + mesNascimento + "] " + "[" + anoNascimento + "] " + "\n"
						+ "Categoria: Desempregado " + "\n"
						+ "Usuario tem " + IdadeAtual + " anos" + " e terá um beneficio de: " + novoValor + " durante " + Mes + " meses");
			}
			
			if (Estado == "PE" ) {
				valorBene = RegraS(Estado, valorBene);
			}
			if (Mes <= 3) {
				maisTempo1 = Nome;
			} else if (Mes >= 4){
				maisTempo2 = Nome;
			}
			
			if (novoValor >= 1600) {
				maiorValor1 = Nome;
			} else if (totalEmpregador >= 1600) {
				maiorValor1 = Nome;
			} else if (totalAposentado >= 1600) {
				maiorValor1 = Nome;
			}
			
			if (novoValor <= 1500) {
				maiorValor2 = Nome;
			} else if (totalEmpregador <= 1500) {
				maiorValor2 = Nome;
			} else if (totalAposentado <= 1500) {
				maiorValor2 = Nome;
			}
			
			
			if (IdadeAtual >= 18) {
			S = S + BeneTotal;
			}
			
			
			}
			
		System.out.println("Você desejar informar mais um Beneficiario? [S] ou [N]: ");
		resp = (char)System.in.read();
		} while (resp == 'S');
	
		System.out.println("Total de usuarios lidos: " + Cont + "\n"
				+ "Total de Beneficiarios: " + ContBene + "\n"
				+ "Total de valor que será concedido: " + S + "\n"
				+ "2 beneficiarios que vão receber por mais tempo: " + maisTempo1 + " " +  maisTempo2 + "\n"
				+ "2 beneficiarios que vão receber o maior valor: " + maiorValor1 + " " + maiorValor2);
		
	}
	
	public static double RegraL(double a, int b) {
		return a * b;
	}

	public static double RegraU(double c, int d) {
		return c * d;
	}
	
	public static double RegraC(int e, double f) {
		double per = 0.1;
		if (e <= 50) {
			f = (f * per) + f;		
		}
		return f;
	}
	
	public static void RegraA() {
		System.out.println("O beneficio só será atribuido a maiores de 18 anos.");
	}
	
	public static double RegraB(double g) {
		double per = 0.3;
		per = g * per;
		return g + per;
	}
	
	
	
	public static double RegraD(int h, double i) {
		double per = 0.11;
		if (h <= 40) {
			i = (i * per) + i;		
		}
		return i;
	}
	
	public static double RegraS(String j, double k) {
		if (j == "PE") {
		double per = 0.14;
		k = (k * per) + k;
		}
		return k;
	}
	
}
