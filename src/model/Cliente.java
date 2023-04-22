package model;

public class Cliente {

	public int senha;
	public String nome;
	
	@Override
	public String toString() {
		return ("[Nome: " + nome + ", senha: " + senha + "]");
	}
	
}
