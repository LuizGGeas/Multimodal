import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @author LuizGabriel
 * @version 2.3
 */

public class Main {
	
	public static void main(String[] args) throws IOException {
		boolean verify = false;
		String path= verify ? "Arredondamento" : "NaoArredondado";
		
		FileWriter num = new FileWriter("C:/Users/byeh9/Multimodal/src/populacao/"+ path +"/exec.txt", true);
		BufferedReader br = new BufferedReader(new FileReader("C:/Users/byeh9/Multimodal/src/populacao/"+ path +"/exec.txt"));
		int val = 0;
		while(br.readLine()!=null){
			val++;
		}
		val++;
		num.append("a\n");
		num.flush();
		num.close();
		FileWriter csv = new FileWriter("C:/Users/byeh9/Multimodal/src/populacao/"+path+"/tabelas/tabela"+ val +".csv");
		OutputStreamWriter ios = new OutputStreamWriter(new FileOutputStream(
				"C:/Users/byeh9/Multimodal/src/populacao/"+path+"/geracoes/geracoes"+val+".txt"), StandardCharsets.ISO_8859_1);
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
			ios.append("geração: " + i + ": \n");
			ios.append(ag.getCaminhos().toString() + "\n");
			ios.append("melhor indivíduo da geração:" + ag.melhor() + "\n");
			ag.populacao(verify);
			csv.append(i + "; " + tam + "; " + ag.getCaminhos().size() + "; " + ag + "\n");
			System.out.println("geração " + i);
			System.out.println("número de caminhos guardados: " + ag.getCaminhos().size());
			System.out.println("melhor caminho: " + ag.melhor());
			System.out.println("media atual: " + ag.media());
			if(lm >= ag.media()) {
				lm = ag.media();
				melhorGeracao = i;
			}
			if(i >= verificar) {
				if (lm < ag.media()) {
					ios.append("melhor valor é da geração " + melhorGeracao + "!!!!\n");
					System.out.println("deveria retornar à " + melhorGeracao + " iteração");
					break;
				}
				verificar += 10;
			}
			lm = ag.media();
		}
		ios.append("______________________________________________________________________________________________________________________________\n");
		ag.ordenador(ag.getCaminhos());
		System.out.println(ag.getCaminhos());
		System.out.println(ag.getCaminhos().get(0));
		csv.append("\n");
		csv.flush();
		csv.close();
		ios.flush();
		ios.close();
	}
}
