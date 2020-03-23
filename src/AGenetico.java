import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class AGenetico {
	
	private Content[][] matriz;
	private ArrayList<Caminho> caminhos;
	int inicio, end;
	AGenetico(Content[][] matriz, ArrayList<Caminho> caminhos, int inicio, int end){
		this.caminhos = caminhos;
		this.matriz = matriz;
		this.inicio = inicio;
		this.end = end;
	}
	
	ArrayList<Caminho> getCaminhos(){
		return caminhos;
	}
	
	/**
	 *
	 *  gera caminho aleatóriamente
	 */
	void caminhoR() {
		System.out.println("iniciando geração de caminho");
		Caminho novo = new Caminho(matriz, new ArrayList<>(), inicio, end);
		System.out.println("Lista de nós percorridos: " + novo.getPath());
		int fitness = novo.getFitness();
		int trocas = novo.getTrocas();
		System.out.println("Lista de transportes usados: " + novo.getTrocaList());
		System.out.println("custo = " + fitness + ", " +  trocas +" trocas");
		
		if (!caminhos.contains(novo)){
			caminhos.add(novo);
			System.out.println("caminho adicionado!!");
		}
		else{
			int i = 10;
			while(i > 0 && caminhos.contains(novo)){
				novo = new Caminho(matriz, new ArrayList<>(), inicio, end);
				i--;
			}
			if(i == 0 && caminhos.contains(novo))
				System.out.println("caminho não adicionado");
			else
				caminhos.add(novo);
		}
		System.out.println("----------------------------------------------------------------------");
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
		novos.forEach(r ->{
			if (!caminhos.contains(r))
				caminhos.add(r);
			else {
				int i = 10;
				do {
					r = new Caminho(matriz, new ArrayList<>(), inicio, end);
					i--;
				} while (caminhos.contains(r) && i > 0);
				caminhos.add(r);
			}
		});
		
		novos = selecao();
		novos.forEach(r ->r.mutacao(matriz));
		novos.forEach(r -> {
			if (!caminhos.contains(r) && r.validacao(matriz))
				caminhos.add(r);
			else{
				int i = 10;
				do{
					r = new Caminho(matriz, new ArrayList<>(), inicio, end);
					i--;
				}while(caminhos.contains(r) && i > 0);
				caminhos.add(r);
			}
		});
		System.out.println(media());
		System.out.println(caminhos);
		
		System.out.println("Removidos: "+caminhos.removeIf(a -> a.getFitness()>media()));
	}
	
	/**
	 *
	 * @return caminhos a serem usados futuramente(tirar dúvida se é para população ou para processamento)
	 */
	ArrayList<Caminho> selecao() {
		int qnt;
		if(caminhos.size()>10)
			qnt = (int)(caminhos.size()*0.1);
		else
			qnt = (caminhos.size()/2);
		
		
		ArrayList<Caminho> novoCaminhos = new ArrayList<>();
		for(int j = 0; j < qnt; j++) {
			ArrayList<Caminho> seletos = new ArrayList<>();
			for (int i = 0; i < ((qnt/5) > 0 ? qnt/5 : qnt); i++) {
				Random r = new Random();
				seletos.add(caminhos.get(r.nextInt(caminhos.size())));
			}
			ordenador(0, seletos);
			novoCaminhos.add(seletos.get(0));
		}
		return novoCaminhos;
	}
	
	int media() {
		int j = 0;
		for(Caminho i: caminhos){
			j+=i.getFitness();
		}
		return j/caminhos.size();
	}
	
	void ordenador(int op, ArrayList<Caminho> lista) {
		if (op == 0)
			Collections.sort(lista, (a, b) -> a.getFitness() < b.getFitness() ? -1 : 1);
		else
			Collections.sort(lista, (a, b) -> a.getFitness() > b.getFitness() ? -1 : 1);
	}
}
