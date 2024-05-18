package digimones;

import java.util.ArrayList;

public class Domador {

	// atributos
	
	private String nombre;
	private ArrayList<Digimon> equipo;
	
	// constructores
	
	public Domador(String nombre) {
		
		this.nombre=nombre;
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
			System.out.println("Has capturado un digimon:\n"+rival);
			return true;
		}
		return false;
		
	}
	
	// Getters&Setters
	
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
	
	public String toString() {
		String team="";
		
		for(Digimon aux:equipo) {
			team+=aux;
		}
		
		return "Domador: "+nombre+"\nEquipo:"+team;
	}
	
}
