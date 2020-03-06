/**
 * @author LuizGabriel
 * @version 1.0
 */


import java.util.*;

public class Grafo {
	
	private Content[][] matriz;
	private int size;
	ArrayList<Aresta> arestas;
	
	/**
	 *
	 * @param size
	 * @param arestas
	 *
	 * inicialização da matriz
	 */
	
	Grafo(int size, ArrayList<Aresta> arestas) {
		this.size = size;
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
	
	/**
	 *
	 * @return caminho gerado aleatoriamente
	 */
	
	Caminho caminhoR() {
		Caminho caminho = new Caminho(matriz, new ArrayList<>());
		return caminho;
	}
	
	Caminho cruzar(ArrayList<Caminho> caminhos) {
		Collections.sort(caminhos, (a, b) -> a.getFitness() < b.getFitness() ? -1 : 1);
		Caminho c1 = caminhos.get(0), c2 = caminhos.get(1);
		System.out.print(c1 + " + " + c2 + " = ");
		return new Caminho(matriz, c1.cross(c2, matriz));
		
	}
	
	boolean validacao(Caminho path){
		return path.validacao(matriz);
	}
	
	void mutacao(ArrayList<Caminho> caminhos){
		Collections.sort(caminhos, (a, b) -> a.getFitness() > b.getFitness() ? -1 : 1);
		caminhos.get(0).mutacao(matriz);
		System.out.println(caminhos.get(0));
		System.out.println(caminhos.get(0).validacao(matriz));
	}
	
	ArrayList<Caminho> selecao(ArrayList<Caminho> caminhos) {
		ArrayList<Caminho> novoCaminhos = new ArrayList<>();
		for(int j = 0; j < 10; j++) {
			ArrayList<Caminho> seletos = new ArrayList<>();
			for (int i = 0; i < 5; i++) {
				Random r = new Random();
				seletos.add(caminhos.get(r.nextInt(caminhos.size())));
			}
			Collections.sort(seletos, (a, b) -> a.getFitness() < b.getFitness() ? -1 : 1);
			novoCaminhos.add(seletos.get(0));
		}
		return novoCaminhos;
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