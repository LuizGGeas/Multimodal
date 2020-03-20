/**
 * @author LuizGabriel
 * @version 1.0
 */

import java.util.*;

public class Main {

    public static void main(String[] args) {
    
        ArrayList<Aresta> arestas = new CArestas().getArestas();
        Grafo g = new Grafo(27, arestas);
        AGenetico ag = new AGenetico(g.getMatriz(), new ArrayList<>());
        for (int i = 0; i < 100; i++) {
            ag.caminhoR();
        }
        
        while(ag.getCaminhos().size()>10) {
            ag.populacao();
        }
        System.out.println(ag.getCaminhos().get(0));
    }
}
