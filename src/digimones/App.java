package digimones;

public class App {

	public static void main(String[] args) {
		
		int menuPrincipal=-1;
		
		System.out.println("Introduce tu nombre de domador");
		
		Domador jugador=new Domador(Teclado.nextLine());

		System.out.println(jugador);
		
		System.out.println("menu");
		
		menuPrincipal=Teclado.nextInt();
		
		
		 do{
			
			 switch(menuPrincipal) {
				 case 1:
					 BatallaDigital bd=new BatallaDigital();
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
