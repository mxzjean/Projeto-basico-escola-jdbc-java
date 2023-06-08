package br.com.escola.instituicao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import br.com.escola.aluno.Aluno;
import java.util.List;
import java.util.ArrayList;

public class EscolaDAO {
	
	private Connection conn;
	
	public EscolaDAO(Connection conn) {
		this.conn = conn;
	}
	
	public int matricular(Aluno aluno) {
		String sql = "INSERT INTO aluno(matricula,nome,idade,serie,cpf) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, aluno.getMatricula());
			ps.setString(2, aluno.getNome());
			ps.setInt(3, aluno.getIdade());
			ps.setString(4, aluno.getSerie());
			ps.setString(5, aluno.getCpf());
			
			ps.execute();
			ps.close();
			conn.close();
			return 1;
		}catch(SQLIntegrityConstraintViolationException e){
			System.out.println("O CPF JA ESTA CADASTRADO");
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return 0;
	}
	
	public void consultarNotas(int numeroDaMatricula) {
		List<Integer> notas = new ArrayList<>();
		String sql = "SELECT * FROM notas JOIN aluno WHERE aluno.MATRICULA = " + numeroDaMatricula;
		PreparedStatement ps;
		ResultSet rs;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				int nota1 = rs.getInt(2);
				int nota2 = rs.getInt(3);
				int media = rs.getInt(4);
				notas.add(nota1);
				notas.add(nota2);
				notas.add(media);
				System.out.println("Nota 1 = " +notas.get(0) + "\nNota 2 = " + notas.get(1) + "\nMedia = " + notas.get(2));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public Aluno verificarMatricula(int numeroDaMatricula) {
		String sql = "SELECT * FROM aluno WHERE matricula = " + numeroDaMatricula;
		PreparedStatement ps;
		ResultSet rs;
		Aluno aluno = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(sql);
			while(rs.next()) {
				int matricula = rs.getInt(1);
				String nome = rs.getString(2);
				int idade = rs.getInt(3);
				String serie = rs.getString(4);
				String cpf = rs.getString(5);
				aluno = new Aluno(matricula,nome,idade,serie,cpf);
				
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return aluno;
	}
	

	public int obterNumMatricula(String cpf) {
		String sql = "SELECT matricula FROM aluno WHERE aluno.cpf = " + cpf;
		PreparedStatement ps;
		ResultSet rs;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(sql);
			while(rs.next()) {
				Integer numeroMatricula = rs.getInt(1);
				return numeroMatricula;
			}
			
		} catch (SQLException e) {
			
		}
		return 0;
	}
	
	public void removerAluno(int numeroDaMatricula) {
		String sql = "DELETE FROM aluno WHERE matricula = " + numeroDaMatricula;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	
	
	
	//Get conn
	public Connection getConn() {
		return conn;
	}



}
