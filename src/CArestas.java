import java.util.ArrayList;

public class CArestas {
	
	ArrayList<Aresta> arestas = new ArrayList<>();
	
	ArrayList<Aresta> getArestas() {
		
		Aresta[] r1 = new Aresta[41];
		
		
		r1[0] = new Aresta(0,1,1, Types.ONIBUS);
		r1[1] = new Aresta(0,2,1, Types.PRIVADO);
		r1[2] = new Aresta(2,4,9, Types.PRIVADO);
		r1[3] = new Aresta(2,9,6, Types.PRIVADO);
		r1[4] = new Aresta(4,9,7, Types.PRIVADO);
		r1[5] = new Aresta(4,6,7, Types.PRIVADO);
		r1[6] = new Aresta(6,23,19, Types.PRIVADO);
		r1[7] = new Aresta(6,25,7, Types.PRIVADO);
		r1[8] = new Aresta(9,23,15, Types.PRIVADO);
		r1[9] = new Aresta(25,23,6, Types.PRIVADO);
		r1[10] = new Aresta(23,26,5, Types.PRIVADO);
		r1[11] = new Aresta(25,26,10, Types.PRIVADO);
		r1[12] = new Aresta(1,3,5, Types.ONIBUS);
		r1[13] = new Aresta(1,5,4, Types.ONIBUS);
		r1[14] = new Aresta(5,24,4, Types.ONIBUS);
		r1[15] = new Aresta(10,24,7, Types.ONIBUS);
		r1[16] = new Aresta(24,15,3, Types.ONIBUS);
		r1[17] = new Aresta(10,11,7, Types.ONIBUS);
		r1[18] = new Aresta(11,15,4, Types.ONIBUS);
		r1[19] = new Aresta(15,17,5, Types.ONIBUS);
		r1[20] = new Aresta(15,22,7, Types.ONIBUS);
		r1[21] = new Aresta(17,20,7, Types.ONIBUS);
		r1[22] = new Aresta(17,21,5, Types.ONIBUS);
		r1[23] = new Aresta(22,20,7, Types.ONIBUS);
		r1[24] = new Aresta(20,21,4, Types.ONIBUS);
		r1[25] = new Aresta(21,26,4, Types.ONIBUS);
		r1[26] = new Aresta(7,8,5, Types.TREM);
		r1[27] = new Aresta(8,12,6, Types.TREM);
		r1[28] = new Aresta(12,19,7, Types.TREM);
		r1[29] = new Aresta(12,13,20, Types.TREM);
		r1[30] = new Aresta(13,16,7, Types.TREM);
		r1[31] = new Aresta(16,18,17, Types.TREM);
		r1[32] = new Aresta(18,19,7, Types.TREM);
		r1[33] = new Aresta(14,19,7, Types.TREM);
		r1[34] = new Aresta(19,26,5, Types.TREM);
		r1[35] = new Aresta(14,26,8, Types.TREM);
		r1[36] = new Aresta(3,7,5, Types.TREM);
		r1[37] = new Aresta(7,14,6, Types.TRANSFERENCIA);
		r1[38] = new Aresta(8,10,17, Types.TRANSFERENCIA);
		r1[39] = new Aresta(11,13,20, Types.TRANSFERENCIA);
		r1[40] = new Aresta(21,19,16, Types.TRANSFERENCIA);
		
		
		
		ArrayList<Aresta> arestas = new ArrayList<>();
		
		for(int i = 0; i < 41; i++){
			arestas.add(r1[i]);
		}
		
		return arestas;
	}
}
