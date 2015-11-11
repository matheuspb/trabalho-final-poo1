public class Controle {
	
	public static void main(String[] args) {
		
		Visao visao = new Visao();
		
		int linhas = visao.recebeInt("Quantas linhas tem a matriz  de clientes ?");
		int colunas = visao.recebeInt("Quantas colunas tem a matriz de clientes ?");
		
		MatrizClientes matriz = new MatrizClientes(linhas, colunas);
		
		for (int i = 0; i < linhas; i++) {
			for (int j = 0; j < colunas; j++) {
				Cliente novoCliente = new Cliente();
				String nomeCliente = visao.recebeString("Qual o nome do cliente" +
						" na posicao " + i + " " + j + " ?");
				novoCliente.setNome(nomeCliente);
				int numDeProdutos = visao.recebeInt("Quantos produtos ele comprou ?");
				Produto[] novosProdutos = new Produto[numDeProdutos];
				for (int k = 0; k < novosProdutos.length; k++) {
					String nomeProduto = visao.recebeString("Qual o nome do " +
							"produto " + (k+1) + " ?");
					String marcaProduto = visao.recebeString("Qual a marca do " +
							"produto " + (k+1) + " ?");
					String tipoProduto = visao.recebeString("Qual o tipo do " +
							"produto " + (k+1) + " ?");
					double precoProduto = visao.recebeDouble("Qual o preco do " +
							"produto " + (k+1) + " ?");
					Produto novoProduto = new Produto(nomeProduto, marcaProduto,
							tipoProduto, precoProduto);
					novosProdutos[k] = novoProduto;
				}
				novoCliente.setProdutos(novosProdutos);
				matriz.colocaCliente(novoCliente, i, j);
			}
		}
		matriz.ordenarMatriz();
		for (int i = 0; i < linhas; i++) {
			for (int j = 0; j < colunas; j++) {
				System.out.println(matriz.pegaCliente(i, j).getNome());
			}
		}
		
	}

}
