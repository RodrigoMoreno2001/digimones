package digimones;

public class App {

	public static void main(String[] args) {
		
		System.out.println("Introduce tu nombre de domador");
		
		Domador jugador=new Domador(Teclado.nextLine());

		System.out.println(jugador);
		
	}

}
