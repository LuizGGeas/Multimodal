import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Luiz Gabriel de S. N.
 * @version 1.0
 * <p>
 * Função para criação de arestas e retorno destas
 */
class CArestas {
	
	private final ArrayList<Aresta> arestas = new ArrayList<>();
	
	AGenetico getGrafo1() {
		
		
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
		
		
		arestas.addAll(Arrays.asList(r1));
		
		return new AGenetico(new Grafo(27, arestas).getMatriz(), new ArrayList<>(), 0,26,27);
	}
	
	AGenetico getGrafo() {
		Aresta[] r1 = new Aresta[59];
		
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
		
		arestas.addAll(Arrays.asList(r1));
		return new AGenetico(new Grafo(21,arestas).getMatriz(), new ArrayList<>(), 1, 20,21);
	}
	
	AGenetico getGrafo2(){
		Aresta[] r1= new Aresta[210];
		
		r1[0] = new Aresta(1, 2, 206, Types.PRIVADO);
		r1[1] = new Aresta(1, 3, 259, Types.PRIVADO);
		r1[2] = new Aresta(1, 4, 349, Types.ONIBUS);
		r1[3] = new Aresta(2, 3, 186, Types.ONIBUS);
		r1[4] = new Aresta(2, 4, 220, Types.TREM);
		r1[5] = new Aresta(2, 9, 354, Types.TREM);
		r1[6] = new Aresta(3, 5, 109, Types.TREM);
		r1[7] = new Aresta(3, 9, 456, Types.TREM);
		r1[8] = new Aresta(3, 12, 451, Types.TREM);
		r1[9] = new Aresta(3, 13, 602, Types.ONIBUS);
		r1[10] = new Aresta(3, 23, 875, Types.ONIBUS);
		r1[11] = new Aresta(4, 10, 137, Types.ONIBUS);
		r1[12] = new Aresta(4, 11, 512, Types.ONIBUS);
		r1[13] = new Aresta(5, 6, 127, Types.ONIBUS);
		r1[14] = new Aresta(5, 12, 368, Types.ONIBUS);
		r1[15] = new Aresta(6, 7, 126, Types.ONIBUS);
		r1[16] = new Aresta(6, 8, 239, Types.ONIBUS);
		r1[17] = new Aresta(6, 12, 277, Types.ONIBUS);
		r1[18] = new Aresta(6, 14, 437, Types.ONIBUS);
		r1[19] = new Aresta(6, 17, 461, Types.TRANSFERENCIA);
		r1[20] = new Aresta(6, 22, 623, Types.ONIBUS);
		r1[21] = new Aresta(6, 26, 850, Types.TREM);
		r1[22] = new Aresta(7, 8, 120, Types.TREM);
		r1[23] = new Aresta(7, 14, 380, Types.PRIVADO);
		r1[24] = new Aresta(7, 15, 305, Types.PRIVADO);
		r1[25] = new Aresta(7, 17, 364, Types.TRANSFERENCIA);
		r1[26] = new Aresta(7, 18, 778, Types.TRANSFERENCIA);
		r1[27] = new Aresta(8, 15, 293, Types.TRANSFERENCIA);
		r1[28] = new Aresta(8, 17, 406, Types.ONIBUS);
		r1[29] = new Aresta(9, 11, 58, Types.ONIBUS);
		r1[30] = new Aresta(9, 13, 229, Types.TREM);
		r1[31] = new Aresta(9, 21, 317, Types.TREM);
		r1[32] = new Aresta(10, 11, 297, Types.TREM);
		r1[33] = new Aresta(10, 20, 600, Types.PRIVADO);
		r1[34] = new Aresta(11, 20, 547, Types.ONIBUS);
		r1[35] = new Aresta(11, 21, 275, Types.ONIBUS);
		r1[36] = new Aresta(12, 13, 154, Types.PRIVADO);
		r1[37] = new Aresta(12, 14, 272, Types.PRIVADO);
		r1[38] = new Aresta(12, 22, 350, Types.ONIBUS);
		r1[39] = new Aresta(13, 14, 332, Types.ONIBUS);
		r1[40] = new Aresta(13, 21, 196, Types.TREM);
		r1[41] = new Aresta(13, 22, 295, Types.PRIVADO);
		r1[42] = new Aresta(13, 23, 366, Types.PRIVADO);
		r1[43] = new Aresta(13, 31, 412, Types.ONIBUS);
		r1[44] = new Aresta(13, 40, 814, Types.TREM);
		r1[45] = new Aresta(14, 17, 311, Types.TREM);
		r1[46] = new Aresta(14, 22, 238, Types.TRANSFERENCIA);
		r1[47] = new Aresta(14, 24, 646, Types.TRANSFERENCIA);
		r1[48] = new Aresta(14, 25, 304, Types.TRANSFERENCIA);
		r1[49] = new Aresta(14, 26, 409, Types.PRIVADO);
		r1[50] = new Aresta(15, 17, 234, Types.PRIVADO);
		r1[51] = new Aresta(15, 16, 200, Types.ONIBUS);
		r1[52] = new Aresta(16, 17, 258, Types.TRANSFERENCIA);
		r1[53] = new Aresta(16, 18, 280, Types.ONIBUS);
		r1[54] = new Aresta(16, 24, 396, Types.TREM);
		r1[55] = new Aresta(17, 18, 491, Types.TREM);
		r1[56] = new Aresta(17, 24, 299, Types.PRIVADO);
		r1[57] = new Aresta(17, 26, 491, Types.PRIVADO);
		r1[58] = new Aresta(18, 19, 80, Types.TREM);
		r1[59] = new Aresta(18, 24, 419, Types.ONIBUS);
		r1[60] = new Aresta(19, 24, 347, Types.ONIBUS);
		r1[61] = new Aresta(19, 27, 124, Types.TRANSFERENCIA);
		r1[62] = new Aresta(20, 21, 420, Types.PRIVADO);
		r1[63] = new Aresta(20, 29, 528, Types.TREM);
		r1[64] = new Aresta(20, 30, 514, Types.TREM);
		r1[65] = new Aresta(20, 31, 589, Types.PRIVADO);
		r1[66] = new Aresta(20, 32, 540, Types.PRIVADO);
		r1[67] = new Aresta(20, 37, 510, Types.TRANSFERENCIA);
		r1[68] = new Aresta(20, 39, 725, Types.ONIBUS);
		r1[69] = new Aresta(21, 22, 328, Types.ONIBUS);
		r1[70] = new Aresta(21, 23, 328, Types.TREM);
		r1[71] = new Aresta(21, 31, 335, Types.TREM);
		r1[72] = new Aresta(22, 23, 137, Types.TREM);
		r1[73] = new Aresta(22, 25, 120, Types.PRIVADO);
		r1[74] = new Aresta(22, 24, 577, Types.PRIVADO);
		r1[75] = new Aresta(22, 33, 418, Types.PRIVADO);
		r1[76] = new Aresta(23, 25, 133, Types.PRIVADO);
		r1[77] = new Aresta(23, 31, 216, Types.ONIBUS);
		r1[78] = new Aresta(23, 33, 290, Types.TRANSFERENCIA);
		r1[79] = new Aresta(24, 26, 300, Types.ONIBUS);
		r1[80] = new Aresta(24, 28, 178, Types.ONIBUS);
		r1[81] = new Aresta(24, 27, 329, Types.ONIBUS);
		r1[82] = new Aresta(24, 34, 497, Types.TREM);
		r1[83] = new Aresta(24, 36, 622, Types.TREM);
		r1[84] = new Aresta(25, 26, 206, Types.TREM);
		r1[85] = new Aresta(25, 33, 319, Types.TREM);
		r1[86] = new Aresta(26, 28, 228, Types.ONIBUS);
		r1[87] = new Aresta(26, 31, 550, Types.ONIBUS);
		r1[88] = new Aresta(26, 33, 372, Types.ONIBUS);
		r1[89] = new Aresta(26, 34, 247, Types.PRIVADO);
		r1[90] = new Aresta(27, 28, 356, Types.TRANSFERENCIA);
		r1[91] = new Aresta(27, 35, 494, Types.PRIVADO);
		r1[92] = new Aresta(28, 34, 276, Types.ONIBUS);
		r1[93] = new Aresta(28, 35, 289, Types.ONIBUS);
		r1[94] = new Aresta(28, 36, 413, Types.PRIVADO);
		r1[95] = new Aresta(29, 37, 193, Types.PRIVADO);
		r1[96] = new Aresta(29, 38, 485, Types.PRIVADO);
		r1[97] = new Aresta(30, 31, 114, Types.TRANSFERENCIA);
		r1[98] = new Aresta(30, 32, 96, Types.TRANSFERENCIA);
		r1[99] = new Aresta(31, 32, 172, Types.TRANSFERENCIA);
		r1[100] = new Aresta(31, 33, 355, Types.ONIBUS);
		r1[101] = new Aresta(31, 40, 408, Types.ONIBUS);
		r1[102] = new Aresta(31, 41, 606, Types.TREM);
		r1[103] = new Aresta(32, 37, 402, Types.TREM);
		r1[104] = new Aresta(32, 39, 324, Types.PRIVADO);
		r1[105] = new Aresta(32, 40, 346, Types.PRIVADO);
		r1[106] = new Aresta(33, 34, 348, Types.TRANSFERENCIA);
		r1[107] = new Aresta(33, 39, 664, Types.TRANSFERENCIA);
		r1[108] = new Aresta(33, 40, 438, Types.TRANSFERENCIA);
		r1[109] = new Aresta(33, 41, 306, Types.TREM);
		r1[110] = new Aresta(33, 46, 427, Types.PRIVADO);
		r1[111] = new Aresta(33, 47, 398, Types.ONIBUS);
		r1[112] = new Aresta(33, 49, 385, Types.ONIBUS);
		r1[113] = new Aresta(34, 35, 230, Types.ONIBUS);
		r1[114] = new Aresta(34, 41, 551, Types.TREM);
		r1[115] = new Aresta(34, 46, 158, Types.ONIBUS);
		r1[116] = new Aresta(35, 36, 211, Types.TREM);
		r1[117] = new Aresta(35, 46, 311, Types.PRIVADO);
		r1[118] = new Aresta(35, 49, 494, Types.ONIBUS);
		r1[119] = new Aresta(36, 48, 436, Types.TREM);
		r1[120] = new Aresta(36, 49, 594, Types.ONIBUS);
		r1[121] = new Aresta(37, 38, 351, Types.ONIBUS);
		r1[122] = new Aresta(37, 39, 174, Types.ONIBUS);
		r1[123] = new Aresta(37, 42, 304, Types.ONIBUS);
		r1[124] = new Aresta(38, 43, 143, Types.TREM);
		r1[125] = new Aresta(39, 40, 283, Types.TREM);
		r1[126] = new Aresta(39, 42, 456, Types.ONIBUS);
		r1[127] = new Aresta(39, 44, 445, Types.PRIVADO);
		r1[128] = new Aresta(39, 50, 282, Types.TRANSFERENCIA);
		r1[129] = new Aresta(39, 53, 685, Types.PRIVADO);
		r1[130] = new Aresta(39, 56, 1045, Types.TREM);
		r1[131] = new Aresta(40, 41, 232, Types.TREM);
		r1[132] = new Aresta(40, 44, 162, Types.TRANSFERENCIA);
		r1[133] = new Aresta(41, 44, 216, Types.TRANSFERENCIA);
		r1[134] = new Aresta(41, 45, 91, Types.TREM);
		r1[135] = new Aresta(41, 46, 448, Types.TREM);
		r1[136] = new Aresta(41, 47, 442, Types.TREM);
		r1[137] = new Aresta(42, 43, 188, Types.TRANSFERENCIA);
		r1[138] = new Aresta(42, 50, 288, Types.TRANSFERENCIA);
		r1[139] = new Aresta(42, 51, 613, Types.TREM);
		r1[140] = new Aresta(42, 52, 232, Types.TREM);
		r1[141] = new Aresta(43, 51, 429, Types.TRANSFERENCIA);
		r1[142] = new Aresta(43, 52, 490, Types.TREM);
		r1[143] = new Aresta(44, 45, 194, Types.PRIVADO);
		r1[144] = new Aresta(44, 50, 208, Types.PRIVADO);
		r1[145] = new Aresta(44, 53, 695, Types.PRIVADO);
		r1[146] = new Aresta(44, 54, 594, Types.TRANSFERENCIA);
		r1[147] = new Aresta(44, 56, 646, Types.PRIVADO);
		r1[148] = new Aresta(44, 55, 810, Types.PRIVADO);
		r1[149] = new Aresta(45, 47, 342, Types.TRANSFERENCIA);
		r1[150] = new Aresta(45, 56, 634, Types.TREM);
		r1[151] = new Aresta(45, 57, 857, Types.TREM);
		r1[152] = new Aresta(46, 47, 398, Types.TRANSFERENCIA);
		r1[153] = new Aresta(46, 49, 385, Types.TREM);
		r1[154] = new Aresta(47, 49, 247, Types.TREM);
		r1[155] = new Aresta(47, 55, 311, Types.TRANSFERENCIA);
		r1[156] = new Aresta(47, 56, 754, Types.PRIVADO);
		r1[157] = new Aresta(48, 49, 289, Types.ONIBUS);
		r1[158] = new Aresta(48, 58, 902, Types.PRIVADO);
		r1[159] = new Aresta(49, 55, 436, Types.PRIVADO);
		r1[160] = new Aresta(49, 58, 708, Types.TRANSFERENCIA);
		r1[161] = new Aresta(50, 53, 414, Types.PRIVADO);
		r1[162] = new Aresta(51, 59, 572, Types.ONIBUS);
		r1[163] = new Aresta(52, 53, 457, Types.PRIVADO);
		r1[164] = new Aresta(52, 59, 997, Types.ONIBUS);
		r1[165] = new Aresta(52, 60, 832, Types.ONIBUS);
		r1[166] = new Aresta(53, 54, 345, Types.PRIVADO);
		r1[167] = new Aresta(53, 60, 730, Types.PRIVADO);
		r1[168] = new Aresta(53, 61, 884, Types.TRANSFERENCIA);
		r1[169] = new Aresta(54, 56, 114, Types.ONIBUS);
		r1[170] = new Aresta(54, 61, 516, Types.PRIVADO);
		r1[171] = new Aresta(55, 56, 508, Types.PRIVADO);
		r1[172] = new Aresta(55, 57, 346, Types.PRIVADO);
		r1[173] = new Aresta(55, 58, 498, Types.TRANSFERENCIA);
		r1[174] = new Aresta(56, 57, 536, Types.ONIBUS);
		r1[175] = new Aresta(56, 60, 953, Types.ONIBUS);
		r1[176] = new Aresta(56, 61, 596, Types.TREM);
		r1[177] = new Aresta(56, 63, 902, Types.TRANSFERENCIA);
		r1[178] = new Aresta(57, 58, 320, Types.TREM);
		r1[179] = new Aresta(57, 61, 744, Types.ONIBUS);
		r1[180] = new Aresta(57, 62, 556, Types.ONIBUS);
		r1[181] = new Aresta(57, 63, 692, Types.ONIBUS);
		r1[182] = new Aresta(57, 69, 1309, Types.ONIBUS);
		r1[183] = new Aresta(57, 70, 950, Types.ONIBUS);
		r1[184] = new Aresta(58, 62, 485, Types.TRANSFERENCIA);
		r1[185] = new Aresta(59, 60, 239, Types.TRANSFERENCIA);
		r1[186] = new Aresta(59, 64, 644, Types.TRANSFERENCIA);
		r1[187] = new Aresta(59, 66, 899, Types.TRANSFERENCIA);
		r1[188] = new Aresta(60, 61, 599, Types.TRANSFERENCIA);
		r1[189] = new Aresta(60, 64, 377, Types.TREM);
		r1[190] = new Aresta(60, 65, 569, Types.TREM);
		r1[191] = new Aresta(61, 63, 517, Types.ONIBUS);
		r1[192] = new Aresta(61, 65, 409, Types.TRANSFERENCIA);
		r1[193] = new Aresta(61, 68, 602, Types.ONIBUS);
		r1[194] = new Aresta(62, 63, 344, Types.TREM);
		r1[195] = new Aresta(62, 70, 455, Types.TRANSFERENCIA);
		r1[196] = new Aresta(63, 68, 532, Types.ONIBUS);
		r1[197] = new Aresta(63, 70, 346, Types.TREM);
		r1[198] = new Aresta(64, 65, 445, Types.TRANSFERENCIA);
		r1[199] = new Aresta(64, 66, 341, Types.ONIBUS);
		r1[200] = new Aresta(64, 67, 419, Types.TREM);
		r1[201] = new Aresta(65, 66, 592, Types.TREM);
		r1[202] = new Aresta(65, 67, 520, Types.TREM);
		r1[203] = new Aresta(65, 68, 503, Types.TRANSFERENCIA);
		r1[204] = new Aresta(66, 67, 208, Types.TRANSFERENCIA);
		r1[205] = new Aresta(67, 68, 799, Types.TRANSFERENCIA);
		r1[206] = new Aresta(67, 69, 766, Types.ONIBUS);
		r1[207] = new Aresta(68, 69, 263, Types.ONIBUS);
		r1[208] = new Aresta(68, 70, 601, Types.TRANSFERENCIA);
		r1[209] = new Aresta(69, 70, 452, Types.TRANSFERENCIA);
		
		arestas.addAll(Arrays.asList(r1));
		return new AGenetico(new Grafo(210,arestas).getMatriz(), new ArrayList<>(), 1, 70,71);
		
	}
}
