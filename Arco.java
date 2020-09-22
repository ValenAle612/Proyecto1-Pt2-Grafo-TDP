package Graph;

public class Arco {
	
	private int n1; //nodo de origen
	private int n2; //nodo de destino
	
	public Arco(int n1,int n2) {
		this.n1=n1;
		this.n2=n2;
	}
	
	public Arco() {
		this.n1=0;
		this.n2=0;
	}
	
	public int getOrigen() {
		return this.n1;
	}
	
	public int getDestino() {
		return this.n2;
	}
	
	public void setOrigen(int o) {
		this.n1=o;
	}
	
	public void setDestino(int d) {
		this.n2=d;
	}

}
