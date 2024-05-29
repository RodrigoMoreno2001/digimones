package digimones;

/**
 * Esta clase se encarga de hacer posible una batalla entre la CPU y el jugador
 */

public class BatallaDigital {
	
	// Atributos
	
	private Domador jugador;
	private Digimon rival;
	private boolean captura;
	
	// Constructores
	
	/**
	 * Recibe un jugador e instancia un digimon rival para dar comienzo a una batalla
	 * 
	 * @param jugador 
	 */
	
	public BatallaDigital(Domador jugador) {
		
		this.jugador=jugador;
		this.rival=new Digimon();
		this.captura=false;
		
	}
	
	// Metodos
	
	/**
	 * Contiene toda la lógica de una batalla digimon.
	 * 
	 * Mientras el rival tenga salud, no haya sido capturado y nuestro digimons tengan salud,
	 * seguirá la batalla.
	 */
	
	public void batalla() {
		int opt=-1;
		
		while(rival.getSalud()>0 && jugador.estanVivos()&&!captura) {
			
			// detecta si nuestro digimon tiene salud, si no tiene, deberemos cambiar de digimon
			
			while(jugador.getDigimonCombatiente().getSalud()<=0) jugador.cambiarDigimon();
			
			System.out.println("Estás contra: "+rival.getNombre()+" LVL: "+rival.getNivel()+" HP: "+rival.getSalud()+"/"+(rival.getNivel()*10));
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

	/**
	 * Este método va a generar un número random y apartir de este número va a decidir el ataque
	 * usado por el rival
	 */
	
	private void luchaCPU() {

		if(rival.getSalud()<=0||captura) {
			return;
		}
		
		int random=(int) (Math.random()*10);
		
		// este if hace que el rival falle su ataque,
		// además resta una probabilidad de que un rival realice un atkDP2
		
		if(random==3) {
			System.out.println(rival.getNombre()+" LVL: "+rival.getNivel()+" ha fallado su ataque...");
			return;
		}
		
		// este if hace que tu digimon esquive el ataque,
		// además resta una probabilidad de que un rival realice un atkDP2
		
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

	/**
	 * Menú de lucha del usuario, aquí deberá decidir un usuario su próximo movimiento<br>
	 * <br>
	 * Si devolviese "true" el digimon rival atacará, de otro modo, no atacará
	 * @return {@code True} si el movimiento ha sido realizado,<br>{@code False} si el movimiento no ha sido completado
	 */
	
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
