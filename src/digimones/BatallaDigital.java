package digimones;

public class BatallaDigital {
	
	private Domador jugador;
	private Digimon rival;
	private int digimonActual;
	private boolean captura;
	
	public BatallaDigital(Domador jugador) {
		
		this.jugador=jugador;
		this.rival=new Digimon();
		this.digimonActual=0;
		this.captura=true;
		
	}
	
	
	
	public void batalla() {
		int opt=-1;
		while(rival.getSalud()>0 && jugador.estanVivos()&&captura) {
			
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
					cambiarDigimon();
					break;
				case 3:
					liberarDigimon();
					break;
				default:
					System.out.println("Esa opción no existe...");
					break;
			}
			
		}				
	}

	private void lucha() {

		System.out.println("""
				1.- Ataque básico
				2.- Ataque especial
				3.- Capturar
				""");
		switch(Teclado.nextInt()) {
			case 1:
				jugador.getEquipo().get(digimonActual).atkDP1(rival);
				break;
			case 2:
				jugador.getEquipo().get(digimonActual).atkDP2(rival);
				break;
			case 3:
				jugador.capturarDigimon(rival);
				break;
			default:
				System.out.println("Elige una opción válida...");
				break;
		}

	}



	private void liberarDigimon() {
		
		System.out.println("Qué digimon quiere dejar ir...");
		listarEquipo();
		
	}

	private void listarEquipo() {
		
		for(int i=0;i<jugador.getEquipo().size();i++) {
			System.out.println((i+1)+".- "+jugador.getEquipo().get(i));
		}
	}

	private void cambiarDigimon() {
		System.out.println("Elige el próximo combatiente");
		listarEquipo();
		
	}
	
}
