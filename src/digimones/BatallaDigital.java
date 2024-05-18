package digimones;

public class BatallaDigital {
	
	// Atributos
	
	private Domador jugador;
	private Digimon rival;
	private boolean captura;
	
	// Constructores
	
	public BatallaDigital(Domador jugador) {
		
		this.jugador=jugador;
		this.rival=new Digimon();
		this.captura=false;
		
	}
	
	// Metodos
	
	public void batalla() {
		int opt=-1;
		do {
			
			System.out.println("Estás contra: "+rival);
			
			System.out.println("""
					1.- Luchar
					2.- Cambiar Digimon
					3.- Liberar Digimon
					""");
			
			opt=Teclado.nextInt();
			
			switch(opt) {
				
				case 1:
					lucha();
					break;
				case 2:
					jugador.cambiarDigimon();
					break;
				case 3:
					jugador.liberarDigimon();
					break;
				default:
					System.out.println("Esa opción no existe...");
					break;
			}
			
		}while(rival.getSalud()>0 && jugador.estanVivos()&&!captura);				
	}

	private void lucha() {

		System.out.println("""
				1.- Ataque básico
				2.- Ataque especial
				3.- Capturar
				""");
		switch(Teclado.nextInt()) {
			case 1:
				jugador.getEquipo().get(jugador.getDigimonActual()).atkDP1(rival);
				break;
			case 2:
				jugador.getEquipo().get(jugador.getDigimonActual()).atkDP2(rival);
				break;
			case 3:
				if(jugador.capturarDigimon(rival)) captura=true;
				break;
			default:
				System.out.println("Elige una opción válida...");
				break;
		}
	}
	
}
