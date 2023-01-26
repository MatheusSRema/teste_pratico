package entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;


public class Funcionario extends Pessoa {

	private BigDecimal salario;
	private String funcao;
	
	public Funcionario() {
		super();
	}

	public Funcionario(String nome, LocalDate dataDeNascimento, BigDecimal salario, String funcao) {
		super(nome, dataDeNascimento);
		this.salario = salario;
		this.funcao = funcao;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(funcao, salario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return Objects.equals(funcao, other.funcao) && Objects.equals(salario, other.salario);
	}
	
	
		
}


