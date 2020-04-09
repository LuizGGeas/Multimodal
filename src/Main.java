/**
 * @author LuizGabriel
 * @version 2.3
 */

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
	
	
	    FileWriter ios = new FileWriter("geracoes.txt", true);
    	
        ArrayList<Aresta> arestas = new CArestas().getArestas();
        Grafo g = new Grafo(27, arestas);
        AGenetico ag = new AGenetico(g.getMatriz(), new ArrayList<>(), 0, 26);
        for (int i = 0; i < 100; i++) {
            ag.caminhoR();
        }
        int lm = 9999999;
        int i = 0;
        do{
        	ios.flush();
            System.out.println("iniciando variação genética");
            i++;
            ios.write("geração: " + i + ": \n");
            ios.write(ag.getCaminhos().toString() + "\n");
            ios.write("melhor indivíduo da geração:" + ag.melhor() + "\n");
            ag.populacao();
            if (lm < ag.media()) {
                ios.write("melhor valor é da geração anterior!!!!");
                System.out.println("deveria retornar à iteração anterior");
                break;
            }
            lm = ag.media();
            System.out.println("número de caminhos guardados: " + ag.getCaminhos().size());
            System.out.println("aperte enter para a próxima geração");
            System.in.read();
    
        }while(ag.getCaminhos().size()>10);
        ag.ordenador(ag.getCaminhos());
        System.out.println(ag.getCaminhos());
        System.out.println(ag.getCaminhos().get(0));
        ios.write("______________________________________________________________________________________________________________________________");
        ios.close();
    }
}
