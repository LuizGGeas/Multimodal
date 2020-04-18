import java.io.*;
import java.util.*;

/**
 * @author LuizGabriel
 * @version 2.3
 */

public class Main {
	
	public static void main(String[] args) throws IOException {
		FileWriter csv = new FileWriter("tabela.csv", true);
		ObjectOutputStream ios = new ObjectOutputStream(new FileOutputStream("geracoes1.txt", true));
		CArestas c = new CArestas();
		ArrayList<Aresta> arestas = c.getArestas(59);
		Grafo g = new Grafo(21, arestas);
		AGenetico ag = new AGenetico(g.getMatriz(), new ArrayList<>(), 1, 20,21);
		for (int i = 0; i < 40; i++) {
			ag.caminhoR();
		}
		int lm = Integer.MAX_VALUE-1;
		int i = 0;
		int verificar = 10;
		int melhorGeracao = 0;
		csv.append("geracao; tamanhoAntesOP; tamanhoDepoisOP; quantidadeCruzados; taxaCruzamento; NumdoisPontos; NumumPonto;" +
				" NumOutro; NãoCruzados; taxaMutacao; SerMutado; Nummutacao; NumElitismo;\n");
		while(ag.getCaminhos().size()>10){
			i++;
			int tam = ag.getCaminhos().size();
			ios.writeChars("geração: " + i + ": \n");
			ios.writeChars(ag.getCaminhos().toString() + "\n");
			ios.writeChars("melhor indivíduo da geração:" + ag.melhor() + "\n");
			ag.populacao();
			csv.append(i + "; " + tam + "; " + ag.getCaminhos().size() + "; " + ag + "\n");
			System.out.println("geração " + i);
			System.out.println("número de caminhos guardados: " + ag.getCaminhos().size());
			System.out.println("melhor caminho: " + ag.melhor());
			System.out.println("media atual: " + ag.media());
			System.out.println("aperte enter para a próxima geração");
			System.in.read();
			if(lm >= ag.media()) {
				lm = ag.media();
				melhorGeracao = i;
			}
			if(i >= verificar) {
				if (lm < ag.media()) {
					ios.writeChars("melhor valor é da geração anterior!!!!\n");
					System.out.println("deveria retornar à " + melhorGeracao + " iteração");
					break;
				}
				verificar += 10;
			}
			lm = ag.media();
		}
		ios.writeChars("______________________________________________________________________________________________________________________________\n");
		ag.ordenador(ag.getCaminhos());
		System.out.println(ag.getCaminhos());
		System.out.println(ag.getCaminhos().get(0));
		csv.append("\n");
		csv.flush();
		csv.close();
		
		ios.close();
	}
}
