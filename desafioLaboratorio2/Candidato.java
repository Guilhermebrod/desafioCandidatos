package desafioLaboratorio2;

public class Candidato {
	
	String nome;
	String partido;
	int intencoesVoto;
	
	public Candidato(String nome, String partido, int intencoesVoto) {
		
		this.nome = nome;
		this.partido = partido;
		this.intencoesVoto = intencoesVoto;
		
	}
	
	//getter nome
	public String getNome() {
		
		return nome;
		
	}
	
	//setter nome
	public void setNome(String nome) {
		
		this.nome = nome;
		
	}
	
	//getter partido
	public String getPartido() {
		
		return partido;
		
	}
	
	//setter partido
	public void setPartido(String partido) {
		
		this.partido = partido;
		
	}
	
	//getter intencoes
	public int getIntencoes() {
		
		return intencoesVoto;
		
	}
	
	//setter intencoes
	public void setIntencoes(int intencoesVoto) {
		
		this.intencoesVoto = intencoesVoto;
		
	}
	
	public String toString() {
		
		return "Nome do candidato: " + nome + " \t Partido: " + partido + " \t Intencoes de voto: " + intencoesVoto + " \t";
		
	}

}
