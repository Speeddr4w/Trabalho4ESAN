package model;

import java.time.LocalDate;
import java.util.Date;

public class Funcionario {

	private int id;
	private static int geradorId = 1;
	private String nome;
	private LocalDate dataNascimento;
	private float salario;
	
	public Funcionario(String nome, LocalDate dataNascimento, float salario) {
		this.id =  this.geradorId;
		this.geradorId++;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.salario = salario;
	}
	
	public Funcionario(int id, String nome, LocalDate dataNascimento, float salario) {
		this.id =  id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.salario = salario;
	}
	
	
	public int getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public float getSalario() {
		return salario;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}
	
	
	
}
