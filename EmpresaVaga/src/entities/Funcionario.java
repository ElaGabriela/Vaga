package entities;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Funcionario extends Pessoa {
	
	public BigDecimal salario;
	public String funcao;
	DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	DecimalFormat df = new DecimalFormat("###,###,###,###,###.##############");
	
	public Funcionario() {
	}

	public Funcionario(String nome, LocalDate data_nascimento, BigDecimal salario, String funcao) {
		super(nome,data_nascimento);
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

	public String toString() {
		return nome + ", " + data_nascimento.format(fmt1) + ", " + df.format(salario) + ", " + funcao;
	}
	

}
