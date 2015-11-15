import java.util.Arrays;

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
		// transforma um cliente normal em cliente epecial
		super(cliente.getNome(), cliente.getProdutos());
		this.desconto = desconto;
	}

	public double getDesconto() {
		return this.desconto;
	}

	@Override
	public String toString() {
		return "ClienteEspecial [desconto=" + desconto + ", getNome()="
				+ getNome() + ", getProdutos()="
				+ Arrays.toString(getProdutos()) + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof ClienteEspecial))
			return false;
		ClienteEspecial other = (ClienteEspecial) obj;
		if (Double.doubleToLongBits(desconto) != Double
				.doubleToLongBits(other.desconto))
			return false;
		return true;
	}
	
}
