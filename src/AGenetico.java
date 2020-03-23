import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * @author Luiz Gabriel de S. N.
 * @version 1.6
 *
 * Classe responsável por todas as chamadas de operações de modificação da população
 */
class AGenetico {
	
	private Content[][] matriz;
	private ArrayList<Caminho> caminhos;
	private int inicio;
	private  int end;
	
	/**
	 *
	 * @param matriz gerada na classe Grafo
	 * @param caminhos gerados na classe Main
	 * @param inicio indicado na classe Main
	 * @param end indicado na classe Main
	 *
	 * Realiza a inicialização dos valores a serem utilizados globalmente nesta classe
	 */
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
	 *  gera caminho aleatóriamente, evitando a repetição destes.
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
	 * Faz todo o processamento da população em todas as gerações
	 * Realiza a chamada de função de mutação e cruzamento, utilizando da função de seleção
	 * Faz a seleção elitista dos n melhores elementos, onde estes serão melhores que a média de fitness da população
	 */
	void populacao() {
		ArrayList<Caminho> novos = selecao();
		for(int i = 0; i < novos.size()/2; i++){
			novos.get(i).cross(novos.get(2*i));
		}
		adicionarNotRepetidos(novos);
		novos = selecao();
		novos.forEach(r ->r.mutacao(matriz));
		adicionarNotRepetidos(novos);
		System.out.println(media());
		System.out.println(caminhos);
		
		System.out.println("Removidos: "+caminhos.removeIf(a -> a.getFitness()>media()));
	}
	
	private void adicionarNotRepetidos(ArrayList<Caminho> novos){
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
	}
	
	/**
	 *
	 * @return caminhos a serem usados futuramente(tirar dúvida se é para população ou para processamento)
	 */
	private ArrayList<Caminho> selecao() {
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
			ordenador(seletos);
			novoCaminhos.add(seletos.get(0));
		}
		return novoCaminhos;
	}
	
	/**
	 *
	 * @return calcula a média do fitness da população para processamento de futuras gerações
	 */
	int media() {
		int j = 0;
		for(Caminho i: caminhos){
			j+=i.getFitness();
		}
		return j/caminhos.size();
	}
	
	/**
	 *
	 * @return busca o caminho com melhor fitness para salvar em caso de necessidade de comparação posterior
	 */
	Caminho melhor() {
		int i = 999999999;
		Caminho c1 = null;
		for(Caminho c:caminhos ){
			if (c.getFitness()<i) {
				c1 = c;
				i = c.getFitness();
			}
		}
		return c1;
	}
	
	/**
	 * Função de ordenação de listas de acordo com a ordem necessitada
	 * @param lista seleciona a lista a ser ordenada
	 */
	void ordenador(ArrayList<Caminho> lista) {
		Collections.sort(lista, (a, b) -> a.getFitness() < b.getFitness() ? -1 : 1);
	}
}
