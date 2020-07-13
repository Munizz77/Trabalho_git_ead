package iftm;

import java.util.ArrayList;




import gui.Janela;
import tipos.ItemPilha;


		public class Principal {
			private ArrayList<ItemPilha>ListaSessoes;
			
			
			
			
			//Construtor
			public Principal() {
				ListaSessoes = new ArrayList();
				
				
				Janela jan = new Janela(ListaSessoes);

			}
			//Todo o sistema vai ser inicializado a partir deste metodo
			public static void main (String[] args) {
				Principal app = new Principal();
				
				
				
			}
			
			
			
				

		


	}


