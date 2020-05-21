import java.io.*;
import java.nio.charset.StandardCharsets;

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
		execucao(200, true);
		execucao(200, false);
		
	}
	
	static void execucao(int tam, boolean cond) throws IOException {
		System.out.println("execução com população de tamanho " + tam);
		String local = System.getProperty("user.dir");
		String pasta = cond ? "Arredondado" : "NaoArredondado";
		FileWriter num = new FileWriter(local + "/src/populacao/"
				+ tam + "/" + pasta + "/exec.txt", true);
		BufferedReader br = new BufferedReader(new FileReader(local+"/src/populacao/"
				+ tam + "/" + pasta +  "/exec.txt"));
		int val = 0;
		while(br.readLine()!=null){
			val++;
		}
		val++;
		num.append("a\n");
		num.flush();
		num.close();
		br.close();
		FileWriter csv = new FileWriter(local + "/src/populacao/"
				+ tam + "/" + pasta +  "/tabelas/tabela"+ val +".csv");
		OutputStreamWriter ios = new OutputStreamWriter(new FileOutputStream(local + "/src/populacao/"+ tam + "/"
				+ pasta + "/populacao/populacao"+val+".txt"), StandardCharsets.ISO_8859_1);
		AGenetico ag =  new CArestas().returnee(3);


		for (int i = 0; i < tam; i++) {
			ag.caminhoR();
		}
		//double lm = ag.mediana();
		int i = 0;
		//int verificar = 10;
		//int melhorGeracao = 0;
		csv.append("geracao; tamanhoAntesOP; tamanhoDepoisOP; quantidadeCruzados; taxaCruzamento; " +
				"taxaMutacao; Nummutacao; NumElitismo; melhor; mediana;\n");
		while(ag.getCaminhos().size()>1 && i < 150){
			i++;
			int tvec = ag.getCaminhos().size();
			ios.append("geração: ").append(String.valueOf(i)).append(": \n");
			ios.append(ag.getCaminhos().toString()).append("\n");
			ios.append("melhor indivíduo da geração:").append(String.valueOf(ag.melhor())).append("\n");
			ag.populacao(tam);
			csv.append(String.valueOf(i)).append("; ")
					.append(String.valueOf(tvec)).append("; ")
					.append(String.valueOf(ag.getCaminhos().size())).append("; ")
					.append(String.valueOf(ag)).append(String.valueOf(ag.mediana())).append(";\n");
			/*if(lm >= ag.mediana()) {
				lm = ag.mediana();
				melhorGeracao = i;
			}
			if(i >= verificar) {
				if (lm < ag.mediana()) {
					ios.append("melhor valor é da geração ").append(String.valueOf(melhorGeracao)).append("!!!!\n");
					break;
				}
				verificar += 10;
			}*/
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
