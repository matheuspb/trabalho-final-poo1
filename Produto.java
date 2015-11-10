public class Produto {
	
	private String nome;
	private String marca;
	private String tipo;
	private double preco;
	
	public Produto(String nome, String marca, String tipo, double preco) {
		super();
		this.nome = nome;
		this.marca = marca;
		this.tipo = tipo;
		this.preco = preco;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}

}
