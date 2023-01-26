package utilitaries;

import java.math.BigDecimal;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CaixaDeMensagem {


	public static Integer leInteiro(String mensagem, Integer largura, Integer altura) {
		return Integer.parseInt(JOptionPane.showInputDialog(new JScrollPane(new JTextArea(mensagem, largura, altura))));
	}
	
	public static BigDecimal leBigDecimal(String mensagem, Integer largura, Integer altura) {
		return new BigDecimal(JOptionPane.showInputDialog(new JScrollPane(new JTextArea(mensagem, largura, altura))));
	}
	 
	public static String leString(String mensagem, String valorInicial) {
		return JOptionPane.showInputDialog(mensagem, valorInicial);
	}
	
	public static void mostraMensagem(String mensagem, String titulo, Integer largura, Integer altura) {
		JOptionPane.showMessageDialog(null, new JScrollPane(new JTextArea(mensagem, largura, altura)), titulo, -1);
	}
	
	public static Integer mostraOpcoes(String mensagem, Integer largura, Integer altura) {
		return JOptionPane.showConfirmDialog(null, new JScrollPane(new JTextArea(mensagem, largura, altura))); 
	}
		
}
