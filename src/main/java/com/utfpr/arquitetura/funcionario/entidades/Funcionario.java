package com.utfpr.arquitetura.funcionario.entidades;


public class Funcionario {

	private Long id;
	private String nome;
	private int idade;
	private float salario;



	public Funcionario(Long id, String nome, int idade, float salario) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.salario = salario;
	}
	
	public Funcionario() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

}
