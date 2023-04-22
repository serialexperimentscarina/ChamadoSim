package view;

import java.awt.HeadlessException;

import javax.swing.JOptionPane;

import br.com.serialexperimentscarina.filaobject.FilaObject;
import controller.FilaController;
import model.Cliente;

public class Principal {

	public static void main(String[] args) {
		FilaObject fila = new FilaObject();
		FilaObject filaPrioritarios = new FilaObject();
		FilaController filaCont = new FilaController();
		int senha = 0, senhaPrioritarios = 0;
		String opc = "", nome = "";
		
		try {
			do {
				opc = JOptionPane.showInputDialog("Menu : \n1 - Nova senha normal; \n2 - Nova senha prioritaria; \n3 - Realizar chamado; \n4 - Encerrar");
				switch (opc) {
					case "1":
						nome = JOptionPane.showInputDialog("Digite o nome do cliente: ");
						senha++;
						Cliente cliente = new Cliente();
						cliente.nome = nome;
						cliente.senha = senha;
						filaCont.insere(fila, nome, senha);
						JOptionPane.showMessageDialog(null, "O cliente " + cliente + " foi adicionado na fila.");
						break;
					case "2":
						nome = JOptionPane.showInputDialog("Digite o nome do cliente: ");
						senhaPrioritarios++;
						Cliente clienteP = new Cliente();
						clienteP.nome = nome;
						clienteP.senha = senhaPrioritarios;
						filaCont.insere(filaPrioritarios, nome, senhaPrioritarios);
						JOptionPane.showMessageDialog(null, "O cliente " + clienteP + " foi adicionado na fila de prioritarios.");
						break;
					case "3":
						try {
							JOptionPane.showMessageDialog(null, filaCont.chamado(fila, filaPrioritarios));
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;
					case "4": 
						JOptionPane.showMessageDialog(null, "Encerrando execução.");
						break;
					default: 
						JOptionPane.showMessageDialog(null, "Opção inválida!");
						break;
					}
			} while (!opc.equals("4"));
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Encerrando execução.");
		}
		
	}

}
