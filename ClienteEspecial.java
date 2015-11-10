public class ClienteEspecial extends Cliente{
	
	private double desconto;

	public ClienteEspecial() {
		super();
	}

	public ClienteEspecial(String nome, Produto[] produtos, double desconto) {
		super(nome, produtos);
		this.desconto = desconto;
	}

	public ClienteEspecial(Cliente cliente, double desconto) {
		// transforma um cliente normal em cliente epecial, e aplica o desconto
		super(cliente.getNome(), cliente.getProdutos());
		this.desconto = desconto;
		this.atualizarPrecos();
	}
	
	public double getDesconto() {
		return desconto;
	}
	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}
	
	public void atualizarPrecos() {
		// atualiza os precos aplicando o desconto
		for (int i = 0; i < this.getProdutos().length; i++) {
			double precoAtual = this.getProdutos()[i].getPreco();
			double novoPreco = precoAtual * (1 - desconto);
			this.getProdutos()[i].setPreco(novoPreco);
		}
	}
	
}
