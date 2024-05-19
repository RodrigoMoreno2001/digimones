package digimones;

public class App {

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
	
	private static void comprobaciones(Domador jugador) {
		
		 if(jugador.ganador()) {
			 System.out.println("Felicidades has completado el reto de la Digivice!!!");
		 }else if(!jugador.estanVivos()) {
			 System.out.println("Game Over, suerte en tu próxima aventura...");
		 }	 
		 
	}
	
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