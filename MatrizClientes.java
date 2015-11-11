import java.util.Arrays;

public class MatrizClientes {
	
	private Cliente[][] matriz;

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
	
	public int quantosCompraram(String nome) {
		/*
		 * item 1:
		 * retorna quantos clientes da matriz compraram um determinado produto
		 */
		int quantidade = 0;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				Produto[] produtosComprados = matriz[i][j].getProdutos();
				for (int k = 0; k < produtosComprados.length; k++) {
					if (produtosComprados[k].getNome().equals(nome)) {
						quantidade++;
						break;
					}
				}
			}
		}
		return quantidade;
	}
	
	public String quemPossue(String nome) {
		/*
		 * item 2:
		 * retorna o primeiro cliente que contem determinado produto,
		 * se ninguem comprou, retorna uma mensagem dizendo isso
		 */
		Produto[] produtosComprados;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				produtosComprados = matriz[i][j].getProdutos();
				for (int k = 0; k < produtosComprados.length; k++) {
					if (produtosComprados[k].getNome().equals(nome))
						return matriz[i][j].getNome();
					// retorna nome do primeiro cliente que comprou o produto
				}
			}
		}
		// Ninguem comprou :
		return "Ninguem comprou " + nome;
	}

	public boolean naoExisteProduto(String nome) {
		/*
		 * item 3:
		 * retorna true se nenhum cliente contem um determinado produto,
		 * retorna false se algum cliente contem o produto.
		 */
		if (quantosCompraram(nome) == 0)
			return true;
		else
			return false;
	}
	
	public int quantidadeTotalClientes() {
		/*
		 * item 4:
		 * retorna a quantidade total de clientes contidos na matriz
		 */
		return matriz.length * matriz[0].length;
	}
	
	public int quantidadeClientesEspeciais() {
		/*
		 * item 4:
		 * retorna a quantidade de clientes especiais contidos na matriz
		 */
		int quantidade = 0;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				if (matriz[i][j] instanceof ClienteEspecial)
					quantidade++;
			}
		}
		return quantidade;
	}
	
	public void ordenarMatriz() {
		/*
		 * item 5:
		 * ordena a matriz alfabeticamente
		 */
		Cliente[] clientes = new Cliente[matriz.length*matriz[0].length];
		int indice = 0;
		// trasnforma a matriz num array
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				clientes[indice] = matriz[i][j];
				indice++;
			}
		}
		// ordena o array auxiliar
		Arrays.sort(clientes); // utiliza o compareTo da classe Cliente
		indice = 0;
		// coloca os elementos de volta na matriz, ordenados
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				matriz[i][j] = clientes[indice];
				indice++;
			}
		}
	}
	
}
