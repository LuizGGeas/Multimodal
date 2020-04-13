import java.util.ArrayList;

/**
 * @author Luiz Gabriel de S. N.
 * @version 1.0
 *
 * Função para criação de arestas e retorno destas
 */
public class CArestas {
	
	private int qnt;
	ArrayList<Aresta> arestas = new ArrayList<>();
	
	CArestas(int qnt){
		this.qnt = qnt;
	}
	
	ArrayList<Aresta> getArestas1() {
		
		
		Aresta[] r1 = new Aresta[qnt];
		
		
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
		
		
		for(int i = 0; i < qnt; i++){
			arestas.add(r1[i]);
		}
		
		return arestas;
	}
	
	ArrayList<Aresta> getArestas() {
		Aresta r1[] = new Aresta[qnt];
		
		r1[0] = new Aresta(1,2,7,Types.TREM);
		r1[1] = new Aresta(1,3,8,Types.ONIBUS);
		r1[2] = new Aresta(1,6,10,Types.PRIVADO);
		r1[3] = new Aresta(2,3,6,Types.PRIVADO);
		r1[4] = new Aresta(2,4,8,Types.PRIVADO);
		r1[5] = new Aresta(2,5,3,Types.TRANSFERENCIA);
		r1[6] = new Aresta(3,5,2,Types.ONIBUS);
		r1[7] = new Aresta(3,6,5,Types.ONIBUS);
		r1[8] = new Aresta(3,8,3,Types.TRANSFERENCIA);
		r1[9] = new Aresta(4,5,6,Types.TREM);
		r1[10] = new Aresta(4,10,5,Types.TREM);
		r1[11] = new Aresta(4,11,5,Types.TREM);
		r1[12] = new Aresta(5,8,7,Types.ONIBUS);
		r1[13] = new Aresta(5,10,8,Types.ONIBUS);
		r1[14] = new Aresta(5,11, -1, Types.ONIBUS);
		r1[15] = new Aresta(5,2,3,Types.TRANSFERENCIA);
		r1[16] = new Aresta(5,12,10,Types.TRANSFERENCIA);
		r1[17] = new Aresta(6,7,4,Types.PRIVADO);
		r1[18] = new Aresta(6,8,4,Types.PRIVADO);
		r1[19] = new Aresta(7,8,6,Types.PRIVADO);
		r1[20] = new Aresta(7,9,7,Types.ONIBUS);
		r1[21] = new Aresta(8,9,2,Types.PRIVADO);
		r1[22] = new Aresta(8,10,10,Types.TREM);
		r1[23] = new Aresta(8,3,3,Types.TRANSFERENCIA);
		r1[24] = new Aresta(9,10,10,Types.ONIBUS);
		r1[25] = new Aresta(9,12,7,Types.PRIVADO);
		r1[26] = new Aresta(9,16,7,Types.ONIBUS);
		r1[27] = new Aresta(9,13,15,Types.TRANSFERENCIA);
		r1[28] = new Aresta(10,12,10,Types.ONIBUS);
		r1[29] = new Aresta(10,13,10,Types.TREM);
		r1[30] = new Aresta(10,14,4,Types.TRANSFERENCIA);
		r1[31] = new Aresta(11,10,7,Types.ONIBUS);
		r1[32] = new Aresta(11,13,9,Types.ONIBUS);
		r1[33] = new Aresta(11,14,7,Types.TREM);
		r1[34] = new Aresta(12,5,10,Types.TRANSFERENCIA);
		r1[35] = new Aresta(12,13,5,Types.PRIVADO);
		r1[36] = new Aresta(12,19,10,Types.PRIVADO);
		r1[37] = new Aresta(12,16,5,Types.TRANSFERENCIA);
		r1[38] = new Aresta(13,9,15,Types.TRANSFERENCIA);
		r1[39] = new Aresta(13,15,3,Types.ONIBUS);
		r1[40] = new Aresta(13,19,3,Types.ONIBUS);
		r1[41] = new Aresta(13,14,8,Types.TRANSFERENCIA);
		r1[42] = new Aresta(14,10,4,Types.TRANSFERENCIA);
		r1[43] = new Aresta(14,13,8,Types.TRANSFERENCIA);
		r1[44] = new Aresta(14,15,5,Types.ONIBUS);
		r1[45] = new Aresta(15,19,7,Types.TRANSFERENCIA);
		r1[46] = new Aresta(15,20,2,Types.TREM);
		r1[47] = new Aresta(16,12,5,Types.TRANSFERENCIA);
		r1[48] = new Aresta(16,17,7,Types.ONIBUS);
		r1[49] = new Aresta(16,10,8,Types.TREM);
		r1[50] = new Aresta(17,18,8,Types.ONIBUS);
		r1[51] = new Aresta(17,19,12,Types.TRANSFERENCIA);
		r1[52] = new Aresta(18,12,9,Types.PRIVADO);
		r1[53] = new Aresta(18,13,10,Types.PRIVADO);
		r1[54] = new Aresta(18,19,10,Types.TRANSFERENCIA);
		r1[55] = new Aresta(18,20,-1,Types.ONIBUS);
		r1[56] = new Aresta(19,15,7,Types.TRANSFERENCIA);
		r1[57] = new Aresta(19,18,10,Types.TRANSFERENCIA);
		r1[58] = new Aresta(19,20,2,Types.PRIVADO);

		for(int i = 0; i < qnt; i++){
			arestas.add(r1[i]);
		}
		
		return arestas;
	}
}
