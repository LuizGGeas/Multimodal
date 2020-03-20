import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class AGenetico {
	
	private Content[][] matriz;
	private ArrayList<Caminho> caminhos;
	AGenetico(Content[][] matriz, ArrayList<Caminho> caminhos){
		this.caminhos = caminhos;
		this.matriz = matriz;
	}
	
	ArrayList<Caminho> getCaminhos(){
		return caminhos;
	}
	
	/**
	 *
	 *  gera caminho aleatóriamente
	 */
	void caminhoR() {
		Caminho novo = new Caminho(matriz, new ArrayList<>());
		System.out.println("Lista de nós percorridos: " + novo.getPath());
		int fitness = novo.getFitness();
		int trocas = novo.getTrocas();
		System.out.println("Lista de transportes usados: " + novo.getTrocaList());
		System.out.println("custo = " + fitness + ", " +  trocas +" trocas");
		System.out.println("----------------------------------------------------------------------");
		caminhos.add(novo);
	}
	
	

	/**
	 *
	 * remove os caminhos cujo fitness sejam maiores que 50
	 */
	void populacao() {
		ArrayList<Caminho> novos = selecao();
		for(int i = 0; i < novos.size()/2; i++){
			novos.get(i).cross(novos.get(2*i), matriz);
		}
		caminhos.addAll(novos);
		novos = selecao();
		novos.forEach(r -> r.mutacao(matriz));
		caminhos.addAll(novos);
		Collections.sort(caminhos, (a,b) -> a.getFitness() == b.getFitness() ? 0 : a.getFitness() > b.getFitness() ? -1 : 1 );
		caminhos.removeIf(a -> a.getFitness()>50);
	}
	
	/**
	 *
	 * @return caminhos a serem usados futuramente(tirar dúvida se é para população ou para processamento)
	 */
	ArrayList<Caminho> selecao() {
		ArrayList<Caminho> novoCaminhos = new ArrayList<>();
		for(int j = 0; j < 30; j++) {
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
}
