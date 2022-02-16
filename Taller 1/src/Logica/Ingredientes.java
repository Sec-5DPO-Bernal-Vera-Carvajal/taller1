package Logica;

public class Ingredientes {

	public Ingredientes(String pnombre, int costo) {
		nombre=pnombre;
		costoAdicional=costo;
		// TODO Auto-generated constructor stub
	}
	private String nombre;
	private int costoAdicional;
	
	
	public String getNombre() {
		return nombre;
		
	}
	public int getCosto() {
		return costoAdicional;
		
	}
}
