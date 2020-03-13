/**
 * @author LuizGabriel
 * @version 1.0
 */

import java.util.*;

public class Main {

    public static void main(String[] args) {
    
        ArrayList<Aresta> arestas = new CArestas().getArestas();
        Grafo g = new Grafo(27, arestas);
        ArrayList<Caminho> caminhos = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Caminho path = g.caminhoR();
            System.out.println("Lista de nós percorridos: " + path.getPath());
            int fitness = path.getFitness();
            int trocas = path.getTrocas();
            System.out.println("Lista de transportes usados: " + path.getTrocaList());
            System.out.println("custo = " + fitness + ", " +  trocas +" trocas");
            if (g.validacao(path)) {
                caminhos.add(path);
            }
            System.out.println("----------------------------------------------------------------------");
        }
    
    
        if(!caminhos.isEmpty())
            System.out.println(caminhos);
      
         
        
        System.out.println("______________________________________________________________________________");
        
	    Caminho novo = g.cruzar(caminhos);
	    System.out.println(novo.getPath() +  " - " + novo.getFitness());
        System.out.println(g.validacao(novo));
        g.mutacao(caminhos);
        System.out.println(g.validacao(g.teste1()));
    }
}
