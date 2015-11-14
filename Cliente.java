import java.util.Arrays;

public class Cliente implements Comparable<Cliente> {
	
	private String nome;
	private Produto[] produtos;
	
	public Cliente() {
		super();
	}

	public Cliente(String nome, Produto[] produtos) {
		super();
		this.nome = nome;
		this.produtos = produtos;
	}
	
	@Override
	public int compareTo(Cliente cliente) {
		// usado para ordenar um array de clientes pelo nome alfabeticamente
		return this.nome.compareTo(cliente.getNome());
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Produto[] getProdutos() {
		return produtos;
	}
	public void setProdutos(Produto[] produtos) {
		this.produtos = produtos;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", produtos="
				+ Arrays.toString(produtos) + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Cliente))
			return false;
		Cliente other = (Cliente) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (!Arrays.equals(produtos, other.produtos))
			return false;
		return true;
	}
	
}
