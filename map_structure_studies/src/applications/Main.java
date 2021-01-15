package applications;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		//caminho do arquivo com os votos
		String path = "C:\\Users\\Luiz\\Desktop\\eclipse-workspace\\map_structure_studies\\src\\files\\votos.txt";
		Map<String, Integer> votes = new HashMap<>();
		
		//try para tratar excecoes na hora de ler o arquivo
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			//leitura linha a linha do arquivo
			String line = br.readLine();
			while(line != null) {
				
				//split para separar numero de votos do nome do candidato (key)
				String[] tmp = line.split(",");
				//pega o numero de votos transformando de string para integer
				Integer tmpvotes = Integer.valueOf(tmp[1]);
				
				//verifica se a estrutura HashMap contem o candidato (key)
				if(votes.containsKey(tmp[0])) {
					//atualiza os valores do candidato com o numero de votos existentes + a nova quantia
					votes.put(tmp[0],  votes.get(tmp[0]) + tmpvotes);
					
				} else {
					//adiciona um novo candidato
					votes.put(tmp[0], tmpvotes );
					
				}
				line = br.readLine();
			}
			
		} catch (IOException e) {
			//msg em caso de excecao (file == null)
			System.out.println("Error: " + e.getMessage());
		}
		
		//imprime todos os campos da estrutura HashMap key + value
		for (String key : votes.keySet()) {
			System.out.println(key + ": " + votes.get(key));
		}
	}
}
