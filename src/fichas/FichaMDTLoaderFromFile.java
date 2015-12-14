package fichas;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Varios.Utilidades;



public class FichaMDTLoaderFromFile {
	FichaMDT ficha;
	Scanner archivo;
	

	protected ArrayList<Rasgo> fisicos;
	protected ArrayList<Rasgo> sociales;
	protected ArrayList<Rasgo> mentales;
	protected ArrayList<Rasgo> talentos;
	protected ArrayList<Rasgo> tecnicas;
	protected ArrayList<Rasgo> conocimientos;
	protected ArrayList<Rasgo> trasfondos;
	protected ArrayList<Rasgo> virtudes;
	
	
	
	
	
	/**
	 * Genera la ficha de Mundo de tinieblas a partir de un archivo
	 * @param arch
	 * @return una ficha si todo fue correcto, null en caso contrario
	 */
	public FichaMDT generateFicha(Scanner arch){
		if (!arch.hasNext()) return null;
		String lineaArch[] = Utilidades.readLine(arch);
		if(lineaArch.length>1 || !lineaArch[0].equals("ATRIBUTOS")) return null;
		
		if(!generaAtributos(arch)) return null;
		
		if (!arch.hasNext()) return null;
		lineaArch = Utilidades.readLine(arch);
		if(lineaArch.length>1 || !lineaArch[0].equals("HABILIDADES")) return null;
		
		if (!arch.hasNext()) return null;
		lineaArch = Utilidades.readLine(arch);
		if(lineaArch.length>1 || !lineaArch[0].equals("VENTAJAS")) return null;
		
		return null;
	}
	
	private boolean generaAtributos(Scanner arch){
		if(!arch.hasNext()) return false;
		String [] lineaArch = Utilidades.readLine(arch);
		int i =0;
		while(lineaArch.length>1 && !lineaArch[0].equals("FINATRIBUTOS")){
			
			if(lineaArch.length != 5) return false;
			
			//if()
			
			if(!arch.hasNext()) return false;
			lineaArch = Utilidades.readLine(arch);
		}
		
		return true;
	}
	
	private boolean leePack(Scanner arch, String flagini, String flagfin, String patron, int packno, int longPatron){
		if(!arch.hasNext()) return false;
		String [] lineaArch = Utilidades.readLine(arch);
		if(lineaArch.length != 1 && !lineaArch.equals(flagini)) return false;
		int i =0;
		if(!lineaArch[0].equals(flagini))
		while(lineaArch.length>1 && !lineaArch[0].equals(flagfin)){
			
		}
		return true;
	}

}
