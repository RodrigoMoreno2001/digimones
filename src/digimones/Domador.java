package digimones;

import java.util.ArrayList;

public class Domador {

	// atributos
	
	private String nombre;
	private ArrayList<Digimon> equipo;
	private int digimonActual;
	
	// constructores
	
	public Domador(String nombre) {
		
		this.nombre=nombre;
		this.digimonActual=0;
		this.equipo=new ArrayList<>();
		getEquipo().add(new Digimon());
		setEquipo(equipo);
		
	}

	// Metodos
	
	public boolean estanVivos() {

		for(Digimon aux:equipo) {
			if(aux.getSalud()>0) return true;
		}
		
		return false;
		
	}
	
	public boolean capturarDigimon(Digimon rival) {
		
		if(equipo.size()>2) {
			System.err.println("El equipo está lleno...");
			return false;
		}
		
		if(rival.getSalud()>(rival.getNivel()*10-20)){
			System.out.println("Necesitas bajarle la vida...");
			return false;
		}
		
		if(equipo.add(rival)) {
			System.out.println("Has capturado un digimon: "+rival);
			return true;
		}
		return false;
		
	}
	
	public void liberarDigimon() {
		
		System.out.println("Qué digimon quiere dejar ir...");
		listarEquipo();
		System.out.println("0.- Cancelar");
		
		int opt=Teclado.nextInt();
		
		if(opt==(digimonActual+1)) {
			System.out.println("No puedes liberar al digimon que estás usando...");
			return;
		}
		
		if(opt==0) {
			return;
		}else if(opt<0||opt>equipo.size()) {
			System.out.println("Ese digimon no existe");
			return;
		}
		
		Digimon aux=equipo.remove(opt-1);
		
		if((opt-1)<digimonActual) digimonActual--;
		
		System.out.println("Has liberado a tu: "+aux);
	}

	public void cambiarDigimon() {
		
		System.out.println("Elige el próximo combatiente...");
		listarEquipo();
		System.out.println(" 0.- Cancelar");
		
		int opt=Teclado.nextInt();
		
		if(opt==0) {
			return;
		}else if(opt<0||opt>equipo.size()) {
			System.out.println("Ese digimon no existe");
			return;
		}
		
		if(opt==(digimonActual+1)) {
			System.out.println("No puedes cambiar al digimon que estás usando...");
			return;
		}
		
		if(equipo.get(opt-1).getSalud()<=0) {
			System.out.println("Este digimon no está en condiciones de pelear...");
			return;
		}
		
		this.digimonActual=opt-1;
		
	}
	
	public void listarEquipo() {
		
		for(int i=0;i<equipo.size();i++) {
			if(i==digimonActual) {
				System.out.println(" *"+(i+1)+".- "+equipo.get(i)+"*");
			}else {
				System.out.println(" "+(i+1)+".- "+equipo.get(i));	
			}			
		}	
	}
	
	// Getters&Setters
	
	public Digimon getDigimonCombatiente() {
		
		return equipo.get(digimonActual);
		
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Digimon> getEquipo() {
		return equipo;
	}

	public void setEquipo(ArrayList<Digimon> equipo) {
		this.equipo = equipo;
	}
	
	public int getDigimonActua() {
		return digimonActual;
	}

	public void setDigimonActual(int digimonActual) {
		this.digimonActual = digimonActual;
	}
	
	public String toString() {
		String team="";
		
		for(Digimon aux:equipo) {
			team+=aux;
		}
		
		return "Domador: "+nombre+"\nEquipo:"+team;
	}

	public boolean ganador() {
		
		boolean agumon=false;
		boolean gabumon=false;
		boolean patamon=false;
		
		for(Digimon aux:equipo) {
			
			if(aux.getNombre().equalsIgnoreCase("agumon")) {
				agumon=true;
			}else if(aux.getNombre().equalsIgnoreCase("gabumon")) {
				gabumon=true;
			}else if(aux.getNombre().equalsIgnoreCase("patamon")) {
				patamon=true;
			}	
		}	
		return agumon&&gabumon&&patamon;
	}
	
}
