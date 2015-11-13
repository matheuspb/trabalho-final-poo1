public class Controle {
	
	public static void main(String[] args) {
		
		Visao visao = new Visao();
		
		int linhas = visao.recebeInt("Quantas linhas tem a matriz  de clientes ?");
		int colunas = visao.recebeInt("Quantas colunas tem a matriz de clientes ?");
		
		MatrizClientes matriz = new MatrizClientes(linhas, colunas);
		
		for (int i = 0; i < linhas; i++) {
			for (int j = 0; j < colunas; j++) {
				String adicionarCliente = visao.recebeString("Quer adicionar" +
						" cliente na posicao " + i + " " + j + " ?(s/n)");
				if (!adicionarCliente.equals("s"))
					continue;
				
				Cliente novoCliente = new Cliente();
				ClienteEspecial novoEspecial = new ClienteEspecial();
				
				String nomeCliente = visao.recebeString("Qual o nome do cliente" +
						" na posicao " + i + " " + j + " ?");
				novoCliente.setNome(nomeCliente);
				
				int numDeProdutos = visao.recebeInt("Quantos produtos ele comprou ?");
				Produto[] novosProdutos = new Produto[numDeProdutos];
				
				double precoTotal = 0;
				boolean especial = false;
				
				for (int k = 0; k < novosProdutos.length; k++) {
					String nomeProduto = visao.recebeString("Qual o nome do " +
							"produto " + (k+1) + " ?");
					String marcaProduto = visao.recebeString("Qual a marca do " +
							"produto " + (k+1) + " ?");
					String tipoProduto = visao.recebeString("Qual o tipo do " +
							"produto " + (k+1) + " ?");
					double precoProduto = visao.recebeDouble("Qual o preco do " +
							"produto " + (k+1) + " ?");
					precoTotal += precoProduto;
					
					if (especial) {
						// se for cliente especial aplica desconto
						precoProduto *= novoEspecial.getDesconto();
					}
					
					Produto novoProduto = new Produto(nomeProduto, marcaProduto,
							tipoProduto, precoProduto);
					novosProdutos[k] = novoProduto;
					
					if (precoTotal > 100 && !especial) {
						// ultrapassou 100 reais, e ainda nao e' especial
						// Transforma em ClienteEspecial com o construtor
						novoEspecial = new ClienteEspecial(novoCliente, 0.1);
						especial = true;
					}
				}
				if (especial) {
					novoEspecial.setProdutos(novosProdutos);
					matriz.colocaCliente(novoEspecial, i, j);
				} else {
					novoCliente.setProdutos(novosProdutos);
					matriz.colocaCliente(novoCliente, i, j);
				}
			}
		}
		
		String menu = "Digite o numero da acao que voce quer realizar:\n\n" +
				"1. Pesquisar quantos clientes compraram um produto\n" +
				"2. Pesquisar a existencia de um produto, e se existir, quem o possue\n" +
				"3. Pesquisar a inexistencia de um produto\n" +
				"4. Informa a quantidade total de clientes, e quantos desses sao especiais\n" +
				"5. Ordena a matriz alfabeticamente\n" +
				"6. Mostra os nomes dos clientes na matriz\n\n" +
				"7. Fecha o programa\n\n";
		
		int acao = visao.recebeInt(menu);
		while (acao != 7) {
			if (acao == 1) {
				String nome = visao.recebeString("Qual produto voce quer pesquisar ?");
				visao.mostraString(matriz.quantosCompraram(nome) + 
						" pessoas compraram " + nome);
			} else if (acao == 2) {
				String nome = visao.recebeString("Qual produto voce quer pesquisar ?");
				visao.mostraString(matriz.quemPossue(nome) + " comprou " + nome);
			} else if (acao == 3) {
				String nome = visao.recebeString("Qual produto voce quer pesquisar ?");
				if (matriz.naoExisteProduto(nome))
					visao.mostraString("Este produto NAO existe nos arrays");
				else
					visao.mostraString("Este produto existe nos arrays");
			} else if (acao == 4) {
				String mensagem = "Existem " + matriz.quantidadeTotalClientes() +
						" clientes no total,\n dos quais, " + matriz.quantidadeClientesEspeciais() +
						" sao especiais.";
				visao.mostraString(mensagem);
			} else if (acao == 5) {
				matriz.ordenarMatriz();
				visao.mostraString("Matriz ordenada");
			} else if (acao == 6) {
				String mensagem = "";
				for (int i = 0; i < linhas; i++) {
					for (int j = 0; j < colunas; j++) {
						mensagem += matriz.pegaCliente(i, j).getNome() + ", ";
					}
					mensagem += "\n";
				}
				visao.mostraString(mensagem);
			}
			acao = visao.recebeInt(menu);
		}
		
	}

}
