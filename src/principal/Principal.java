package principal;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import informacoes.pessoa.Funcionario;

public class Principal {

	public static void main(String[] args) {
		
		/** Início da Parte 3.1 **/
		/*Funcionario fun1 = new Funcionario("Maria", LocalDate.of(2000,10,18), new BigDecimal(2009.44),"Operador");
		Funcionario fun2 = new Funcionario("João", LocalDate.of(1990,05,12), new BigDecimal(2284.38),"Operador");
		Funcionario fun3 = new Funcionario("Caio", LocalDate.of(1961,05,02), new BigDecimal(9836.14),"Coordenador");
		Funcionario fun4 = new Funcionario("Miguel", LocalDate.of(1988,10,14), new BigDecimal(19119.88),"Diretor");
		Funcionario fun5 = new Funcionario("Alice", LocalDate.of(1995,01,05), new BigDecimal(2234.68),"Recepcionista");
		Funcionario fun6 = new Funcionario("Heitor", LocalDate.of(1999,11,17), new BigDecimal(1582.72),"Operador");
		Funcionario fun7 = new Funcionario("Arthur", LocalDate.of(1993,03,31), new BigDecimal(4071.84),"Contador");
		Funcionario fun8 = new Funcionario("Laura", LocalDate.of(1994,07,8), new BigDecimal(3017.45),"Gerente");
		Funcionario fun9 = new Funcionario("Heloísa", LocalDate.of(2003,05,24), new BigDecimal(1606.85),"Eletricista");
		Funcionario fun10 = new Funcionario("Helena", LocalDate.of(1996,9,02),new BigDecimal(2799.93),"Gerente");*/
		
		ArrayList<Funcionario> listaDeFuncionarios = new ArrayList<>();
		
		adicionaFuncionario("Maria", LocalDate.of(2000,10,18), new BigDecimal(2009.44),"Operador", listaDeFuncionarios);
		adicionaFuncionario("João", LocalDate.of(1990,05,12), new BigDecimal(2284.38),"Operador", listaDeFuncionarios);
		adicionaFuncionario("Caio", LocalDate.of(1961,05,02), new BigDecimal(9836.14),"Coordenador", listaDeFuncionarios);
		adicionaFuncionario("Miguel", LocalDate.of(1988,10,14), new BigDecimal(19119.88),"Diretor", listaDeFuncionarios);
		adicionaFuncionario("Alice", LocalDate.of(1995,01,05), new BigDecimal(2234.68),"Recepcionista", listaDeFuncionarios);
		adicionaFuncionario("Heitor", LocalDate.of(1999,11,17), new BigDecimal(1582.72),"Operador", listaDeFuncionarios);
		adicionaFuncionario("Arthur", LocalDate.of(1993,03,31), new BigDecimal(4071.84),"Contador", listaDeFuncionarios);
		adicionaFuncionario("Laura", LocalDate.of(1994,07,8), new BigDecimal(3017.45),"Gerente", listaDeFuncionarios);
		adicionaFuncionario("Heloísa", LocalDate.of(2003,05,24), new BigDecimal(1606.85),"Eletricista", listaDeFuncionarios);
		adicionaFuncionario("Helena", LocalDate.of(1996,9,02), new BigDecimal(2799.93),"Gerente", listaDeFuncionarios);
		
		/*listaDeFuncionarios.add(fun1);
		listaDeFuncionarios.add(fun2);
		listaDeFuncionarios.add(fun3);
		listaDeFuncionarios.add(fun4);
		listaDeFuncionarios.add(fun5);
		listaDeFuncionarios.add(fun6);
		listaDeFuncionarios.add(fun7);
		listaDeFuncionarios.add(fun8);
		listaDeFuncionarios.add(fun9);
		listaDeFuncionarios.add(fun10);*/
		
		/** Fim da Parte 3.1 **/
		
		for(Funcionario x : listaDeFuncionarios)
		{
			System.out.println(x.getNome());
		}
		
		System.out.println("---------------------------\n");
		
		/** Início da Parte 3.2 **/
		
		listaDeFuncionarios.removeIf(x -> x.getNome() == "João");
		
		/** Fim da Parte 3.2 **/
		
		for(Funcionario x : listaDeFuncionarios)
		{
			System.out.println(x.getNome());
		}
		
		System.out.println("---------------------------\n");
		
		/** Início da Parte 3.3 **/
		
		System.out.println("\nLista de Funcioários Completa:\n");
		
		for(Funcionario x : listaDeFuncionarios)
		{
			imprimiFuncionarios(x);
		}
		
		/** Fim da Parte 3.3 **/
		
		System.out.println("---------------------------\n");
		
		/** Início da Parte 3.4 **/
		
		for(Funcionario x : listaDeFuncionarios)
		{
			ajusteSalarial(x, new BigDecimal(0.1));
		}
		
		/** Fim da Parte 3.4 **/
		
		for(Funcionario x : listaDeFuncionarios)
		{
			imprimiFuncionarios(x);
		}

		System.out.println("---------------------------\n");
		
		/** Início da Parte 3.5 **/
		

		Map<String , ArrayList<Funcionario>> semelhancas = new TreeMap<String, ArrayList<Funcionario>>();
		for ( Funcionario p : listaDeFuncionarios) {
			ArrayList<Funcionario> semelhantes = semelhancas.get(p.getFuncao());
			if ( semelhantes == null )
				semelhancas.put(p.getFuncao(), semelhantes = new ArrayList<Funcionario>());
		    semelhantes.add(p);
		}
		
		/** Fim da Parte 3.5 **/
		
		/** Início da Parte 3.6 **/
		System.out.println("Printa Resultado");
		for(String chave : semelhancas.keySet())
		{
			System.out.println(chave + ":    " +semelhancas.get(chave));
		}

		System.out.println("---------------------------\n");
		
		/** Fim da Parte 3.6 **/
		
		
		
		/** Início da Parte 3.8 **/
		ArrayList<Funcionario> aniversariontesDoMes = new ArrayList<>();
		
		verificaAniversarianteDoMes(listaDeFuncionarios, 10, aniversariontesDoMes);
		verificaAniversarianteDoMes(listaDeFuncionarios, 12, aniversariontesDoMes);
		
		System.out.println("Segue a lista dos Aniversariantes de Outubro e de Dezembro:\n");
		for(Funcionario x : aniversariontesDoMes)
		{
			imprimiFuncionarios(x);
		}
		System.out.println("---------------------------\n");
		/** Fim da Parte 3.8 **/
		
		
		
		/** Início da Parte 3.9 **/
		Funcionario funcionarioMaisVelho = new Funcionario();
		funcionarioMaisVelho = encontraMaisVelho(listaDeFuncionarios);
		
		LocalDate hoje = LocalDate.now();
		Period idade = Period.between(funcionarioMaisVelho.getDataDeNascimento(), hoje);
		
		System.out.println("\n\nO funcionário mais velho: " + funcionarioMaisVelho.getNome() +", têm: "+ idade.getYears() + " anos de idade. \n");
		
		System.out.println("---------------------------\n");
		/** Fim da Parte 3.9 **/
		
		/** Início da Parte 3.10 **/
		
		imprimiFuncionariosOrdemAlfabetica(listaDeFuncionarios);
		
		/** Fim da Parte 3.10 **/
		
		System.out.println("---------------------------\n");
		
		/** Início da Parte 3.11 **/
		
		imprimiSalarioTotalFuncionarios(listaDeFuncionarios);
		
		/** Fim da Parte 3.11 **/
		
		System.out.println("---------------------------\n");
		
		/** Início da Parte 3.12 **/
		
		imprimiSalarioComBaseNoMinimo(listaDeFuncionarios);
		
		/** Fim da Parte 3.12 **/
		System.out.println("---------------------------\n");
	}
	
	public static void adicionaFuncionario(String nome, LocalDate dataDeNascimento, BigDecimal salario, String funcao, ArrayList<Funcionario> listaDeFuncionarios) {
		
		Funcionario fun = new Funcionario(nome, dataDeNascimento, salario, funcao);
		listaDeFuncionarios.add(fun);
		
	}
	
	public static void imprimiFuncionarios(Funcionario funcionario) {
		
		DateTimeFormatter formatadorBarra = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		Locale localBrasil = new Locale("pt","BR");
		NumberFormat formatoBrasil = NumberFormat.getNumberInstance(localBrasil);
		
		System.out.println("\nNome: "+funcionario.getNome() + ", Data de Nacimento: " + (funcionario.getDataDeNascimento()).format(formatadorBarra) + ", Salário: R$" + formatoBrasil.format(funcionario.getSalario()) + " e Função: " + funcionario.getFuncao() + ".");
	}
	
	public static void ajusteSalarial(Funcionario funcionario, BigDecimal ajuste) {
		funcionario.setSalario(funcionario.getSalario().multiply((new BigDecimal(1.0).add(ajuste))));
	}
	
	public static void verificaAniversarianteDoMes(ArrayList<Funcionario> listaDeFuncionarios, Integer mes, ArrayList<Funcionario> listaDeAniversariantes) {
		
		for(Funcionario x : listaDeFuncionarios)
		{
			
			if(((x.getDataDeNascimento()).getMonthValue()) == mes)
			{
				listaDeAniversariantes.add(x);
			}
		}
		
	}
	
	public static Funcionario encontraMaisVelho(ArrayList<Funcionario> listaDeFuncionarios){
		
		Funcionario oMaisVelho = new Funcionario();
		oMaisVelho = listaDeFuncionarios.get(0);
		for(Funcionario x : listaDeFuncionarios)
		{
			
			if((x.getDataDeNascimento()).isBefore(oMaisVelho.getDataDeNascimento()))
			{
				oMaisVelho = x;
			}
		}
		
		return(oMaisVelho);
	}
	
	public static void imprimiFuncionariosOrdemAlfabetica(ArrayList<Funcionario> listaDeFuncionarios) {
		
		ArrayList<Funcionario> listaDeFuncionariosOrdenada = new ArrayList<>(listaDeFuncionarios);
		
		Collections.sort(listaDeFuncionariosOrdenada, Comparator.comparing(Funcionario::getNome));
		
		for(Funcionario x : listaDeFuncionariosOrdenada)
		{
			imprimiFuncionarios(x);
		}
	}
	
	public static void imprimiSalarioTotalFuncionarios(ArrayList<Funcionario> listaDeFuncionarios) {
		
		BigDecimal salarioTotal = new BigDecimal(0.0);
		
		Locale localBrasil = new Locale("pt","BR");
		NumberFormat formatoBrasil = NumberFormat.getNumberInstance(localBrasil);
		
		for(Funcionario x : listaDeFuncionarios)
		{
			salarioTotal = salarioTotal.add(x.getSalario());
		}
		
		System.out.println("O salário total de todos os funcionários é: R$" +formatoBrasil.format(salarioTotal));
	}
	
	
	public static void imprimiSalarioComBaseNoMinimo(ArrayList<Funcionario> listaDeFuncionarios) {
		
		BigDecimal salarioMinimo = new BigDecimal(1212.00);
		
		Locale localBrasil = new Locale("pt","BR");
		NumberFormat formatoBrasil = NumberFormat.getNumberInstance(localBrasil);
		
		for(Funcionario x : listaDeFuncionarios)
		{
			System.out.println("\nO salário de " + x.getNome() + " equivalem a: " +formatoBrasil.format((x.getSalario()).divide(salarioMinimo,3,RoundingMode.UP)) + " salários mínimo.");
		}
		
		
	}
	
}


