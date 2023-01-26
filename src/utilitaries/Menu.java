package utilitaries;

public class Menu {
	
	public static int menuPrincipal() {
		
		String menu = "Opções do Teste Prático (já foram inseridos todos os funcionários)\n\n"
					+ "1 - Remover funcionário (Digite: 'João',  item 3.2)\n"
					+ "2 - Imprimir todas as informações de todos os funcionários (item 3.3)\n"
					+ "3 - Ajustar salário dos funcionários (Digite 0.1, item 3.4)\n"
					+ "4 - Agrupar os Funcionários por Funcão (item 3.5)\n"
					+ "5 - Imprimir os funcionários agrupados por função (item 3.6)\n"
					+ "6 - Imprimir os funcionários que fazem aniversário em um determinado mês (Digite 10 e depois da exibição do resultado digite 12, item 3.8)\n"
					+ "7 - Imprimir o funcionários mais velho (item 3.9)\n"
					+ "8 - Imprimir os funcionários por ordem alfabética (item 3.10)\n"
					+ "9 - Imprimir o total  total dos salários dos funcionários (item 3.11)\n"
					+ "10 - Imprimir os salários dos funcionários em salários mínimos (item 3.12)\n"
					+ "11 - Sair\n";
		
		return CaixaDeMensagem.leInteiro(menu+"\nInforme uma opção", 15, 70);
	}
	
}
