package view;

import javax.swing.JOptionPane;

import br.com.serialexperimentscarina.filaobject.FilaObject;

public class Principal {

	public static void main(String[] args) {
		FilaObject fila = new FilaObject();
		FilaObject filaPrioritarios = new FilaObject();
		int senha = 0, senhaPrioritarios = 0;
		String opc = "";
		
		try {
			do {
				opc = JOptionPane.showInputDialog("Menu : \n1 - Nova senha; \n2 - Nova senha prioritaria; \n3 - Chamar senha; \n4 - Encerrar");
				switch (opc) {
					case "1":
						break;
					case "2":
						break;
					case "3":
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
