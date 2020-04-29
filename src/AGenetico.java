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
	private int[] cruzamento = {0, 0, 0, 0};
	private int mutacao = 0;
	private int[] selecao = {0, 0, 0};
	private double[] percent = {0.1, 0.5, 0.03};
	private int antes;
	
	/**
	 * @param matriz   gerada na classe Grafo
	 * @param caminhos gerados na classe Main
	 * @param inicio   indicado na classe Main
	 * @param end      indicado na classe Main
	 * @param tam      contém a quantidade de elementos usados para a geração da matriz
	 *                 <p>
	 *                 Realiza a inicialização dos valores a serem utilizados globalmente nesta classe
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
		Caminho novo = new Caminho(matriz, new ArrayList<>(), inicio, end, tam);
		if (!caminhos.contains(novo)) {
			if (!novo.validacao(matriz))
				novo.setFitness();
			caminhos.add(novo);
		} else {
			adicionarNotRepetidos(novo);
		}
	}
	
	private void reinit() {
		cruzamento[0] = 0;
		cruzamento[1] = 0;
		cruzamento[2] = 0;
		cruzamento[3] = 0;
		mutacao = 0;
		selecao[0] = 0;
		selecao[1] = 0;
		selecao[2] = 0;
		antes = 0;
	}
	
	/**
	 * Faz o processamento da população em todas as gerações
	 * Realiza a chamada de função de mutação e cruzamento, utilizando da função de seleção
	 * Faz a seleção elitista dos n melhores elementos, onde estes serão melhores que a média de fitness da população
	 */
	void populacao(boolean cond) {
		reinit();
		antes = caminhos.size();
		ArrayList<Caminho> novos = selecao(1, cond);
		for (int i = 0; i < novos.size() / 2; i++) {
			novos.get(i).cross(novos.get(novos.size() / 2 + i), cruzamento);
		}
		
		novos.forEach(this::adicionarNotRepetidos);
		novos = selecao(2, cond);
		novos.forEach(r -> {
			r.mutacao(matriz);
			mutacao++;
		});
		novos.forEach(this::adicionarNotRepetidos);
		caminhos.forEach(r -> {
			if (r.getFitness() > media())
				selecao[0]++;
		});
		caminhos.removeIf((caminho)->{
			if(caminho.getFitness() > media()){
				selecao[0]++;
				return true;
			}
			return false;
		});
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
	 * @param index seleciona para o que será usada a seleção, assim usando diferentes valores que serão utilizados para
	 *              a geração de novos elementos
	 * @return caminhos a serem usados futuramente
	 */
	private ArrayList<Caminho> selecao(int index, boolean cond) {
		int qnt = Arredondamento(cond, index);
		ArrayList<Caminho> novoCaminhos = new ArrayList<>();
		for (int j = 0; j < qnt; j++) {
			selecao[index] = qnt;
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
	 * funcao que define se haverá arredondamento ou não para o processamento das próximas gerações
	 */
	private int Arredondamento(boolean cond, int index){
		int qnt = 0;
		if (cond){
			if (index == 1){
				qnt = (caminhos.size() > 20) ? (int)(caminhos.size() * percent[0]) : (int)(caminhos.size() * percent[1]);
				if(qnt % 2 != 0)
					qnt--;
			}
			else if (index == 2){
				qnt = (caminhos.size()*percent[2]) < 1 ? 1 : (int)Math.floor(caminhos.size()*percent[2]);
			}
		}
		else{
			if(index == 1)
				qnt = (caminhos.size() > 20) ? (int)(caminhos.size() * percent[0]) : (int)(caminhos.size() * percent[1]);
			else if(index == 2)
				qnt = (int)(caminhos.size()*percent[2]);
		}
		return qnt;
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
		int i = Integer.MAX_VALUE - 1;
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
	 *
	 * @param lista seleciona a lista a ser ordenada
	 */
	void ordenador(ArrayList<Caminho> lista) {
		lista.sort(Comparator.comparingInt(Caminho::getFitness));
	}
	
	@Override
	public String toString() {
		double val = antes >= 20 ? percent[0] : percent[1];
		return selecao[1] + "; " + val + "; " + cruzamento[0] + "; " + cruzamento[1] + "; " + cruzamento[2] + "; " +
				cruzamento[3] + "; " + percent[2] + "; " + selecao[2] + "; " + mutacao + "; " + selecao[0] + ";";
	}
}
