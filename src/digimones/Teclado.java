package digimones;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Teclado {

	
	// Se inicializan 3 scanners, uno por cada tipo de dato, para evitar errores de buffer con los cambios de tipo
	
	private static Scanner strings=new Scanner(System.in);
	private static Scanner ints=new Scanner(System.in);
	private static Scanner doubles=new Scanner(System.in);
	
	// Pide un string por teclado
	
	public static String nextLine() {
		
		String str=null;
		
		do {
			str=strings.nextLine();
			
			// si el string es null o está vacío, seguimos pidiendole el dato al usuario
			
		}while(str==null||str.isEmpty());
		
		return str;	
	}	
	
	// Pide un int por teclado
	
	public static int nextInt() {
		
		int num=-1;
		try {
			num = ints.nextInt();
		} catch (InputMismatchException e) {  // Esta excepcion controla que el dato introducido sea un numero
			num=-1;
			ints.next();
			e.printStackTrace();
			System.out.println("Asignando el numero \"-1\" al teclado debido a un error...");
		}
		
		return num;
	}
	
	// Pide un double por teclado
	
	public static double nextDouble() {
		double num=-1;
		try {
			num = doubles.nextDouble();
		} catch (InputMismatchException e) { // Esta excepcion controla que el dato introducido sea un numero
			num=-1;
			doubles.next();
			e.printStackTrace();
			System.out.println("Asignando el numero \"-1\" al teclado debido a un error...");
		}
		
		return num;
	}	
}

