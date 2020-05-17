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
	
	private final Content[][] matriz;
	private ArrayList<Caminho> caminhos;
	private final int inicio;
	private final int end;
	private final int tam;
	private int[] cruzamento = {0, 0, 0, 0};
	private int[] selecao = {0, 0, 0};
	private final double[] percent = {0.2, 0.6, 0.15};
	private int antes;
	
	/**
	 * @param matriz   gerada na classe Grafo
	 * @param inicio   indicado na classe Main
	 * @param end      indicado na classe Main
	 * @param tam      contém a quantidade de elementos usados para a geração da matriz
	 *                 <p>
	 *                 Realiza a inicialização dos valores a serem utilizados globalmente nesta classe
	 */
	AGenetico(Content[][] matriz, int inicio, int end, int tam) {
		this.caminhos = new ArrayList<>();
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
		selecao[0] = 0;
		selecao[1] = 0;
		selecao[2] = 0;
		antes = 0;
	}

	void populacao(int sizePop){
		reinit();
		percent[0] = 0.25;
		ArrayList<Caminho> novos = new ArrayList<>();
		ArrayList<Caminho> cruzar = selecao(1, true, (int)(sizePop*0.25));
		for(int i = 0; i < cruzar.size()/2; i++){

			Caminho c = new Caminho(matriz, cruzar.get(i)
					.cross(cruzar.get(cruzar.size()/2+i), cruzamento), inicio, end, tam);
			if(c.validacao(matriz))
				novos.add(c);
		}
		ArrayList<Caminho> mutar = selecao(2,true, (int)(sizePop*0.15));
		mutar.forEach(r -> r.mutacao(matriz));
		mutar.forEach((r) -> {
			if(r.validacao(matriz))
				novos.add(r);
		});
		ordenador(caminhos);
		for (int i = 0; i < caminhos.size()*0.2; i++){
			novos.add(caminhos.get(i));
		}
		for (int i = (int)(caminhos.size()*0.9);i < caminhos.size(); i++){
			novos.add(caminhos.get(i));
		}

		caminhos.clear();
		caminhos.addAll(novos);
		for (int i= caminhos.size(); i < sizePop; i++){
			caminhoR();
		}
	}
	
	/**
	 * Faz o processamento da população em todas as gerações
	 * Realiza a chamada de função de mutação e cruzamento, utilizando da função de seleção
	 * Faz a seleção elitista dos n melhores elementos, onde estes serão melhores que a média de fitness da população
	 */
	void populacao(boolean cond){
		reinit();
		antes = caminhos.size();
		ArrayList<Caminho> novos = selecao(1, cond, 0);
		for (int i = 0; i < novos.size() / 2; i++) {

			Caminho a = new Caminho(matriz, novos.get(i).cross(novos.get(novos.size() / 2 + i),
					cruzamento), inicio, end, tam);
			Caminho b = new Caminho(matriz, novos.get(novos.size() / 2 + i).cross(novos.get(i),
					cruzamento), inicio, end, tam);
			if (a.validacao(matriz))
				caminhos.add(a);
			if(b.validacao(matriz))
				caminhos.add(b);
		}
		
		novos.forEach(this::adicionarNotRepetidos);
		novos = selecao(2, cond, 0);
		novos.forEach(r -> r.mutacao(matriz));
		novos.forEach(this::adicionarNotRepetidos);

		for(int i=0; i < caminhos.size(); i++ ){
			if(caminhos.get(i).getFitness() > mediana()*0.8){
				caminhos.remove(i);
				selecao[0]++;
			}
		}

	}

	/**
	 * @param r: caminho a ser verificado se existe na população atual
	 */

	private void adicionarNotRepetidos(Caminho r) {
		if (caminhos.contains(r)) {
			int i = 10;
			do {
				//r = new Caminho(matriz, new ArrayList<>(), inicio, end, tam);
				r.mutacao(matriz);
				i--;
			} while (caminhos.contains(r) && i > 0);
			if (caminhos.contains(r)) {
				r.mutacao(matriz);
				if(!r.validacao(matriz))
					r.setFitness();
			}
		}
		caminhos.add(r);
	}

	/**
	 * @param index seleciona para o que será usada a seleção,
	 *              assim usando diferentes valores que serão
	 *              utilizados para a geração de novos elementos
	 * @return caminhos a serem usados futuramente
	 */
	private ArrayList<Caminho> selecao(int index, boolean cond, int tam ) {
		int qnt = tam == 0 ? Arredondamento(cond, index) : tam;
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
				qnt = (int) ((caminhos.size() > 20) ? (caminhos.size() * percent[0]) : (caminhos.size() * percent[1]));
				if(qnt % 2 != 0)
					qnt++;
			}
			else if (index == 2){
				qnt = (int)Math.ceil(caminhos.size()*percent[2]);
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
	int mediana() {
		ordenador(caminhos);
		if(caminhos.size()%2 == 0 && caminhos.size()>0) {
			return ((caminhos.get((int)Math.ceil(caminhos.size() / 2)).getFitness() +
					caminhos.get((int)Math.floor(caminhos.size() / 2)).getFitness()) / 2);
		}
		return caminhos.size() > 0 ? caminhos.get(caminhos.size()/2).getFitness() : -1;
	}
	
	/**
	 * @return busca o caminho com melhor fitness para salvar
	 * em caso de necessidade de comparação posterior
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
		double val = antes > 20 ? percent[0] : percent[1];
		return selecao[1] + "; " + val + "; " + percent[2] + "; " + selecao[2]
				+ "; " + selecao[0] + "; " + melhor() + "; ";
	}
}
