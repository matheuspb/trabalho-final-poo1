public class Cliente {
	
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
	
}
