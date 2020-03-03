/**
 * @author LuizGabriel
 * @version 1.0
 */

public enum Types {
	
	ONIBUS(1), TREM(2), PRIVADO(3), TRANSFERENCIA(4);
	
	int type;
	
	Types(int type){
		this.type = type;
	}
}