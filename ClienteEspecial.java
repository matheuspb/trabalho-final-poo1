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
	}

	public double getDesconto() {
		return this.desconto;
	}
	
}
