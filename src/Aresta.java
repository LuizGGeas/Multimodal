/**
 * @author LuizGabriel
 * @version 1.0
 */

public class Aresta {

	private int v1, v2;
	private int value;
	private Types transporte;
	
	Aresta(int v1, int v2, int value, Types transporte) {
		this.v1 = v1;
		this.v2 = v2;
		this.value = value;
		this.transporte = transporte;
	}
	
	int getv1(){
		return v1;
	}
	
	int getv2(){ return v2; }
	
	int getValue(){
		return value;
	}
	
	Types getTtransporte(){ return transporte; }
	
	@Override
	public String toString(){ return "("+v1 +","+v2 + "-"+ value + ")"; }
}