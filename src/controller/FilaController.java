package controller;

import br.com.serialexperimentscarina.filaobject.FilaObject;
import model.Cliente;

public class FilaController {
	private int numChamados = 0;
	
	public void insere(FilaObject fila, String nome, int senha) {
		Cliente cliente = new Cliente();
		cliente.nome = nome;
		cliente.senha = senha;
		fila.insert(cliente);
	}
	
	public Cliente remove(FilaObject fila) throws Exception {
		return (Cliente) fila.remove();
	}
	
	public String chamado(FilaObject fila, FilaObject filaPrioritarios) throws Exception {
		numChamados++;
		if ((numChamados % 4 == 1 || fila.isEmpty()) && !filaPrioritarios.isEmpty()) {
			Cliente clienteAtendido = remove(filaPrioritarios);
			return ("O cliente " + clienteAtendido + " da fila prioritaria foi atendido.");
		}
		if (!fila.isEmpty()) {
			Cliente clienteAtendido = remove(fila);
			return ("O cliente " + clienteAtendido + " da fila normal foi atendido.");
		}
		
		return ("Ambas filas vazias, nenhum chamado foi feito");
	}

}
