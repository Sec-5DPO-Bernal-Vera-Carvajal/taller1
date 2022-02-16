package Consola;
import Logica.Menu;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Logica.Combo;
import Logica.Ingredientes;
import Logica.Menu;
import Logica.Restaurante;

public class Consola {
	
	public static void main(String args[]) throws FileNotFoundException {
		ejecutarApp();
	}
	
	
	public static void mostrarOpciones() throws FileNotFoundException {
		
		 
		 System.out.println("1.Cargar menu ");
		 System.out.println("2.Cargar combos y agregar adición en base al combo seleccionado ");
		 
		 System.out.println("3.Solicitar info");
		 System.out.println("4.Asignar pedido");
		 System.out.println("5.salir");
		 
		 
		 
		 
		 }
	public static void ejecutarApp() throws FileNotFoundException, NumberFormatException {
		boolean continuar = true;
		while (continuar)
		{
		mostrarOpciones();
		int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
		
		if (opcion_seleccionada == 1)
			cargarArchivos1();
		
		
		else if (opcion_seleccionada == 2)
			cargarCombos();
		else if (opcion_seleccionada == 3 )
			pedirInfo();
		else if (opcion_seleccionada == 4 )
			asignarPedido();
		else if (opcion_seleccionada == 5)
		{
			System.out.println("Saliendo");
			continuar = false;
		}
		}
		
	}
	
	public static String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}

	
	
	public static void cargarArchivos() throws FileNotFoundException {
		System.out.println("Ejecutar carga de archivos");
		ArrayList variable = Logica.Restaurante.cargarMenu();
		
		int i = 0;
        while (i < variable.size()) {
            
            Combo variable1=  (Combo) variable.get(i);
            System.out.println(variable1.darNombre());
            i++;
        }
		
	}
	public static void crearPedido() throws FileNotFoundException {
		cargarArchivos();
		
	}
	
	public static void cargarArchivos1() throws FileNotFoundException {
		System.out.println("Ejecutar carga de archivos");
		ArrayList variable = Logica.Restaurante.cargarMenu();
		System.out.println(variable);
		for(int i = 0; i <= variable.size()-1; i++) {
			String numCadena= i+"";
			Menu variable1 = (Menu) variable.get(i);
			System.out.println( numCadena + ". Nombre: " + variable1.getNombre() + " precio " + variable1.getPrecio());
			
			
			
			
		}
		int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
		Menu variable2 = (Menu) variable.get(opcion_seleccionada);
		String numCadena;
		Menu variable1;
		System.out.println( "El usuario ha elegido el menu numero "+opcion_seleccionada+" "  + ((Menu) variable.get(opcion_seleccionada)).getNombre());
	}
	
	public static void pedirInfo() {
		String nombre = input("Inserte su nombre ");
		String dirreción = input("Inserte su dirección ");
		System.out.println( "Info recibida");
	}

	public static void cargarCombos() throws FileNotFoundException {
		System.out.println("Ejecutar carga de archivos");
		ArrayList variable = Logica.Restaurante.cargarCombos();
		ArrayList menu = Logica.Restaurante.cargarMenu();
		
		for(int i = 0; i <= variable.size()-1; i++) {
			String numCadena= i+"";
			Combo variable1 = (Combo) variable.get(i);
			int costoHam=0;
			String Hamburguesa=variable1.darHamburguesa();
			
			System.out.println( numCadena + ". Nombre: " + variable1.darNombre() + " precio " + variable1.darDescuento() +","  + variable1.darHamburguesa() + "," + variable1.darBebida() + "," + variable1.darPapas());
			
			
			
			
		}
		int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
		Combo variable2 = (Combo) variable.get(opcion_seleccionada);
		
		System.out.println( "El usuario ha elegido el menu numero "+opcion_seleccionada+" "  + ((Combo) variable.get(opcion_seleccionada)).darNombre());
		
		Combo combo1= (Combo) variable.get(opcion_seleccionada);
		String hamburguesa= combo1.darHamburguesa();
		String bebida= combo1.darBebida();
		String papas= combo1.darPapas();
		int precio= 0;
		for(int j = 0; j <= menu.size()-1; j++) {
			Menu elemento = (Menu) menu.get(j);
			
			if(elemento.getNombre().equals(hamburguesa))
				precio+=elemento.getPrecio();
			if(elemento.getNombre().equals(bebida))
				precio+=elemento.getPrecio();
			if(elemento.getNombre().equals(papas))
				precio+=elemento.getPrecio();
			
			
			
		}
		String[] descuento= combo1.darDescuento().split("%");
		double descuento1= Double.parseDouble(descuento[0]);
		
		String costo=  precio - descuento1*precio/100+"";
		System.out.println("El combo seleccionado tiene un costo de " + costo);
		System.out.println(adiciones(descuento1));
	}
	
	public static double adiciones(double descuento1) throws FileNotFoundException {
		
		System.out.println("Ejecutar carga de archivos");
		ArrayList variable = Logica.Restaurante.cargarIngredientes();
		System.out.println(variable);
		for(int i = 0; i <= variable.size()-1; i++) {
			String numCadena= i+"";
			Ingredientes variable1 = (Ingredientes) variable.get(i);
			System.out.println( numCadena + ". Nombre: " + variable1.getNombre() + " precio " + variable1.getCosto()+"" );
			
			
		descuento1+=variable1.getCosto();	
		
		}
		int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
		Ingredientes variable2 = (Ingredientes) variable.get(opcion_seleccionada);
		String numCadena;
		Menu variable1;
		System.out.println( "El usuario ha elegido el menu numero "+opcion_seleccionada+" "  + ((Ingredientes) variable.get(opcion_seleccionada)).getNombre());
		System.out.println("Costo total:"); 
		return descuento1;
	}
	
	public static void asignarPedido() {
		int variable = (int) (Math.random()*100);
		System.out.println("Su pedido es el numero: ");
		System.out.println(variable);
	}
	}
	
	


	
	
	
	

