/**
 * @author Luiz Gabriel de S. N.
 * @version 1.0
 *
 *
 * Classe responsável pela inicialização da matriz, de acordo com as arestas previamente informadas
 */


import java.util.*;

public class Grafo {
	
	static private Content[][] matriz;
	ArrayList<Aresta> arestas;
	
	/**
	 *
	 * @param size indica o tamanho da matriz
	 * @param arestas lista de valores a serem utilizados na inicialização da matriz
	 *
	 * inicialização da matriz
	 */
	
	Grafo(int size, ArrayList<Aresta> arestas) {
		this.arestas = arestas;
		matriz = new Content[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				matriz[i][j] = new Content();
				if(i == j)
					matriz[i][j].setValue(0);
				else
					matriz[i][j].setValue(-1);
			}
		}
		arestas.forEach((aresta) -> {
			matriz[aresta.getv1()][aresta.getv2()].setValue(aresta.getValue());
			matriz[aresta.getv1()][aresta.getv2()].setTransporte(aresta.getTtransporte());
		});
	}
	
	Content[][] getMatriz(){
		return matriz;
	}
	
	
	/**
	 * Classe criada para teste de função de validação de caminho
	 * @return retorna um caminho inválido a ser testado
	 */
	Caminho teste1(){
		ArrayList<Integer> list = new ArrayList<>();
		list.add(0);
		list.add(2);
		list.add(7);
		list.add(9);
		list.add(15);
		list.add(26);
		
		return new Caminho(matriz,list, 0, 26);
	}
}