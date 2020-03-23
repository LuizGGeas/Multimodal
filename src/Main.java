/**
 * @author LuizGabriel
 * @version 2.3
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    
        ObjectOutputStream ios = new ObjectOutputStream(new FileOutputStream("geracoes.txt"));
    
        ArrayList<Aresta> arestas = new CArestas().getArestas();
        Grafo g = new Grafo(27, arestas);
        AGenetico ag = new AGenetico(g.getMatriz(), new ArrayList<>(), 0, 26);
        for (int i = 0; i < 100; i++) {
            ag.caminhoR();
        }
        int lm = 9999999;
        int i = 0;
        do{
            System.out.println("iniciando variação genética");
            i++;
            ios.writeChars("geração: " + i + ": \n");
            ios.writeChars(ag.getCaminhos().toString() + "\n");
            ios.writeChars("melhor indivíduo da geração:" + ag.melhor() + "\n");
            ag.populacao();
            if (lm < ag.media()) {
                ios.writeChars("melhor valor é da geração anterior!!!!");
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
        ios.close();
    }
}
