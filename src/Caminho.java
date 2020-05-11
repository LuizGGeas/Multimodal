import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author LuizGabriel
 * @version 2.0
 * <p>
 * Classe responsável pela modificação e geração de caminhos factíveis para a população
 */

public class Caminho {
	
	private ArrayList<Integer> caminho;
	private ArrayList<Types> trocaList = new ArrayList<>();
	private int fitness = 0;
	private int trocas = 0;
	private int inicio;
	private int end;
	private int tam;
	private Random r = new Random();
	
	
	/**
	 * @param matriz  base para a criação de um novo caminho, sua alteração ou validação
	 * @param caminho caso necessite criar um caminho para uma lista já existente
	 * @param inicio  mostra onde o caminho deve iniciar
	 * @param end     mostra onde o caminho termina
	 *                desenvolvido para gerar caminhos e guardar seu custo durante o processamemto
	 */
	Caminho(Content[][] matriz, ArrayList<Integer> caminho, int inicio, int end, int tam) {
		setCaminho(caminho);
		this.inicio = inicio;
		this.end = end;
		this.tam = tam;
		if (this.caminho.size() == 0) {
			caminho.add(inicio);
			int i = inicio;
			int it = 0;
			do {
				ArrayList<Integer> poss = new ArrayList<>();
				for (int j = 0; j < tam; j++) {
					if (matriz[i][j].getValue() > 0 && !poss.contains(j))
						poss.add(j);
				}
				if (!poss.isEmpty()) {
					poss.removeIf(caminho::contains);
					
					if (poss.isEmpty())
						break;
					
					if (poss.contains(end)) {
						caminho.add(end);
						break;
					}
					else {
						int no = r.nextInt(poss.size());
						caminho.add(poss.get(no));
						i = poss.get(no);
					}
				}
				if (i == end)
					break;
				it++;
			} while (i <= end && it < 1000);
		}
		setFitness(matriz);
		setTrocas(matriz);
	}
	
	ArrayList<Integer> getPath() {
		return caminho;
	}
	
	/**
	 * @param matriz realiza a contagem de transportes utilizados no caminho  utilizando a matriz e o caminho gerado anteriormente
	 */
	
	private void setTrocas(Content[][] matriz) {
		for(int i = 0; i < caminho.size()-1; i++){
			trocaList.add(matriz[caminho.get(i)][caminho.get(i+1)].getTransporte());
		}
		for (int i = 0; i < trocaList.size()-1; i++){
			if ( i + 1 < trocaList.size()-1 && trocaList.get(i+1) == Types.TRANSFERENCIA){
				int j = i;
				do{
					j++;
				}while(j < trocaList.size()-1 && trocaList.get(j) == Types.TRANSFERENCIA);
				
				if(trocaList.get(i) == trocaList.get(j))
					trocas--;
			}
			else{
				if(trocaList.get(i) != trocaList.get(i+1))
					trocas++;
			}
		}
	}
	
	/**
	 * @param matriz calcula o peso para percorrer o caminho gerado anteriormente
	 */
	
	private void setFitness(Content[][] matriz) {
		for (int i = 0; i < caminho.size() - 1; i++) {
			this.fitness += matriz[this.caminho.get(i)][this.caminho.get(i + 1)].getValue();
		}
	}
	
	/**
	 *Função usada para setar o fitness de um caminho não factível
	 */
	void setFitness() {
		this.fitness = Integer.MAX_VALUE - 1;
	}
	
	/**
	 * @param c2 caminho a ser utilizado para o cruzamento
	 * @return volta um novo caminho para ser possivelmente adicionado à lista de população
	 */
	ArrayList<Integer> cross(Caminho c2, int[] cruzamneto){
		ArrayList<Integer> path = new ArrayList<>();
		if (c2.getPath().size() != caminho.size()) {
			ArrayList<Integer> contido = new ArrayList<>();
			caminho.forEach(r -> {
				if (c2.caminho.contains(r) && !contido.contains(r) && r!= inicio && r != end)
					contido.add(r);
			});
			int i;
			int j = 0;
			if (contido.size() > 2) {
				i = contido.get(r.nextInt(contido.size()));
				contido.remove(contido.indexOf(i));
				j = contido.get(r.nextInt(contido.size()));
			} else if (contido.size() == 2) {
				i = contido.get(0);
				j = contido.get(1);
			} else if (contido.size() == 1) {
				i = contido.get(0);
			} else
				i = 0;
			if (contido.size() > 1) {
				cruzamneto[0]++;
				if(caminho.indexOf(i) < caminho.indexOf(j)){
					if(c2.caminho.indexOf(i) < c2.caminho.indexOf(j)) {
						path.addAll(caminho.subList(0, caminho.indexOf(i)));
						path.addAll(c2.caminho.subList(c2.caminho.indexOf(i), c2.caminho.indexOf(j)));
						path.addAll(caminho.subList(caminho.indexOf(j), caminho.size()));
					}
					else{
						path.addAll(caminho.subList(0, caminho.indexOf(i)));
						path.addAll(c2.caminho.subList(c2.caminho.indexOf(j), c2.caminho.indexOf(i)));
						path.addAll(caminho.subList(caminho.indexOf(j), caminho.size()));
					}
				}
				else{
					if(c2.caminho.indexOf(i) < c2.caminho.indexOf(j)) {
						path.addAll(c2.caminho.subList(0,c2.caminho.indexOf(i)));
						path.addAll(caminho.subList(caminho.indexOf(j), caminho.indexOf(i)));
						path.addAll(c2.caminho.subList(c2.caminho.indexOf(j), c2.caminho.size()));
					}
					else{
						path.addAll(caminho.subList(0, caminho.indexOf(j)));
						path.addAll(c2.caminho.subList(c2.caminho.indexOf(j), c2.caminho.indexOf(i)));
						path.addAll(caminho.subList(caminho.indexOf(i), caminho.size()));
					}
					
				}
			} else if (contido.size() == 1) {
				cruzamneto[1]++;
				path.addAll(caminho.subList(0, caminho.indexOf(i)));
				path.addAll(c2.caminho.subList(c2.caminho.indexOf(i), c2.caminho.size()));
			} else{
				cruzamneto[3]++;
				if(fitness < c2.fitness){
					path.addAll(caminho);
				}
				else{
					path.addAll(c2.caminho);
				}
			}
		} else {
			cruzamneto[2]++;
			for (int j = 0; j < caminho.size(); j++) {
				int i = r.nextInt(2);
				if (i == 0)
					path.add(caminho.get(i));
				else
					path.add(c2.caminho.get(i));
			}
		}
		return path;
	}
	
	/**
	 * @param matriz muta o caminho atual para criar um derivado dele aleatoriamente
	 */
	void mutacao(Content[][] matriz) {
		int elementoMudar = r.nextInt(caminho.size());
		if (elementoMudar < inicio)
			elementoMudar+= 2;
		else if (elementoMudar == inicio)
			elementoMudar++;
		if (elementoMudar > end)
			elementoMudar-=2;
		else if (elementoMudar == end)
			elementoMudar--;
		int anterior = caminho.get(elementoMudar-1);
		ArrayList<Integer> path = new ArrayList<>();
		for (int i = 0; i < tam; i++) {
			if (matriz[anterior][i].getValue() != 0 && i != caminho.get(elementoMudar) && !caminho.contains(i))
				path.add(i);
		}
		if (path.size() > 0) {
			int novo = r.nextInt(path.size());
			caminho.add(elementoMudar, novo);
			caminho.remove(elementoMudar);
		}
		else{
			caminho.remove(elementoMudar);
			caminho.add( elementoMudar, r.nextInt(tam));
		}
		
	}
	
	int getFitness() {
		return fitness;
	}
	
	ArrayList<Types> getTrocaList() {
		return trocaList;
	}
	
	int getTrocas() {
		return trocas;
	}
	
	private void setCaminho(ArrayList<Integer> caminho) {
		this.caminho = caminho;
	}
	
	@Override
	public String toString() {
		return caminho.toString() + " - " + getFitness();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this.getClass().getName().equals(obj.getClass().getName())) {
			if (this.getPath().equals(((Caminho) obj).getPath()))
				return this.getTrocaList().equals(((Caminho) obj).getTrocaList());
		}
		return false;
	}
	
	/**
	 * @return caminho válido ou não
	 * <p>
	 * função confere se o caminho fornecido é uma solução para chegar do nó 0 ao nó 26
	 */
	boolean validacao(Content[][] matriz) {
		AtomicInteger a = new AtomicInteger(1);
		caminho.forEach((r) -> {
			if(caminho.lastIndexOf(r) != caminho.indexOf(r))
				a.set(0);
		});
		if(a.get() != 1) return false;
		if(caminho.contains(inicio) && caminho.contains(end)){
			for (int i = 0; i < caminho.size() - 1; i++) {
				if (matriz[caminho.get(i)][caminho.get(i + 1)].getValue() <= 0) {
					if (caminho.get(i + 1) != end) {
						caminho.add(caminho.remove(i + 1));
						i--;
					}
					if (i > 1 && caminho.get(i + 1) == end) {
						caminho.add(caminho.remove(i + 1));
						caminho.add(caminho.remove(i));
						i -= 2;
					}
					if (i == 1 && caminho.get(i + 1) == end) {
						return false;
					}
				}
			}
		}
		return true;
	}
}

