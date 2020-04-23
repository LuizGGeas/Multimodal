import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @author LuizGabriel
 * @version 2.3
 */

public class Main {
	
	public static void main(String[] args) throws IOException {
		execucao(20, true);
		execucao(20, false);
		execucao(40, true);
		execucao(40, false);
		execucao(60, true);
		execucao(60, false);
		execucao(80, true);
		execucao(80, false);
		
	}
	
	static void execucao(int tam, boolean cond) throws IOException {
		String pasta = cond ? "Arredondado" : "NaoArredondado";
		FileWriter num = new FileWriter("C:/Users/byeh9/Multimodal/src/populacao/"
				+ tam + "/" + pasta + "/exec.txt", true);
		BufferedReader br = new BufferedReader(new FileReader("C:/Users/byeh9/Multimodal/src/populacao/"
				+ tam + "/" + pasta +  "/exec.txt"));
		int val = 0;
		while(br.readLine()!=null){
			val++;
		}
		val++;
		num.append("a\n");
		num.flush();
		num.close();
		FileWriter csv = new FileWriter("C:/Users/byeh9/Multimodal/src/populacao/"
				+ tam + "/" + pasta +  "/tabelas/tabela"+ val +".csv");
		OutputStreamWriter ios = new OutputStreamWriter(new FileOutputStream("C:/Users/byeh9/Multimodal/src/populacao/"
				+ tam + "/" + pasta + "/populacao/populacao"+val+".txt"), StandardCharsets.ISO_8859_1);
		Grafo c = new CArestas().getGrafo();
		
		AGenetico ag = new AGenetico(c.getMatriz(), new ArrayList<>(), 1, 20,21);
		for (int i = 0; i < tam; i++) {
			ag.caminhoR();
		}
		int lm = Integer.MAX_VALUE-1;
		int i = 0;
		int verificar = 10;
		int melhorGeracao = 0;
		csv.append("geracao; tamanhoAntesOP; tamanhoDepoisOP; quantidadeCruzados; taxaCruzamento; NumdoisPontos; NumumPonto;" +
				" NumOutro; NãoCruzados; taxaMutacao; SerMutado; Nummutacao; NumElitismo; media\n");
		while(ag.getCaminhos().size()>10 && i < 150){
			i++;
			int tvec = ag.getCaminhos().size();
			ios.append("geração: " + i + ": \n");
			ios.append(ag.getCaminhos().toString() + "\n");
			ios.append("melhor indivíduo da geração:" + ag.melhor() + "\n");
			ag.populacao(cond);
			csv.append(i + "; " + tvec + "; " + ag.getCaminhos().size() + "; " + ag + ag.media() + "\n");
			if(lm >= ag.media()) {
				lm = ag.media();
				melhorGeracao = i;
			}
			if(i >= verificar) {
				if (lm < ag.media()) {
					ios.append("melhor valor é da geração " + melhorGeracao + "!!!!\n");
					break;
				}
				verificar += 10;
			}
		}
		ios.append("______________________________________________________________________________________________________________________________\n");
		ag.ordenador(ag.getCaminhos());
		csv.append("\n");
		csv.flush();
		csv.close();
		ios.flush();
		ios.close();
	}
}
