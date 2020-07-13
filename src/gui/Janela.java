package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;




import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import tipos.ItemPilha;



public class Janela extends JFrame {
	private JLabel lblNome, lblCodigoBarras, lblPreco, lblPosicao;
	private JTextField txtNome, txtCodigoBarras, txtPreco, txtPosicao;
	private JComboBox cmbLocalDaMassagem, cmbDuracao;
	private JButton btnEmpilhar, btnDesempilhar;

	// Necessários para criar uma tabela
	private JScrollPane scroll;
	private JTable tabela;
	private DefaultTableModel dadosTabela;

	private ArrayList<ItemPilha> ListaConsultas;


	public Janela(ArrayList<ItemPilha> lista) {

		
		ListaConsultas = lista;

		
		setTitle("Pilha de Itens");
		setSize(800, 500); 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null); 

		criaComponentes();
		criaAcoes();

		setVisible(true);
	}

	private void criaComponentes() {
		

		
        btnEmpilhar = new JButton("Empilhar");
        btnEmpilhar.setBounds(300, 150, 150, 25);
		add(btnEmpilhar);
	

		
		lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 65,50, 25);
		add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(50, 65, 150, 25);
		add(txtNome);
		
		
		lblCodigoBarras = new JLabel("Codigo de Barras");
		lblCodigoBarras.setBounds(250, 65,150, 25);
		add(lblCodigoBarras);
		
		txtCodigoBarras = new JTextField();
		txtCodigoBarras.setBounds(355, 65, 150, 25);
		add(txtCodigoBarras);
		
		lblPreco = new JLabel("Preço");
		lblPreco.setBounds(550, 65,150, 25);
		add(lblPreco);
		
		txtPreco = new JTextField();
		txtPreco.setBounds(590, 65, 150, 25);
		add(txtPreco);
		

		// TABELA

		dadosTabela = new DefaultTableModel();
		dadosTabela.addColumn("Nome");
		dadosTabela.addColumn("Preço");
		dadosTabela.addColumn("Codigo de barras");
		
		

		tabela = new JTable(dadosTabela);

		scroll = new JScrollPane(tabela);
		scroll.setBounds(80, 250, 600, 150);
		add(scroll);

		encheLista();
		
		btnDesempilhar = new JButton("Desempilhar");
		btnDesempilhar.setBounds(300, 420, 150, 25);
	    add(btnDesempilhar);
			

	}

	private void criaAcoes() {
		// Salvar um novo pedido na lista
		btnEmpilhar.addActionListener(new ActionListener() {
			

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String nome = txtNome.getText();
				String codigoBarras = txtCodigoBarras.getText();
				double preco = Double.parseDouble(txtPreco.getText());
				
			

				// Criar um novo Objeto do cadastro
				ItemPilha lista = new ItemPilha(nome, codigoBarras, preco);

				// Adicionar este novo pedido na lista de pedidos
				
				ListaConsultas.add(lista);
				
				listaParaTabela();

              
				try {

					FileWriter arquivo = new FileWriter("src/DadosDaPilha.txt", true);
					PrintWriter print = new PrintWriter(arquivo);
					print.println(nome);
					print.println(codigoBarras);
					print.println(preco);
		
					
					print.flush();
					print.close();

				}

				catch (IOException ex) {
					ex.printStackTrace();
					System.out.println("Lago");
				}
				JOptionPane.showMessageDialog(null,
						nome+ " empilhado com sucesso" + "\n Salvo no arquivo.");

			}

		});

		// Remove um pedido
		btnDesempilhar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				//Removendo da lista
				ListaConsultas.remove(ListaConsultas.get(ListaConsultas.size()-1));
			 
				//Removendo da tabela
				dadosTabela.removeRow(dadosTabela.getRowCount()-1);	
				JOptionPane.showMessageDialog(null, "Ultimo elemento da pilha retirado com sucesso");


			}
			
			
		});
		
		
	}

	public void listaParaTabela() {

		// Limpar a tabela antes

		for (int i = dadosTabela.getRowCount() - 1; i >= 0; i--) {
			dadosTabela.removeRow(i);
		}

		for (int i = 0; i < ListaConsultas.size(); i++) {
			// Pega o pedido atual da lista
			ItemPilha p = ListaConsultas.get(i);

			String[] linha = new String[4];
			linha[0] = p.getNome();
			linha[1] = p.getCodigoBarras();
			linha[2] = p.getPreco() + "";
	
			
			dadosTabela.addRow(linha);

		}
	}
	
	

	private void encheLista() {

		ItemPilha ppp = new ItemPilha("Panela de Pressão","547894137748", 50);
		ItemPilha ppp1 = new ItemPilha("Desodorante Rexona Men","1562384823", 25);

		

		ListaConsultas.add(ppp);
		ListaConsultas.add(ppp1);
		listaParaTabela();

	}

}
