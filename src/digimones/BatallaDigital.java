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
		while(rival.getSalud()>0 && jugador.estanVivos()&&!captura) {
			
			while(jugador.getDigimonCombatiente().getSalud()<=0) jugador.cambiarDigimon();
			
			System.out.println("Estás contra: "+rival.getNombre()+" LVL: "+rival.getNivel()+" HP: "+rival.getSalud());
			System.out.println("Digimon combatiente: "+jugador.getDigimonCombatiente()+"\n");
			
			System.out.println("""
					1.- Luchar
					2.- Cambiar Digimon
					3.- Liberar Digimon
					""");
			
			opt=Teclado.nextInt();
			
			switch(opt) {
				
				case 1:
					if(lucha()) {
						luchaCPU();	
					}
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
			
		}
		
		if(rival.getSalud()<=0) {
			System.out.println("Has derrotado a un "+rival.getNombre()+" LVL "+rival.getNivel()+"...");
		}
		
		if(jugador.getDigimonCombatiente().getSalud()<=0) {
			System.out.println("Tu "+jugador.getDigimonCombatiente().getNombre()+" LVL: "+jugador.getDigimonCombatiente().getNivel()+" ha sido derrotado...");
		}
		
		if(!jugador.estanVivos()) {
			System.out.println("Ninguno de tus digimon puede seguir combatiendo...");
			return;
		}
	}

	private void luchaCPU() {

		if(rival.getSalud()<=0||captura) {
			return;
		}
		
		int random=(int) (Math.random()*10);
		
		if(random==3) {
			System.out.println(rival.getNombre()+" LVL: "+rival.getNivel()+" ha fallado su ataque...");
			return;
		}
		
		if(random==5) {
			System.out.println("Tu "+jugador.getDigimonCombatiente().getNombre()+" LVL: "+jugador.getDigimonCombatiente().getNivel()+" ha esquivado el ataque enemigo...");
			return;
		}
		
		if(random%2==0) {
			rival.atkDP1(jugador.getDigimonCombatiente());
		}else {
			rival.atkDP2(jugador.getDigimonCombatiente());
		}
			
	}

	private boolean lucha() {
		
		boolean turnoRealizado=false;
		while(!turnoRealizado) {
			
			System.out.println("""
					1.- Ataque básico
					2.- Ataque especial
					3.- Capturar
					0.- Atrás
					""");
			
			switch(Teclado.nextInt()) {
				case 0:
					return false;
				case 1:
					turnoRealizado=jugador.getDigimonCombatiente().atkDP1(rival);
					break;
				case 2:
					turnoRealizado=jugador.getDigimonCombatiente().atkDP2(rival);
					break;
				case 3:
					if(jugador.capturarDigimon(rival)) {
						captura=true;
						turnoRealizado=true;
					}
					break;
				default:
					System.out.println("Elige una opción válida...");
					break;
			}
			
		}
		return turnoRealizado;		
	}
}
