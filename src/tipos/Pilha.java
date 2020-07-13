package tipos;

import java.util.EmptyStackException;

public interface Pilha {
		
		public Object desempilhar() throws Exception;
		
		public  Object olharTopo() throws Exception;
		
		public boolean estaVazia();
		
		public boolean estaCheia();
		
		public int pegarTamanho();

		public void empilhar(Object valor) throws Exception;

		void empilhar();

	    
	


}


