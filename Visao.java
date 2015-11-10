import javax.swing.JOptionPane;

public class Visao {
	
	public void mostraDouble(double n) {
		JOptionPane.showMessageDialog(null, n);
	}
	
	public void mostraString(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
	}
	
	public int recebeInt(String mensagem) {
		return Integer.parseInt(JOptionPane.showInputDialog(mensagem));
	}
	
	public double recebeDouble(String mensagem) {
		return Double.parseDouble(JOptionPane.showInputDialog(mensagem));
	}
	
	public String recebeString(String mensagem) {
		return JOptionPane.showInputDialog(mensagem);
	}
	
}
