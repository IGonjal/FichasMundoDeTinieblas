package core;



import java.util.ArrayList;
import java.util.Iterator;

import Varios.Utilidades;
import fichas.ClanesVampiro;
import fichas.FichaMDT;
import fichas.FichaVampiroEO;
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<FichaMDT> fichas = Utilidades.leeDeArchivo();
		
		//ArrayList<FichaMDT> fichas = new ArrayList<FichaMDT>();
		
		FichaVampiroEO fic = new FichaVampiroEO("Arthur Pennywise", "Ismael",ClanesVampiro.Brujah);
		
		//fichas.add(fic);
		Iterator<FichaMDT> it = fichas.iterator();
		
		
		
		System.out.println(it.next().toString());
		//System.out.println(fic.toString());
		
		
		Utilidades.escribeEnArchivo(fichas);
	}

}
