package Logica;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Restaurante {

	private int idPedido;
	private String nombreCliente;
	private String direccionCliente;
	private boolean enCurso = false;
	
	public void iniciarPedido(String nombreCliente, String direccionCliente) {
		this.nombreCliente=nombreCliente;
		this.direccionCliente=direccionCliente;
		enCurso=true;
	}
	
	
	
	public static ArrayList cargarIngredientes() throws FileNotFoundException {
		InputStream ins = new FileInputStream("C:\\Users\\User\\Downloads\\Taller 1 - Hamburguesas_esqueleto\\data\\ingredientes.txt");
	    Scanner obj = new Scanner(ins);
	    String variable;
	    
	    ArrayList nombreArray = new ArrayList();
	    Map<String, String> mapa = new HashMap<String, String>();
	    while (obj.hasNextLine()) {
	    	
	    	ArrayList lista = new ArrayList();
	    	variable= obj.nextLine();
	    	String[] partes = variable.split(";");              

	    	
	    	
	    	//System.out.println(variable);
	    
		 mapa.put(partes[0],partes[1]);
		 int cambio= Integer.parseInt (partes[1]);
		 Ingredientes ingredientes= new Ingredientes (partes[0],cambio);
		 nombreArray.add(ingredientes);
		
	}
		return nombreArray;
}
	
public static ArrayList cargarCombos() throws FileNotFoundException {
	InputStream ins = new FileInputStream("C:\\Users\\User\\Downloads\\Taller 1 - Hamburguesas_esqueleto\\data\\combos.txt");
    Scanner obj = new Scanner(ins);
    String variable;
    
    ArrayList nombreArray = new ArrayList();
    Map<String, String> mapa = new HashMap<String, String>();
    while (obj.hasNextLine()) {
    	
    	ArrayList lista = new ArrayList();
    	variable= obj.nextLine();
    	String[] partes = variable.split(";");              

    	
    	
    	//System.out.println(variable);
    
	 
	
	 Combo combo= new Combo (partes[0],partes[1],partes[2],partes[3],partes[4]);
	 nombreArray.add(combo);
	 
}
	System.out.println(nombreArray);
	return nombreArray;
}

public static ArrayList cargarMenu() throws FileNotFoundException {
	InputStream ins = new FileInputStream("C:\\Users\\User\\Downloads\\Taller 1 - Hamburguesas_esqueleto\\data\\menu.txt");
    Scanner obj = new Scanner(ins);
    String variable;
    
    ArrayList nombreArray = new ArrayList();
    Map<String, String> mapa = new HashMap<String, String>();
    while (obj.hasNextLine()) {
    	
    	ArrayList lista = new ArrayList();
    	variable= obj.nextLine();
    	String[] partes = variable.split(";");              

    	
    	
    	//System.out.println(variable);
    
	 
	 int cambio= Integer.parseInt (partes[1]);
	 Menu menu= new Menu (partes[0],cambio);
	 nombreArray.add(menu);
	 
}
    return nombreArray;
}
}