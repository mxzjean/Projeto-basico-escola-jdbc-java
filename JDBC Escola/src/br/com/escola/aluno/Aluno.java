package br.com.escola.aluno;

public class Aluno {
	private int matricula;
	private String nome;
	private int idade;
	private String serie;
	private String cpf;
	private int nota1;
	private int nota2;
	private int media;
	
	public Aluno(int matricula,String nome,int idade,String serie,String cpf) {
		this.matricula = matricula;
		this.nome = nome;
		this.idade = idade;
		this.serie = serie;
		this.cpf = cpf;
	}
	
	//Metodos Getters
	
	public int getMatricula() {
		return matricula;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public String getSerie() {
		return serie;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public int getNota1() {
		return nota1;
	}
	
	public int getNota2() {
		return nota2;
	}
	
	public int getMedia() {
		return media;
	}
	
	//Setters
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
}
