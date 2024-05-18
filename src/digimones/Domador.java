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
		if(equipo.size()>3) {
			System.err.println("Tu equipo está lleno...");
			equipo.remove(equipo.size()-1);
		}
		
		this.equipo = equipo;
	}
	
	public String toString() {
		
		return "Nombre: "+nombre+" Equipo: "+equipo.toString();
	}
	
}
