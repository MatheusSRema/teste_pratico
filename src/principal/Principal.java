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

import entity.Funcionario;
import utilitaries.*;

public class Principal {

	public static void main(String[] args) {
		
		ArrayList<Funcionario> listaDeFuncionarios = new ArrayList<>();
		Map<String , ArrayList<String>> agupamentoPorFuncao = new TreeMap<String, ArrayList<String>>();
		Integer opcao ;
		
		/** Início do ítem 3.1 **/
		
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
		
		/** Fim do ítem 3.1 **/
		
		do {
			
			opcao = Menu.menuPrincipal();
			
			switch (opcao) {
			
				case 1:
					/** Início do ítem 3.2 **/
					
					removeFuncionario(listaDeFuncionarios);
					
					/** Fim do ítem 3.2 **/
					break;
					
				case 2:
					
					/** Início do ítem 3.3 **/
					
					imprimiFuncionarios(listaDeFuncionarios);
					
					/** Fim do ítem 3.3 **/
					break;
					
				case 3:
					
					/** Início do ítem 3.4 **/
					
					ajusteSalarial(listaDeFuncionarios);
					
					/** Fim do ítem 3.4 **/
					break;
					
				case 4:
					
					/** Início do ítem 3.5 **/
					
					agupamentoPorFuncao = agrupaPorFuncao(listaDeFuncionarios);
					
					/** Fim do ítem 3.5 **/
					break;
					
				case 5:
					
					/** Início do ítem 3.6 **/
					
					imprimiFuncionariosAgrupados(agupamentoPorFuncao);
					
					/** Fim do ítem 3.6 **/
					break;
				
				case 6:
					
					/** Início do ítem 3.8 **/
					
					verificaAniversarianteDoMes( listaDeFuncionarios);
					
					/** Fim do ítem 3.8 **/
					break;
						
				case 7:
					
					/** Início do ítem 3.9 **/
					
					encontraMaisVelho(listaDeFuncionarios);
					
					/** Fim do ítem 3.9 **/
					break;
						
				case 8:
					
					/** Início do ítem 3.10 **/
					
					imprimiFuncionariosOrdemAlfabetica(listaDeFuncionarios);
					
					/** Fim do ítem 3.10 **/
					break;
					
				case 9:
					
					/** Início do ítem 3.11 **/
					
					imprimiSalarioTotalFuncionarios(listaDeFuncionarios);
					
					/** Fim do ítem 3.11 **/
					break;
					
				case 10:
				
					/** Início do ítem 3.12 **/
					
					imprimiSalarioComBaseNoMinimo(listaDeFuncionarios);
				
					/** Fim do ítem 3.12 **/
					break;				
					
				case 11:
					
					break;
	
				default:
					
					CaixaDeMensagem.mostraMensagem("Informe uma opção válida", "Opção Inválida", 123, 80);
					
					break;
			}
			
		}while(opcao != 11);
		
	}
	
	private static void adicionaFuncionario(String nome, LocalDate dataDeNascimento, BigDecimal salario, String funcao, ArrayList<Funcionario> listaDeFuncionarios) {
		
		Funcionario fun = new Funcionario(nome, dataDeNascimento, salario, funcao);
		listaDeFuncionarios.add(fun);
		
	}
	
	private static void removeFuncionario( ArrayList<Funcionario> listaDeFuncionarios) {
		
		Integer op=1;
		
		do {
			
			String nome = CaixaDeMensagem.leString("Informe o nome do funcionário que deseja remover: ", "João"); 
			boolean removeu = false;
			
			for(int i = 0 ; i < listaDeFuncionarios.size(); i++)
		    {
				Funcionario p = listaDeFuncionarios.get(i);
	
		        if(p.getNome().equals(nome))
		        {
		        	removeu = listaDeFuncionarios.remove(p);  // Tentei usar o listaDeFuncionarios.removeIf(x -> x.getNome() == "João") e não consegui
	
		            break;
		        }
		    }
			
			if(!removeu) {
				op = CaixaDeMensagem.mostraOpcoes("O nome que você informou não consta na lista de Funcionário.\nDeseja inserir outro nome para a Busca?", 2,35);
			}
			else {
				op = 1;
			}
			
		}while(op==0);
	}
	
	private static void imprimiFuncionarios(ArrayList<Funcionario> listaDeFuncionarios) {
		
		String guardaFuncionarios = "";
		DateTimeFormatter formatadorBarra = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Locale localBrasil = new Locale("pt","BR");
		NumberFormat formatoBrasil = NumberFormat.getNumberInstance(localBrasil);
		
		for(Funcionario funcionario : listaDeFuncionarios)
		{
			guardaFuncionarios +=  "\nNome: "+funcionario.getNome() + ", Data de Nacimento: " + (funcionario.getDataDeNascimento()).format(formatadorBarra) + ", Salário: R$" + formatoBrasil.format(funcionario.getSalario()) + " e Função: " + funcionario.getFuncao() + "." ;
		}
		
		CaixaDeMensagem.mostraMensagem(guardaFuncionarios , "Lista de Funcionários", 15, 70);
	}
	
	private static void ajusteSalarial(ArrayList<Funcionario> listaDeFuncionarios) {
		
		BigDecimal ajuste = CaixaDeMensagem.leBigDecimal("Informe o valor do reajuste salarial - Digite o ajuste em Decimal, Ex: 0.3 para 30% de aumento", 2,50);
		
		for(Funcionario funcionario : listaDeFuncionarios)
		{
			funcionario.setSalario(funcionario.getSalario().multiply((new BigDecimal(1.0).add(ajuste))));
		}
	}
	
	private static Map<String , ArrayList<String>> agrupaPorFuncao(ArrayList<Funcionario> listaDeFuncionarios) {
		
		Map<String , ArrayList<String>> agupamentoPorFuncao = new TreeMap<String, ArrayList<String>>();
		
		for ( Funcionario x : listaDeFuncionarios) {
			
			ArrayList<String> atualizaLista = agupamentoPorFuncao.get(x.getFuncao());
			
			if ( atualizaLista == null ) {
				agupamentoPorFuncao.put(x.getFuncao(), atualizaLista = new ArrayList<String>());
			}
			
			atualizaLista.add(x.getNome());   
		}
		
		CaixaDeMensagem.mostraMensagem("Os Funcionários foram agrupados por função com sucesso.", "Agrupamento Concluído", 2,40);
		
		return (agupamentoPorFuncao);
	}
	
	private static void imprimiFuncionariosAgrupados(Map<String , ArrayList<String>> listaDeFuncionariosAgrupados) {
		
		if(!listaDeFuncionariosAgrupados.isEmpty()){
			
			String guardaFuncionariosAgrupados = "";
			
			for(String chave : listaDeFuncionariosAgrupados.keySet())
			{
				guardaFuncionariosAgrupados +=  chave + "	:	" + listaDeFuncionariosAgrupados.get(chave) + "\n" ;
				
			}
			
			CaixaDeMensagem.mostraMensagem(guardaFuncionariosAgrupados , "Funcionários Agrupados por Função", 10,35);
			
			listaDeFuncionariosAgrupados.clear();
		}
		else {
			CaixaDeMensagem.mostraMensagem("Você ainda não agrupou os funcionários, agrupe-os antes de imprimi-los.", "Precisa agrupar", 2,40);
		}
	}
	
	private static void verificaAniversarianteDoMes(ArrayList<Funcionario> listaDeFuncionarios) {
		
		Integer op=1;
		
		do {
			
			Integer mes = CaixaDeMensagem.leInteiro("Inserir o número do mês que deseja buscar(1 para Janeiro , 2 para Fevereiro ...)", 2,40);
			boolean removeu = false;
			
			if(removeu = mes >= 1 && mes<=12) {
				
				String guardaAniversariantes = "";
				LocalDate aux = LocalDate.of(2000,mes,1);
				
				for(Funcionario funcionario : listaDeFuncionarios)
				{
					if(((funcionario.getDataDeNascimento()).getMonthValue()) == mes)
					{				
						guardaAniversariantes +=  funcionario.getNome() + "\n";
					}
				} 
				
				CaixaDeMensagem.mostraMensagem(guardaAniversariantes , "Funcionários Aniversariantes do mês de "+aux.getMonth().name(),5,30);
			}
			
			if(!removeu) {
				op = CaixaDeMensagem.mostraOpcoes("O número do mês que você informou não é válido.\nDeseja inserir outro mês para a Busca?",2,35);
			}
			else {
				op = 1;
			}
			
		}while(op==0);
		
	}
	
	private static void encontraMaisVelho(ArrayList<Funcionario> listaDeFuncionarios){
		
		Funcionario oMaisVelho = new Funcionario();
		LocalDate hoje = LocalDate.now();
		oMaisVelho = listaDeFuncionarios.get(0);
		
		for(Funcionario funcionario : listaDeFuncionarios)
		{
			
			if((funcionario.getDataDeNascimento()).isBefore(oMaisVelho.getDataDeNascimento()))
			{
				oMaisVelho = funcionario;
			}
		}
		
		Period idade = Period.between(oMaisVelho.getDataDeNascimento(), hoje);
		
		CaixaDeMensagem.mostraMensagem( "Nome: " + oMaisVelho.getNome() +"\nIdade: "+ idade.getYears() + " anos. \n", "Funcionário mais velho", 5,30);

	}
	
	private static void imprimiFuncionariosOrdemAlfabetica(ArrayList<Funcionario> listaDeFuncionarios) {
		
		String guardaFuncionarios = "";
		ArrayList<Funcionario> listaDeFuncionariosOrdenada = new ArrayList<>(listaDeFuncionarios);
		
		Collections.sort(listaDeFuncionariosOrdenada, Comparator.comparing(Funcionario::getNome));
		
		for(Funcionario funcionarios : listaDeFuncionariosOrdenada)
		{
			guardaFuncionarios += funcionarios.getNome() + "\n";
		}
		
		CaixaDeMensagem.mostraMensagem(guardaFuncionarios , "Nome dos funcionário por ordem alfabética", 11,35);
		
	}
	
	private static void imprimiSalarioTotalFuncionarios(ArrayList<Funcionario> listaDeFuncionarios) {
		
		BigDecimal salarioTotal = new BigDecimal(0.0);
		Locale localBrasil = new Locale("pt","BR");
		NumberFormat formatoBrasil = NumberFormat.getNumberInstance(localBrasil);
		
		for(Funcionario funcionario : listaDeFuncionarios)
		{
			salarioTotal = salarioTotal.add(funcionario.getSalario());
		}
		
		CaixaDeMensagem.mostraMensagem("R$"+formatoBrasil.format(salarioTotal) , "Salário total de todos os funcionários", 2,35);
	}
	
	
	private static void imprimiSalarioComBaseNoMinimo(ArrayList<Funcionario> listaDeFuncionarios) {
		
		String guardaFuncionarios = "";
		BigDecimal salarioMinimo = new BigDecimal(1212.00);
		Locale localBrasil = new Locale("pt","BR");
		NumberFormat formatoBrasil = NumberFormat.getNumberInstance(localBrasil);
		
		for(Funcionario funcionario : listaDeFuncionarios)
		{
			guardaFuncionarios += "O salário de " + funcionario.getNome() + " equivale a: " + formatoBrasil.format((funcionario.getSalario()).divide(salarioMinimo,3,RoundingMode.UP)) + " salários mínimos.\n";
		}
		
		CaixaDeMensagem.mostraMensagem(guardaFuncionarios , "Salário dos funcionários em salários mínimos", 11,35);
	}
	
}