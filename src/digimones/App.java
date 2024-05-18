package digimones;

public class App {

	public static void main(String[] args) {
		
		int menuPrincipal=-1;
		BatallaDigital bd=null;
		System.out.println("Introduce tu nombre de domador");
		
		Domador jugador=new Domador(Teclado.nextLine());

		System.out.println("Has recibido un digimon inicial!!!");
		System.out.println(jugador.getEquipo().get(0));
		
		 do{
			
			System.out.println("""
					1.- Siguiente batalla
					2.- Salir
					""");
				
			menuPrincipal=Teclado.nextInt();
			 
			 switch(menuPrincipal) {
				 case 1:
					 
					 bd=new BatallaDigital(jugador);
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
			 
		}while(menuPrincipal!=2);
		
	}

}
