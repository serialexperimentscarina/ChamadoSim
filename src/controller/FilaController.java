package controller;

import br.com.serialexperimentscarina.filaobject.FilaObject;
import model.Cliente;

public class FilaController {
	private int numChamados = 0;
	
	// Método de inserir um novo elemento na fila
	public void insere(FilaObject fila, String nome, int senha) {
		Cliente cliente = new Cliente();
		cliente.nome = nome;
		cliente.senha = senha;
		fila.insert(cliente);
	}
	
	// Método de remover o primeiro elemento da fila, que será atendido. A fila não pode estar vazia
	public Cliente remove(FilaObject fila) throws Exception {
		return (Cliente) fila.remove();
	}
	
	// Método de chamado
	public String chamado(FilaObject fila, FilaObject filaPrioritarios) throws Exception {
		
		// Fazer 3 chamadas prioritárias para 1 da fila não prioritária
		numChamados++;
		if ((numChamados % 4 != 0 || fila.isEmpty()) && !filaPrioritarios.isEmpty()) {
			Cliente clienteAtendido = remove(filaPrioritarios);
			return ("O cliente " + clienteAtendido + " da fila prioritaria foi atendido.");
		}
		// Se não houver prioritários, já se deve chamar dos não prioritários
		if (!fila.isEmpty()) {
			Cliente clienteAtendido = remove(fila);
			return ("O cliente " + clienteAtendido + " da fila normal foi atendido.");
		}
		
		// Se não houver ninguém nas 2 filas, deve-se gerar um aviso
		return ("Ambas filas vazias, nenhum chamado foi feito");
	}

}
