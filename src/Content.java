
/**
 * @author LuizGabriel
 * @version.1.0
 *
 * Classe responsável por criar os elementos da matriz
 */

public class Content {
	
	private int value;
	private Types transporte;
	
	public int getValue(){
		return value;
	}
	
	public Types getTransporte(){
		return transporte;
	}
	
	public void setTransporte(Types transporte) {
		this.transporte = transporte;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
}
