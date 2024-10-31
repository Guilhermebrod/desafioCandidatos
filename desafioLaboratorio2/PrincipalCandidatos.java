package desafioLaboratorio2;

import java.util.Random;

public class PrincipalCandidatos {

	public static void main(String[] args) {
		
		Random random = new Random();
		
		int rand = random.nextInt(1, 100);

		Candidato[] candidatos = new Candidato[rand];
		
		String[] opcoesCandidatos = {
				"Pedro", "Rafael", "Luiz", "Ciro", "Barbara", "Guilherme", "Mateus", "Bernardo", "Sergio", "Omar", "Eduarda", "Jairo", "Lorenzo", "Vinicius", "Sheila"
				};
		
		String[] opcoesPartidos = {
				"PDE","PTL","PS","PA","PCE","PFD","PFL","PPL","PQP","PO"
				};

		//a array candidatos é preenchida
		for(int x = 0; x < candidatos.length; x++) {
			
			candidatos[x] = new Candidato(
					opcoesCandidatos[random.nextInt(0, 14)],
					opcoesPartidos[random.nextInt(0, 9)],
					//as intencoes sao criadas aleatoriamente diretamente na criação dos objetos
					random.nextInt(50, 500));
			
		}
		
		System.out.println("LISTA DE CANDIDATOS NAO ORDENADA:\n");
	
		//impressao dos objetos nao ordenados
		for(int y = 0; y < candidatos.length; y++) {
			
			System.out.println(candidatos[y].toString());
			
		}
		
		System.out.println("\nLISTA DE CANDIDATOS ORDENADA:\n");
		
		//os metodos de ordenação são chamados na ordem correta
		candidatos = ordenaCandidatosPorNome(candidatos);
		
		candidatos = ordenaCandidatosPorPartido(candidatos);
		
		candidatos = ordenaCandidatosPorVotos(candidatos);
		
		//a array agora ordenada é impressa
		for(int y = 0; y < candidatos.length; y++) {
			
			System.out.println(candidatos[y].toString());
			
		}
		
		//leio um nome do teclado a ser procurado na array
		Teclado teclado = new Teclado();
		
		System.out.println("\nInsira um nome a ser buscado na array: ");
		
		String candidato_a_ser_pesquisado = teclado.leString();
		
		int resultado = pesquisaBinariaCandidatos(candidatos, candidato_a_ser_pesquisado);
		
		if(resultado == -1) {
			
			System.out.println("\nNao ha candidato com o nome " + candidato_a_ser_pesquisado + ".");
			
		}
		else {
			
			System.out.println("\nO candidato " + candidato_a_ser_pesquisado + " esta na posicao " + resultado + " do array.");
			
		}
		
	}
	
	public static boolean ehMaiorQue(String palavra1, String palavra2) {
		
		int[] numeros = {
				1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11,12,13,
				14,15,16,17,18,19,20,21,22,23,24,25,26};
			
		char[] alfabeto = {
		    'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 
		    'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
		};
		
		char[] ALFABETO = {
		    'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 
		    'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
		};
		
		int[] plv1 = new int[palavra1.length()];
		int[] plv2 = new int[palavra2.length()];
		
		//transforma as strings em arrays de numeros
		for(int x = 0; x < palavra1.length(); x++) {
			
			for(int y = 0; y < 26; y++) {
				
				//se a letra for igual a uma das arrays alfabeto e ALFABETO a letra é convertida em numero usando a posicao da array alafabeto
				if(palavra1.charAt(x) == alfabeto[y] || palavra1.charAt(x) == ALFABETO[y] ) {
					
					plv1[x] = numeros[y];
					
				}
				
			}
			
		}
		
		for(int x = 0; x < palavra2.length(); x++) {
			
			for(int y = 0; y < 26; y++) {
				
				if(palavra2.charAt(x) == alfabeto[y] || palavra2.charAt(x) == ALFABETO[y] ) {
					
					plv2[x] = numeros[y];
					
				}
				
			}
			
		}
		
		String menor_palavra;
		
		//descubro a menor palavra para quando fazer um looping utilizar a menor palavra como numero de vezes que o loop sera percorrido para nao haver exceções de ultrapassar o limite da array
		if(palavra1.length() < palavra2.length()) {
			
			menor_palavra = palavra1;
			
		}
		
		else {
			
			menor_palavra = palavra2;
			
		}
		
		//aqui se checa se a letra(agora convetida em numero) é maior que a outra, caso sim é retornado true, caso nao o loop acaba e é retornado false
		for (int i = 0; i < menor_palavra.length(); i++) {
			   
			if(plv1[i] > plv2[i]) {
				
				return true;
				
			}
			
			else if(plv1[i] == plv2[i]){
				
				continue;
				
			}
			
			else {
				
				break;
				
			}
			
			}
		
		return false;
		
	}
	
	//metodo de ordenação usando inserção direta por nome
	public static Candidato[] ordenaCandidatosPorNome(Candidato[] candidatos) {
	
		for(int i = 1; i < candidatos.length; i++) {

			int j = i;
			Candidato B = candidatos[i];
			
			while ((j > 0) && (ehMaiorQue(candidatos[j-1].getNome(), B.getNome()))) {
				
				candidatos[j] = candidatos[j-1];
				--j;
			}
			candidatos[j] = B;
		}

		return candidatos;
		
	}
	
	//metodo de ordenação usando inserção direta por partido
	public static Candidato[] ordenaCandidatosPorPartido(Candidato[] candidatos) {
		
		for(int i = 1; i < candidatos.length; i++) {

			int j = i;
			Candidato B = candidatos[i];
			
			while ((j > 0) && (ehMaiorQue(candidatos[j-1].getPartido(), B.getPartido())) && (candidatos[j-1].getNome() == B.getNome())) {
				
				candidatos[j] = candidatos[j-1];
				--j;
			}
			candidatos[j] = B;
		}

		return candidatos;
		
	}
	
	//metodo de ordenacao utilizando selecao direta por votos
	public static Candidato[] ordenaCandidatosPorVotos(Candidato[] candidatos) {
		
		int min = 0;
		
		for(int i = 0; i < candidatos.length; i++) {
			
			min = i; //minimo inicial
			
			for(int j = i + 1; j < candidatos.length; j++) {
				
				if((candidatos[j].getIntencoes() < candidatos[min].getIntencoes()) && (candidatos[j].getPartido() == candidatos[min].getPartido()) && (candidatos[j].getNome() == candidatos[min].getNome())) {
					
					min = j;
					
				}
				
			}
			
			Candidato T = candidatos[i];
			
			candidatos[i] = candidatos[min];
			
			candidatos[min] = T;

		}
		
		return candidatos;
		
	}
	
	//metodo de pesquisa binaria por nome
	public static int pesquisaBinariaCandidatos(Candidato[] candidatos, String nome) {
		
		int inf = 0; int sup = candidatos.length - 1;
		
		while(inf <= sup) {
			
			int med = (inf + sup) / 2;
			
			if(candidatos[med].getNome().equals(nome)) {
				
				return med;
				
			}
			
			else if(ehMaiorQue(candidatos[med].getNome(), nome)) {
				
				sup = med - 1;
				
			}
			
			else {
				
				inf  = med + 1;
				
			}
			
		}
		
		
		return -1;
		
	}
	

}
