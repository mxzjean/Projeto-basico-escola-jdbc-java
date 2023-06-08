package br.com.escola;

import java.util.Scanner;

import br.com.escola.instituicao.Escola;
import br.com.escola.instituicao.EscolaControl;

public class ApplicationEscola {
	public static EscolaControl escola = new EscolaControl();
	//Metodo Main
	public static void main(String[] args) {
		menu();		

	}
	
	public static void menu() {
		Scanner sc = new Scanner(System.in);
		Escola escola = new Escola("Analise");
		System.out.println("Bem vindo a escola " + escola.getNome());
		System.out.println("Em que podemos ajudar?\n");
		int opcao = 8;
		while(opcao!=5) {
			System.out.println("-----------OPCOES-----------\n");
			System.out.println("1 - Matricular aluno\n"
					+ "2 - Consultar notas\n"
					+ "3 - Obter numero da matricula\n"
					+ "4 - Remover aluno matriculado\n"
					+ "5 - Sair");
			opcao = sc.nextInt();
		
			switch(opcao) {
				case 1:
					matricularAluno();
					break;
				case 2:
					consultarNotas();
					break;
				case 3:
					obterNumMatricula();
					break;
				case 4:
					removerAluno();
					break;
				case 5:
					System.out.println("Encerrando aplicação");
					System.exit(0);
					sc.close();
				default:
					break;
			}
		}

	}

	private static void matricularAluno() {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		@SuppressWarnings("resource")
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Para realizar a matricula precisaremos de alguns dados:\n"
				+ "Nome, idade, serie, cpf\n");
		System.out.println("Digite o nome:");
		String nome = sc.nextLine();
		System.out.println("Digite a idade");
		int idade = sc.nextInt();
		System.out.println("Digite a serie que vai cursar:");
		String serie = sc1.nextLine();
		System.out.println("Digite o cpf");
		String cpf = sc1.next();
		while(cpf.length()!=11) {
			System.out.println("Digite um cpf valido");
			cpf = sc1.next();
		}
		
		escola.matricular(nome,idade,serie,cpf);
		
		
	}
	
	private static void consultarNotas() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o numero da matricula");
		int matricula = sc.nextInt();
		escola.consultarNotas(matricula);
		
	}
	
	private static void obterNumMatricula() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o CPF do aluno");
		String cpf = sc.next();
		while(cpf.length()!=11) {
			System.out.println("Digite um cpf valido");
			cpf = sc.next();
		}
		escola.obterNumMatricula(cpf);
	}
	
	private static void removerAluno() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite a matricula do aluno:");
		int matricula = sc.nextInt();
		escola.removerAluno(matricula);
	}

}//Fim da classe Application
