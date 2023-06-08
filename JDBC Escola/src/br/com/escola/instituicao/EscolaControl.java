package br.com.escola.instituicao;

import java.sql.Connection;
import java.util.Random;

import br.com.escola.ConnectionFactory;
import br.com.escola.aluno.Aluno;

public class EscolaControl {
	public ConnectionFactory connection;
	
	public EscolaControl() {
		this.connection = new ConnectionFactory();
	}
	
	
	public void matricular(String nome,int idade,String serie,String cpf) {
		Random rd = new Random();
		int matricula = rd.nextInt(999) + 1;
		Aluno aluno = new Aluno(matricula,nome,idade,serie,cpf);
		Connection conn = connection.connectWithDataBase();
		if(new EscolaDAO(conn).matricular(aluno) == 1) {
			System.out.println("Matricula realizada com sucesso");
		}else {
			System.out.println("Não foi possivel realizar a matricula");
		}
	}


	public void consultarNotas(int numeroDaMatricula) {
		Connection conn = connection.connectWithDataBase();
		var escola = new EscolaDAO(conn).verificarMatricula(numeroDaMatricula);
		if(escola!=null) {
			new EscolaDAO(conn).consultarNotas(numeroDaMatricula);
		}else {
			System.out.println("Nao existe matricula com este numero\n");
		}
		
		
	}


	public void obterNumMatricula(String cpf) {
		Connection conn = connection.connectWithDataBase();
		if(new EscolaDAO(conn).obterNumMatricula(cpf) == 0) {
			System.out.println("Não existe aluno com este CPF");
		}else {
			System.out.println("A matricula do CPF " + cpf + " é: " + new EscolaDAO(conn).obterNumMatricula(cpf));
		}
		
	}

	public void removerAluno(int matricula) {
		Connection conn = connection.connectWithDataBase();
		new EscolaDAO(conn).removerAluno(matricula);
		System.out.println("Aluno removido com sucesso");
		
	}
	
	
}
