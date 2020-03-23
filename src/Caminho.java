/**
 * @author LuizGabriel
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Random;

public class Caminho {
	
	private ArrayList<Integer> caminho;
	private ArrayList<Types> trocaList = new ArrayList<>();
	private int fitness = 0;
	private int trocas = 0;
	Random r = new Random();
	
	
	
	/**
	 * @param matriz
	 * @param caminho a ser inicializado
	 *
	 * desenvolvido para gerar caminhos e guardar seu custo durante o processamemto
	 */
	Caminho(Content[][] matriz, ArrayList<Integer> caminho, int inicio, int end){
		setCaminho(caminho);
		if(this.caminho.size() == 0){
			caminho.add(inicio);
			int i = 0;
			while (i <= end){
				ArrayList<Integer> poss = new ArrayList<>();
				for(int j = 0; j < 27; j++){
					if(matriz[i][j].getValue() > 0)
						poss.add(j);
					
				}
				if(!poss.isEmpty()) {
					poss.removeIf(r-> caminho.contains(r));
					int no = r.nextInt(poss.size());
					caminho.add(poss.get(no));
					i = poss.get(no);
				}
				if(i == end)
					break;
			}
		}
		setFitness(matriz);
		setTrocas(matriz);
	
	}
	
	public ArrayList<Integer> getPath(){
		return caminho;
	}
	
	/**
	 *
	 * @param matriz
	 * realiza a contagem de transportes utilizados no caminho  utilizando a matriz e o caminho gerado anteriormente
	 */
	
	public void setTrocas(Content[][] matriz){
		for(int i = 0; i < caminho.size()-1; i++){
			
			if(matriz[caminho.get(i)][caminho.get(i+1)].getTransporte() != Types.TRANSFERENCIA){
				if(i+2 < caminho.size()-1 && matriz[caminho.get(i)][caminho.get(i+1)].getTransporte() != matriz[caminho.get(i+1)][caminho.get(i+2)].getTransporte())
					trocas++;
			}
			else{
				if (i+2 < caminho.size()-1 && matriz[caminho.get(i-1)][caminho.get(i)].getTransporte() == matriz[caminho.get(i+1)][caminho.get(i+2)].getTransporte())
					trocas--;
			}
			trocaList.add(matriz[caminho.get(i)][caminho.get(i+1)].getTransporte());
		}
	}
	
	/**
	 *
	 * @param matriz
	 *
	 * calcula o peso para percorrer o caminho gerado anteriormente
	 */
	
	public void setFitness(Content[][] matriz){
		for(int i = 0; i < caminho.size()-1; i++){
			this.fitness += matriz[this.caminho.get(i)][this.caminho.get(i+1)].getValue();
		}
	}
	
	/**
	 *
	 * @param c2
	 * @param matriz
	 * @return volta um novo caminho para ser possivelmente adicionado à lista de população
	 */
	
	public ArrayList<Integer> cross(Caminho c2, Content[][] matriz){
		
		ArrayList<Integer> path = new ArrayList<>();
		if(c2.getPath().size() != caminho.size()){
			int i = 0;
			for(int c: caminho){
				if(c>=0 && c<26 && c2.caminho.contains(c))
					i = c;
				else
					break;
			}
			
			if(i!= 0){
				path.addAll(caminho.subList(0, caminho.indexOf(i)));
				path.addAll(c2.caminho.subList(c2.caminho.indexOf(i), c2.caminho.size()));
			}
			else{
				if(fitness < c2.fitness){
					path.addAll(caminho);
				}
				else{
					path.addAll(c2.caminho);
				}
			}
		}
		else {
			for(int j = 0; j < caminho.size(); j++){
			
			}
		}
		return path;
	}
	
	/**
	 *
	 * @param matriz
	 *
	 * muta o caminho atual para criar um derivado dele aleatoriamente
	 */
	public void mutacao(Content[][] matriz){
		int elementoMudar = r.nextInt(caminho.size());
		
		if(elementoMudar == 0)
			elementoMudar++;
		if(elementoMudar == 26)
			elementoMudar--;
		
		int anterior = caminho.get(elementoMudar-1);
		ArrayList<Integer> path = new ArrayList<>();
		for(int i = 0; i < 26; i++){
			if(matriz[anterior][i].getValue() != 0 && i != caminho.get(elementoMudar) && !caminho.contains(i))
				path.add(i);
		}
		
		if(path.size() > 0) {
			int novo = r.nextInt(path.size());
			caminho.add(elementoMudar, novo);
			caminho.remove(elementoMudar);
		}
	}
	
	public int getFitness(){
		return fitness;
	}
	
	public ArrayList<Types> getTrocaList(){
		return trocaList;
	}
	
	public int getTrocas(){
		return trocas;
	}
	
	public void setCaminho(ArrayList<Integer> caminho) {
		this.caminho = caminho;
	}
	
	@Override
	public String toString(){
		return caminho.toString() +  " - " + getFitness();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this.getPath().equals(((Caminho) obj).getPath()))
			if (this.getTrocaList().equals(((Caminho) obj).getTrocaList())) {
				return true;
			}
		return false;
	}
	
	/**
	 *
	 * @return caminho válido ou não
	 *
	 * função confere se o caminho fornecido é uma solução para chegar do nó 0 ao nó 26
	 */
	
	boolean validacao(Content[][] matriz) {
		for(int i = 0; i < caminho.size()-1; i++){
			if(matriz[caminho.get(i)][caminho.get(i+1)].getValue()<=0){
				if(caminho.get(i+1) != 26){
					caminho.add(caminho.remove(i+1));
					i--;
				}
				if(i > 1 && caminho.get(i+1) == 26){
					caminho.add(caminho.remove(i+1));
					caminho.add(caminho.remove(i));
					i-=2;
				}
				if(caminho.get(i+1) == 26 && i == 1)
					return false;
			}
		}
		return true;
	}
}

