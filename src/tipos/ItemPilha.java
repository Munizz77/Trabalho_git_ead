package tipos;

import java.util.EmptyStackException;

public class ItemPilha {

		
		private ItemPilha proximo;
		private Object valor;
		
		private String nome;
		private String codigoBarras;
		private double preco;
		
		
	
		
		
		public ItemPilha(ItemPilha proximo, Object valor) {
			this.proximo = proximo;
			this.valor = valor;
		
		}
		
		public ItemPilha(String nome, String codigoBarras, double preco) {
			this.nome = nome;
			this.codigoBarras = codigoBarras;
			this.preco = preco;
		}




		public ItemPilha getProximo() {
			return proximo;
		}




		public void setProximo(ItemPilha proximo) {
			this.proximo = proximo;
		}




		public Object getValor() {
			return valor;
		}




		public void setValor(Object valor) {
			this.valor = valor;
		}




		public String getNome() {
			return nome;
		}




		public void setNome(String nome) {
			this.nome = nome;
		}




		public String getCodigoBarras() {
			return codigoBarras;
		}




		public void setCodigoBarras(String codigoBarras) {
			this.codigoBarras = codigoBarras;
		}




		public double getPreco() {
			return preco;
		}




		public void setPreco(double preco) {
			this.preco = preco;
		}

	
		
	

}
