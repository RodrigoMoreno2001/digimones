package digimones;

/**
 * @author rodri_2
 */

/**
 * Clase encargada de representar un Digimon en mi programa
 */

public class Digimon {
	
	// Atributos
	
    private final String[] digimons = {"Agumon","Gabumon","Patamon","Gatomon","Tentomon","Palmon","Biyomon","Gomamon","Veemon","Guilmon"};
	
    private String nombre;
	private int nivel;
	private int ataque; // nivel*5
	private int salud;	// nivel*10
	private int dp1;
	private int dp2;
	
	// Constructores
	
	/**
	 * Este constructor vacío va a crear un digimon aleatorio, con las caracteristicas especificadas por el enunciado
	 */
	
	public Digimon() {
		
		this.nombre=digimons[(int)(Math.random()*digimons.length)];
		this.nivel=(int) (Math.random()*5+1);
		this.ataque=nivel*5;
		this.salud=nivel*10;
		this.dp1=10;
		this.dp2=10;
		
	}
	
	// Métodos
	
	/**
	 * Movimiento de ataque básico de un digimon
	 * 
	 * @param rival Digimon objetivo del ataque
	 * @return {@code true} si se ha podido realizar el movimiento, {@code false} si no
	 */
	
	public boolean atkDP1(Digimon rival) {
		
		if(dp1<=0) {
			System.out.println("Este movimiento no está disponible");
			return false;
		}
		
		this.dp1-=1;
		rival.setSalud(rival.getSalud()-this.ataque);
		
		if(rival.getSalud()<0) rival.setSalud(0);

		System.out.println(nombre+" LVL: "+nivel+" ha atacado a "+rival.nombre+" LVL: "+rival.nivel);
		return true;
	}
	
	/**
	 * Movimiento de ataque especial de un digimon
	 * 
	 * @param rival Digimon objetivo del ataque
	 * @return {@code true} si se ha podido realizar el movimiento, {@code false} si no
	 */
	
	public boolean atkDP2(Digimon rival) {
		
		if(dp2<=0) {
			System.out.println("Este movimiento no está disponible");
			return false;
		}
		
		this.dp2-=2;
		
		rival.setSalud(rival.getSalud()-this.ataque*2);
		
		if(rival.getSalud()<0) rival.setSalud(0);
		
		System.out.println(nombre+" LVL: "+nivel+" ha atacado gravemente a "+rival.nombre+" LVL: "+rival.nivel);
		return true;
	}
	
	
	// Getters&Setters
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getSalud() {
		return salud;
	}

	public void setSalud(int salud) {
		this.salud = salud;
	}

	public int getDp1() {
		return dp1;
	}

	public void setDp1(int dp1) {
		this.dp1 = dp1;
	}

	public int getDp2() {
		return dp2;
	}

	public void setDp2(int dp2) {
		this.dp2 = dp2;
	}
	
	@Override
	public String toString() {

		return nombre+" LVL: "+nivel+" ATK: "+ataque+" HP: "+salud+"/"+(nivel*10)+" DP1: "+dp1+" DP2: "+dp2;
		
	}
}
