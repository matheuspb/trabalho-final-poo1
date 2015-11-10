public class Controle {
	
	public static void main(String[] args) {
		
		Produto pao = new Produto("pao", "wickbold", "leite", 5);
		Produto leite = new Produto("leite", "tirol", "integral", 2);
		Produto[] produtos = new Produto[2];
		produtos[0] = pao;
		produtos[1] = leite;
		Cliente matheus = new Cliente("matheus", produtos);
		ClienteEspecial matheusE = new ClienteEspecial(matheus, 0.1);
		System.out.println(matheusE.getProdutos()[0].getPreco());
		System.out.println(matheusE.getProdutos()[1].getPreco());
		
	}

}
