package Logica;


public class Combo extends Restaurante{
	public Combo(String string, String cambio,String hamburguesa, String papas, String bebida  ) {
		nombreCombo=string;
		descuento= cambio;
		this.hamburguesa=hamburguesa;
		this.papas=papas;
		this.bebida=bebida;
		// TODO Auto-generated constructor stub
	}
	private String nombreCombo;
	private String descuento;
	private String hamburguesa;
	private String papas;
	private String bebida;
	public void agregarItemACombo(Producto itemCombo) {
		
	}
	
	public String darNombre() {
		return nombreCombo;
	}
		
	public String darDescuento() {
		return descuento;
	}
	public String darHamburguesa() {
		return hamburguesa;
	}
	public String darPapas() {
		return papas;
	}
	public String darBebida() {
		return bebida;
	}
}
