package fichas;

import java.util.ArrayList;
import java.util.Iterator;
import java.io.Serializable;
/**
 * Un tipo de ficha abstracta que se usará para extenderla y generar personajes de distintos juegos de mundo de tinieblas
 * su estructira contiene muchos usos de ArrayList, por lo que conviene conocer esta clase
 * @author Ismael Gonjal
 * @see java.util.ArrayList
 * @see fichas.Rasgo
 *
 */
public abstract class FichaMDT implements Serializable {

	String nombre;
	String jugador;
	
	protected ArrayList<ArrayList<Rasgo>> todo;
	
	protected ArrayList<Rasgo>[] atributos;
	protected ArrayList<Rasgo>[] habilidades;
	protected ArrayList<Rasgo>[] ventajas;
	protected int maxFuerzaDeVoluntad;
	protected int fuerzaDeVoluntadActual;
	
	protected int maxSalud;
	
	protected int contundente;
	protected int letal;
	protected int agravado;
	
	protected ArrayList<Rasgo> fisicos;
	protected ArrayList<Rasgo> sociales;
	protected ArrayList<Rasgo> mentales;
	protected ArrayList<Rasgo> talentos;
	protected ArrayList<Rasgo> tecnicas;
	protected ArrayList<Rasgo> conocimientos;
	protected ArrayList<Rasgo> trasfondos;
	protected ArrayList<Rasgo> virtudes;
	protected ArrayList<Rasgo> meritos_defectos;
	
	
	/**
	 * Crea una ficha con todas las características a 0
	 * @param n
	 * @param j
	 */
	public FichaMDT(String n, String j){
		nombre = n;
		jugador = j;
		
		todo = new ArrayList<ArrayList<Rasgo>>();
		meritos_defectos = new ArrayList<Rasgo>();
		
		atributos = new ArrayList[3];
		habilidades = new ArrayList[3];
		
		fisicos = new ArrayList<Rasgo>();
		mentales = new ArrayList<Rasgo>();
		sociales = new ArrayList<Rasgo>();
		
		talentos = new ArrayList<Rasgo>();
		tecnicas = new ArrayList<Rasgo>();
		conocimientos = new ArrayList<Rasgo>();
		
		trasfondos = new ArrayList<Rasgo>();
		virtudes = new ArrayList<Rasgo>();
			
		atributos[0] = fisicos;
		atributos[1] = sociales;
		atributos[2] = mentales;
		
		habilidades[0] = talentos;
		habilidades[1] = tecnicas;
		habilidades[2] = conocimientos;
		
		todo.add(fisicos);
		todo.add(mentales);
		todo.add(sociales);
		todo.add(talentos);
		todo.add(conocimientos);
		todo.add(tecnicas);
		todo.add(virtudes);
		todo.add(trasfondos);
		
		this.maxSalud = 7;
		this.agravado = 0;
		this.contundente = 0;
		this.letal = 0;
		
		creaAtributos();
		
	
	}
	/**
	 * Genera los atributos físicos, mentales y sociales genéricos en mundo de tinieblas
	 */
	private void creaAtributos(){
		fisicos.add(new Rasgo("Fuerza"));
		fisicos.add(new Rasgo("Destreza"));
		fisicos.add(new Rasgo("Resistencia"));
		
		mentales.add(new Rasgo("Percepcion"));
		mentales.add(new Rasgo("Inteligencia"));
		mentales.add(new Rasgo("Astucia"));
		
		sociales.add(new Rasgo("Carisma"));
		sociales.add(new Rasgo("Manipulación"));
		sociales.add(new Rasgo("Apariencia"));
	}
	/**
	 * Sube un rasgo, para ello se le indica un tipo de rasgo presente en el enumerado TipoRasgo, tras eso, 
	 * suma inc al rasgo
	 * @param r el tipo de rasgo
	 * @param nom el nombre del rasgo
	 * @param inc el incremento
	 * @return true si se hace correctamente, false en caso contrario o en caso de que el rasgo no exista o no sea de ese tipo
	 * @see fichas.TipoRasgo.java
	 */
	public boolean sumaRasgo(TipoRasgo r,String nom, int inc){
		if(r == TipoRasgo.FISICO){
			return subeRasgoFisico(nom, inc);
		}else if(r == TipoRasgo.SOCIAL){
			return subeRasgoSocial(nom, inc);
		}else if(r == TipoRasgo.MENTAL){
			return subeRasgoMental(nom, inc);
		}else if(r == TipoRasgo.FUERZAVOLUNTADACTUAL){
			if(this.fuerzaDeVoluntadActual+inc > this.maxFuerzaDeVoluntad ||
					this.fuerzaDeVoluntadActual+inc < 0) return false;
			fuerzaDeVoluntadActual+=inc;
			return true;
		}else if(r == TipoRasgo.FUERZAVOLUNTADMAXIMA){
			if (this.maxFuerzaDeVoluntad+inc > 10||
					this.maxFuerzaDeVoluntad+inc < 0) return false;
			this.maxFuerzaDeVoluntad+=inc;
			return true;
		}
		
		
		return false;
	}
	/**
	 * Incrementa en inc el valor de un rasgo mental
	 * @param nombre el nombre del rasgo
	 * @param inc el incremento
	 * @return true si se hace correctamente, false en caso contrario o en caso de que el rasgo no exista
	 */
	private boolean subeRasgoMental(String nombre, int inc){
		Iterator<Rasgo> it;
		Rasgo ras;
		
		it = mentales.iterator();
		while(it.hasNext()){
			ras = (Rasgo) it.next();
			if(ras.getName().equals(nombre)){
				ras.setValue(ras.getValue()+inc);
				return true;
			}
		}
		return false;	
	}
	
	/**
	 * Incrementa en inc el valor de un rasgo social
	 * @param nombre el nombre del rasgo
	 * @param inc el incremento
	 * @return true si se hace correctamente, false en caso contrario o en caso de que el rasgo no exista
	 */
	private boolean subeRasgoSocial(String nombre, int inc){
		Iterator<Rasgo> it;
		Rasgo ras;
		
		it = sociales.iterator();
		while(it.hasNext()){
			ras = (Rasgo) it.next();
			if(ras.getName().equals(nombre)){
				ras.setValue(ras.getValue()+inc);
				return true;
			}
		}
		return false;	
	}
	
	/**
	 * Incrementa en 1 el valor de un rasgo físico
	 * @param nombre el nombre del rasgo
	 * @param inc el incremento
	 * @return true si se hace correctamente, false en caso contrario o en caso de que el rasgo no exista
	 */
	private boolean subeRasgoFisico(String nombre, int inc){
		Iterator<Rasgo> it;
		Rasgo ras;
		
		it = fisicos.iterator();
		while(it.hasNext()){
			ras = (Rasgo) it.next();
			if(ras.getName().equals(nombre)){
				ras.setValue(ras.getValue()+inc);
				return true;
			}
		}
		return false;	
	}
	/**
	 * Crea una ficha de mundo de tinieblas
	 * @param f rasgos físicos
	 * @param s rasgos sociales
	 * @param m rasgos mentales
	 * @param ta talentos
	 * @param te tecnicas
	 * @param c conocimientos
	 * @param v virtudes
	 *//*
	public FichaMDT(ArrayList<Rasgo> f,ArrayList<Rasgo> s, ArrayList<Rasgo> m,
			ArrayList<Rasgo> ta,ArrayList<Rasgo> te, ArrayList<Rasgo> c,
			ArrayList<Rasgo> v){
		fisicos = f;
		sociales = s;
		mentales = m;
		talentos = ta;
		tecnicas = te;
		conocimientos = c;
		virtudes = v;
		
		
		atributos[0] = fisicos;
		atributos[1] = sociales;
		atributos[2] = mentales;
		
		habilidades[0] = talentos;
		habilidades[1] = tecnicas;
		habilidades[3] = conocimientos;
		
		ventajas[0] = virtudes;
	}*/
	
	public String toString(){
		String ret = "Jugador: "+this.jugador;
		String aux = ret;
		while(aux.length() < 33){
			aux = aux + " ";
			ret = ret + " ";
		}
		ret = ret +"Nombre: "+this.nombre+'\n';
		aux = "Nombre: "+this.nombre+'\n';
		while(aux.length() < 33){
			aux = aux + " ";
			ret = ret + " ";
		}
		
		int numveces = 0;
		
		Rasgo[] r = new Rasgo[3];
		@SuppressWarnings("unchecked")
		Iterator<Rasgo>[] it = new Iterator[3];
		
		
		while (numveces < 2){
			if(numveces ==0){
				ret = ret + '\n' + "Fisicos                  Sociales                 Mentales"+'\n'+'\n';
				it[0]= this.atributos[0].iterator();
				it[1]= this.atributos[1].iterator();
				it[2]= this.atributos[2].iterator();
			}else if(numveces ==1){
				ret = ret + '\n'+ "Talentos                 Tecnicas                 Conocimientos" + '\n'+'\n';
				it[0] = this.talentos.iterator();
				it[1] = this.tecnicas.iterator();
				it[2] = this.conocimientos.iterator();
			}
			
			while (it[0].hasNext() || it[1].hasNext() || it[2].hasNext()){
				for(int i = 0; i<3;i++){
					if(it[i].hasNext()){
						r[i]= it[i].next();
						ret = ret + r[i].toString() + "";
						aux = r[i].toString();
						while(aux.length()<25){
							ret = ret + " ";
							aux = aux + " ";
						}
						aux = "";
					}else{
						ret += "                         ";
					}
				}
				ret = ret + '\n';
			}
			ret = ret + "_______________________________________________"+'\n';
			
			numveces++;
			
		}
		
		return ret;
	}
	/**
	 * Añade un mérito o un defecto. el valor del rasgo indica si es un
	 * mérito o defecto (mérito positivo, defecto negativo) y el nivel
	 * del mérito o defecto. si se trata de añadir un mérito que ya existía 
	 * se devolverá falso y no se hará nada
	 * @param r
	 * @return
	 */
	public boolean addMerito_Defecto(Rasgo r){
		Iterator<Rasgo> it;
		boolean found = false;
		it = this.meritos_defectos.iterator();
		while(it.hasNext() && !found){
			
			if(((Rasgo) it.next()).getName().equals(r.getName()) ){
				return false;
			}
		}
		
		return this.meritos_defectos.add(r.clone());
	}
}
