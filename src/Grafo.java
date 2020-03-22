/**
 * @author LuizGabriel
 * @version 1.0
 */


import java.util.*;

public class Grafo {
	
	static private Content[][] matriz;
	ArrayList<Aresta> arestas;
	
	/**
	 *
	 * @param size
	 * @param arestas
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
	
	Caminho teste1(){
		ArrayList<Integer> list = new ArrayList<>();
		list.add(0);
		list.add(2);
		list.add(7);
		list.add(9);
		list.add(15);
		list.add(26);
		
		return new Caminho(matriz,list);
	}
}