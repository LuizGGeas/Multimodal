import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

/**
 * @author Luiz Gabriel de S. N.
 * @version 1.6
 * <p>
 * Classe responsável por todas as chamadas de operações de modificação da população
 */
class AGenetico {
	
	private Content[][] matriz;
	private ArrayList<Caminho> caminhos;
	private int inicio;
	private int end;
	private int tam;
	
	/**
	 * @param matriz   gerada na classe Grafo
	 * @param caminhos gerados na classe Main
	 * @param inicio   indicado na classe Main
	 * @param end      indicado na classe Main
	 * @param tam      contém a quantidade de elementos usados para a geração da matriz
	 * <p>
	 * Realiza a inicialização dos valores a serem utilizados globalmente nesta classe
	 */
	AGenetico(Content[][] matriz, ArrayList<Caminho> caminhos, int inicio, int end, int tam) {
		this.caminhos = caminhos;
		this.matriz = matriz;
		this.inicio = inicio;
		this.end = end;
		this.tam = tam;
	}
	
	/**
	 * Retorna os caminhos gerados
	 */
	ArrayList<Caminho> getCaminhos() {
		return caminhos;
	}
	
	/**
	 * gera caminho aleatóriamente, evitando a repetição destes.
	 * e garante que caminhos não factiveis sejam logo removidos
	 */
	void caminhoR() {
		System.out.println("iniciando geração de caminho");
		Caminho novo = new Caminho(matriz, new ArrayList<>(), inicio, end, tam);
		System.out.println("Lista de nós percorridos: " + novo.getPath());
		int fitness = novo.getFitness();
		int trocas = novo.getTrocas();
		System.out.println("Lista de transportes usados: " + novo.getTrocaList());
		System.out.println("custo = " + fitness + ", " + trocas + " trocas");
		
		if (!caminhos.contains(novo)) {
			if (!novo.validacao(matriz))
				novo.setFitness();
			caminhos.add(novo);
			System.out.println("caminho adicionado!!");
		} else {
			adicionarNotRepetidos(novo);
		}
		System.out.println("----------------------------------------------------------------------");
	}
	
	
	/**
	 * Faz o processamento da população em todas as gerações
	 * Realiza a chamada de função de mutação e cruzamento, utilizando da função de seleção
	 * Faz a seleção elitista dos n melhores elementos, onde estes serão melhores que a média de fitness da população
	 */
	
	void populacao() {
		ArrayList<Caminho> novos = selecao(1);
		for (int i = 0; i < novos.size() / 2; i++) {
			novos.get(i).cross(novos.get(2 * i));
		}
		novos.forEach(this::adicionarNotRepetidos);
		novos = selecao(2);
		novos.forEach(r -> r.mutacao(matriz));
		
		novos.forEach(this::adicionarNotRepetidos);

		System.out.println(media());
		System.out.println(caminhos);
		
		System.out.println("Removidos: " + caminhos.removeIf(a -> a.getFitness() > media()));
	}
	
	/**
	 * @param r: caminho a ser verificado se existe na população atual
	 */
	
	private void adicionarNotRepetidos(Caminho r) {
		if (!caminhos.contains(r) && r.validacao(matriz))
			caminhos.add(r);
		else {
			int i = 10;
			do {
				r = new Caminho(matriz, new ArrayList<>(), inicio, end, tam);
				i--;
			} while (caminhos.contains(r) && i > 0);
			if (i > 0 && !caminhos.contains(r))
				caminhos.add(r);
		}
	}
	
	/**
	 * @return caminhos a serem usados futuramente(tirar dúvida se é para população ou para processamento)
	 */
	private ArrayList<Caminho> selecao(int index) {
		int qnt = 0;
		if (index == 1){
			if (caminhos.size() > 10)
				qnt = (int) (caminhos.size() * 0.1);
			else
				qnt = (caminhos.size() / 2);
		}
		else if (index == 2){
			qnt = (int)Math.ceil(caminhos.size()*0.03);
		}
		
		
		ArrayList<Caminho> novoCaminhos = new ArrayList<>();
		for (int j = 0; j < qnt; j++) {
			ArrayList<Caminho> seletos = new ArrayList<>();
			for (int i = 0; i < ((qnt / 5) > 0 ? qnt / 5 : qnt); i++) {
				Random r = new Random();
				seletos.add(caminhos.get(r.nextInt(caminhos.size())));
			}
			ordenador(seletos);
			novoCaminhos.add(seletos.get(0));
		}
		return novoCaminhos;
	}
	
	/**
	 * @return calcula a média do fitness da população para processamento de futuras gerações
	 */
	int media() {
		int j = 0;
		for (Caminho i : caminhos) {
			j += i.getFitness();
		}
		return j / caminhos.size();
	}
	
	/**
	 * @return busca o caminho com melhor fitness para salvar em caso de necessidade de comparação posterior
	 */
	Caminho melhor() {
		int i = Integer.MAX_VALUE-1;
		Caminho c1 = null;
		for (Caminho c : caminhos) {
			if (c.getFitness() < i) {
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
		lista.sort(Comparator.comparingInt(Caminho::getFitness));
	}
}
