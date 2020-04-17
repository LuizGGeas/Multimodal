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
		
		for (int i = 0; i < 100; i++) {
			ag.caminhoR();
		}
		int lm = Integer.MAX_VALUE-1;
		int i = 0;
		csv.append("geracao; taxaCruzamento; NumdoisPontos; NumumPonto;" +
				" NumOutro; NumNenhum; taxaMutacao; Nummutacao; NumElitismo; NumTorneio;\n");
		do{
			i++;
			ios.writeChars("geração: " + i + ": \n");
			ios.writeChars(ag.getCaminhos().toString() + "\n");
			ios.writeChars("melhor indivíduo da geração:" + ag.melhor() + "\n");
			ag.populacao();
			csv.append(i + "; " + ag.toString() + "\n");
			System.out.println("geração " + i);
			System.out.println("número de caminhos guardados: " + ag.getCaminhos().size());
			System.out.println("melhor caminho: " + ag.melhor());
			System.out.println("media atual: " + ag.media());
			System.out.println("aperte enter para a próxima geração");
			System.in.read();
			if (lm < ag.media()) {
				ios.writeChars("melhor valor é da geração anterior!!!!\n");
				System.out.println("deveria retornar à iteração anterior");
				break;
			}
			lm = ag.media();
		}while(ag.getCaminhos().size()>10);
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
