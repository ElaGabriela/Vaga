package aplicacao;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entities.Funcionario;

public class Main {

	public static void main(String[] args) {

		/////3.1
		List<Funcionario> list = new ArrayList<>();
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Funcionario temp;
		DecimalFormat df = new DecimalFormat("###,###,###,###,###.##############");
		
		temp = new Funcionario("Maria",LocalDate.parse("18/10/2020", fmt1),null,"Operador");
		temp.setSalario(new BigDecimal("2009.44"));
		list.add(temp);
		temp = new Funcionario("João",LocalDate.parse("12/05/1990", fmt1),null,"Operador");
		temp.setSalario(new BigDecimal("2284.38"));
		list.add(temp);
		temp = new Funcionario("Caio",LocalDate.parse("02/05/1961", fmt1),null,"Coordenador");
		temp.setSalario(new BigDecimal("9836.14"));
		list.add(temp);
		temp = new Funcionario("Miguel",LocalDate.parse("14/10/1988", fmt1),null,"Diretor");
		temp.setSalario(new BigDecimal("19119.88"));
		list.add(temp);
		temp = new Funcionario("Alice",LocalDate.parse("05/01/1995", fmt1),null,"Recepcionista");
		temp.setSalario(new BigDecimal("2234.68"));
		list.add(temp);
		temp = new Funcionario("Heitor",LocalDate.parse("19/11/1999", fmt1),null,"Operador");
		temp.setSalario(new BigDecimal("1582.72"));
		list.add(temp);
		temp = new Funcionario("Arthur",LocalDate.parse("31/03/1993", fmt1),null,"Contador");
		temp.setSalario(new BigDecimal("4071.84"));
		list.add(temp);
		temp = new Funcionario("Laura",LocalDate.parse("08/07/1994", fmt1),null,"Gerente");
		temp.setSalario(new BigDecimal("3017.45"));
		list.add(temp);
		temp = new Funcionario("Heloísa",LocalDate.parse("24/05/2003", fmt1),null,"Eletricista");
		temp.setSalario(new BigDecimal("1606.85"));
		list.add(temp);
		temp = new Funcionario("Helena",LocalDate.parse("02/09/1996", fmt1),null,"Gerente");
		temp.setSalario(new BigDecimal("2799.93"));
		list.add(temp);
		
		System.out.println("////3.1");
		System.out.println("Lista de Funcionários:");
		for (Funcionario e : list) {
			System.out.println(e);
		}		
		
		////3.2
		list.removeIf( funcionario -> funcionario.getNome().equalsIgnoreCase("João"));
		System.out.println();
		System.out.println("////3.2");
		System.out.println("REMOVIDO O FUNCIONÁRIO JOÃO");
		
		////3.3
		System.out.println();
		System.out.println("////3.3");
		System.out.println("Lista de Funcionários:");
		for (Funcionario e : list) {
		System.out.println(e);
			}	
		
		////3.4
		for (Funcionario e : list) {
			e.setSalario(e.getSalario().multiply(new BigDecimal("1.10")));
		}
		System.out.println();
		System.out.println("////3.4");
		System.out.println("OS FUNCIONÁRIOS RECEBERAM 10% DE AUMENTO NO SALÁRIO");
			
					
		////3.5
		Map<String, List<Funcionario>> map = new HashMap<String, List<Funcionario>>();
		for ( Funcionario e : list ) {
		    List<Funcionario> maps = map.get(e.getFuncao());
		    if(maps == null) {
		    	map.put(e.getFuncao(), maps = new ArrayList<Funcionario>());
		    }
		    maps.add(e);
		}
		System.out.println();
		System.out.println("////3.5");
		System.out.println("OS FUNCIONÁRIOS FORAM AGRUPADOS POR FUNÇÃO EM UM MAP");
			
		////3.6
		System.out.println();
		System.out.println("////3.6");
		System.out.println("Funcionários agrupados por função: " + map);
			
		////3.8
		DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("MM");
		System.out.println();
		System.out.println("////3.8");
		System.out.println("Funcionários que fazem aniversário nos meses 10 e 12:");
		for (Funcionario e : list) {
			String mes = e.getData_nascimento().format(fmt2);
			if(mes.equalsIgnoreCase("10")|| mes.equalsIgnoreCase("12"))
			System.out.println(e.getNome());
		}
		
		////3.9
		System.out.println();
		System.out.println("////3.9");
		System.out.println("Funcionário mais velho:");
		Funcionario func = new Funcionario("null",LocalDate.now(),null, "null");
		for (Funcionario e : list) {
			if((e.getData_nascimento().isBefore(func.getData_nascimento())))
			func = e;
		}
		long ano = func.getData_nascimento().until(LocalDate.now(), ChronoUnit.MONTHS)/12;
		System.out.println(func.getNome()+", "+ano+" anos.");
		
		////3.10
		System.out.println();
		System.out.println("////3.10");
		System.out.println("Lista de funcionários por ordem alfabética:");
		Collections.sort(list, Comparator.comparing(Funcionario::getNome));
		for (Funcionario e : list) {
			System.out.println(e);
		}

		////3.11
		System.out.println();
		System.out.println("////3.11");
		System.out.println("Valor total dos salários dos funcionários:");
		BigDecimal total = new BigDecimal("0");
		for (Funcionario e : list) {
			total = e.getSalario().add(total);
		}
		System.out.println(df.format(total));
		

		////3.12
		System.out.println();
		System.out.println("////3.12");
		System.out.println("Quantidade de salários mínimo(R$ 1212,00) que cada funcionário ganha:");
		BigDecimal minimo = new BigDecimal("1212.00");
		for (Funcionario e : list) {
			BigDecimal quant = (e.getSalario().divide(minimo,2, RoundingMode.HALF_UP));
			System.out.println(e.getNome()+": "+quant+"");
		}
		
	}}

