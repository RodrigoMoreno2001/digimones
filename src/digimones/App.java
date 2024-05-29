package digimones;

/**
 * @author rodri_2
 */

/**
 * Clase contenedora del método main y metodos de comprobaciones e impresión del menú 
 */

public class App {

	/**
	 * Aquí se va a ejecutar la aplicacion
	 * 
	 * @param args
	 */
	
	public static void main(String[] args) {
	
		int menuPrincipal=-1;
		
		Domador jugador=menuInicial();
		
		 do{
			
			System.out.println("""
					1.- Siguiente batalla
					2.- Salir
					""");
				
			menuPrincipal=Teclado.nextInt();
			 
			 switch(menuPrincipal) {
				 case 1:	
					 
					 BatallaDigital bd=new BatallaDigital(jugador);
					 bd.batalla();
					 bd=null;
					 
					 break;
				 case 2:
					 System.out.println("Saliendo...");
					 break;
				 default:
					 System.out.println("Esa opción no está en el menú...");
					 break;
			 }
			 
		}while(menuPrincipal!=2 && jugador.estanVivos() && !jugador.ganador());
		 
		 comprobaciones(jugador);
		 
	}
	
	/**
	 * Este método debe usarse una vez terminado el juego, comprobará el resultado de la partida
	 * 
	 * @param jugador
	 */
	
	private static void comprobaciones(Domador jugador) {
		
		 if(jugador.ganador()) {
			 System.out.println("Felicidades has completado el reto de la Digivice!!!");
		 }else if(!jugador.estanVivos()) {
			 System.out.println("Game Over, suerte en tu próxima aventura...");
		 }	 
		 
	}
	
	/**
	 * Contiene la funcionalidad relacionada a la obtención del digimon inicial
	 * 
	 * @return Objeto tipo Domador (Jugador construido)
	 */
	
	private static Domador menuInicial() {		
		
		System.out.println("Introduce tu nombre de domador");
		Domador jugador=new Domador(Teclado.nextLine());
		
		System.out.println("""
				+-----------------------------------------------------------+
				|                                                           |
				|            ¡¡¡Has recibido un digimon inicial!!!          |
				|          %-49s|
				|                                                           |
				+-----------------------------------------------------------+
				""".formatted(jugador.getEquipo().get(0)));
		return jugador;
	}	
}