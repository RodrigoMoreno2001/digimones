package digimones;

import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * Esta clase busca solventar el problema al cambiar de tipos entre scanneres
 * y hacer el acceso a estos scanneres mucho más fácil e intuitivo
 */

public class Teclado {
	
	// se inicializan 3 scanners, uno por cada tipo de dato, para evitar errores de buffer con los cambios de tipo
	
	private static Scanner strings=new Scanner(System.in);
	private static Scanner ints=new Scanner(System.in);
	private static Scanner doubles=new Scanner(System.in);
	
	/**
	 * Pide un string por teclado
	 * @return el string dado por el usuario
	 */
	
	public static String nextLine() {		
		String str=null;
		do {
			str=strings.nextLine();
			
			// si el string es null o está vacío, seguimos pidiendole el dato al usuario
			
		}while(str==null||str.isEmpty());
		
		return str;	
	}	
	
	/**
	 * Pide un int por teclado
	 * @return el int dado por el usuario o -1 en caso de error
	 */
	
	public static int nextInt() {
		
		int num=-1;
		try {
			num = ints.nextInt();
		} catch (InputMismatchException e) {  // Esta excepcion controla que el dato introducido sea un numero
			num=-1;
			ints.next();
			System.err.println("Asignando el numero \"-1\" al teclado debido a un error...");
			System.err.println("Error de entrada: Se esperaba un numero entero");
		}
		
		return num;
	}
	
	/**
	 * Pide un double por teclado
	 * @return el double dado por el usuario o -1 en caso de error
	 */
	
	public static double nextDouble() {
		double num=-1;
		try {
			num = doubles.nextDouble();
		} catch (InputMismatchException e) {
			num=-1;
			doubles.next();
			System.err.println("Asignando el numero \"-1\" al teclado debido a un error...");
			System.err.println("Error de entrada: Se esperaba un numero decimal");
		}
		
		return num;
	}
}
