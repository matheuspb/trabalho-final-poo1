public class MatrizClientes {
	
	Cliente[][] matriz;

	public MatrizClientes(int linhas, int colunas) {
		super();
		matriz = new Cliente[linhas][colunas];
	}
	
	public void colocaCliente(Cliente cliente, int linha, int coluna) {
		matriz[linha][coluna] = cliente;
	}
	
	public Cliente pegaCliente(int linha, int coluna) {
		return matriz[linha][coluna];
	}
	
}
