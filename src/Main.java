/**
 * @author LuizGabriel
 * @version 1.0
 */

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    
        ArrayList<Aresta> arestas = new CArestas().getArestas();
        Grafo g = new Grafo(27, arestas);
        AGenetico ag = new AGenetico(g.getMatriz(), new ArrayList<>());
        for (int i = 0; i < 100; i++) {
            ag.caminhoR();
        }
        int lm = 0;
        while(ag.getCaminhos().size()>10) {
            ag.populacao();
            System.out.println(ag.getCaminhos().size());
            if (lm == ag.media())
                break;
            lm = ag.media();
            System.in.read();
        }
        System.out.println(ag.getCaminhos().get(0));
    }
}
