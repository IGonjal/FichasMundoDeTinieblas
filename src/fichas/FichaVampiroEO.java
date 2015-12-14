package fichas;

import java.util.ArrayList;
import java.util.Iterator;

public class FichaVampiroEO extends FichaMDT{

	protected ArrayList<Rasgo> talentos;
	protected ArrayList<Rasgo> tecnicas;
	protected ArrayList<Rasgo> conocimientos;
	
	protected ArrayList<Rasgo> disciplinas;
	
	protected int maxSangre;
	protected int sangreActual;
	protected int maxSangreTurno;
	protected int generacion;
	
	protected ClanesVampiro clan;
	
	Rasgo camino;
	/**
	 * Genera una ficha de vampiro con todos los valores a 0
	 * @param n
	 * @param j
	 */
	public FichaVampiroEO(String n, String j, ClanesVampiro clan) {
		super(n, j);
		creaHabilidades();
		this.clan = clan;
		camino = new Rasgo("Humanidad");
		this.disciplinas = new ArrayList<Rasgo>();
	}
	/**
	 * Crea las habilidades propias de las fichas de vampiro EdadOscura 3ª edición
	 */
	private void creaHabilidades(){
		super.talentos.add(new Rasgo("Alerta"));
		super.talentos.add(new Rasgo("Atletismo"));
		super.talentos.add(new Rasgo("Empatía"));
		super.talentos.add(new Rasgo("Esquivar"));
		super.talentos.add(new Rasgo("Expresión"));
		super.talentos.add(new Rasgo("Intimidación"));
		super.talentos.add(new Rasgo("Liderazgo"));
		super.talentos.add(new Rasgo("Pelea"));
		super.talentos.add(new Rasgo("Prestidigitación"));
		super.talentos.add(new Rasgo("Subterfugio"));
		
		super.tecnicas.add(new Rasgo("Armas C.C."));
		super.tecnicas.add(new Rasgo("Comercio"));
		super.tecnicas.add(new Rasgo("Equitación"));
		super.tecnicas.add(new Rasgo("Etiqueta"));
		super.tecnicas.add(new Rasgo("Interpretación"));
		super.tecnicas.add(new Rasgo("Pericias"));
		super.tecnicas.add(new Rasgo("Sigilo"));
		super.tecnicas.add(new Rasgo("Supervivencia"));
		super.tecnicas.add(new Rasgo("Tiro con arco"));
		super.tecnicas.add(new Rasgo("Trato con animales"));
		
		super.conocimientos.add(new Rasgo("Academicismo"));
		super.conocimientos.add(new Rasgo("Investigación"));
		super.conocimientos.add(new Rasgo("Leyes"));
		super.conocimientos.add(new Rasgo("Lingüística"));
		super.conocimientos.add(new Rasgo("Medicina"));
		super.conocimientos.add(new Rasgo("Ocultismo"));
		super.conocimientos.add(new Rasgo("Política"));
		super.conocimientos.add(new Rasgo("Sabiduría Popular"));
		super.conocimientos.add(new Rasgo("Senescal"));
		super.conocimientos.add(new Rasgo("Teología"));
		
		
		
		this.generacion = 12;
		
		this.maxSangre = 10;
		this.sangreActual = this.maxSangre;
		this.maxSangreTurno = 11;
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
		Iterator<Rasgo> it = null;
		Rasgo ras;
		if(r == TipoRasgo.FISICO || r == TipoRasgo.SOCIAL || r == TipoRasgo.MENTAL ||
				r== TipoRasgo.FUERZAVOLUNTADACTUAL || r == TipoRasgo.FUERZAVOLUNTADMAXIMA){
			return super.sumaRasgo(r, nom, inc);
		}
		if(r == TipoRasgo.TALENTO){
			it = this.talentos.iterator();
		}else if (r == TipoRasgo.TECNICA){
			it = this.tecnicas.iterator();
		}else if (r == TipoRasgo.CONOCIMIENTO){
			it = this.conocimientos.iterator();
		}else if (r == TipoRasgo.DISCIPLINA){
			it = this.disciplinas.iterator();
		}else if (r == TipoRasgo.TRASFONDO){
			it = this.trasfondos.iterator();
		}else if (r == TipoRasgo.DISCIPLINA){
			it = this.disciplinas.iterator();
		}else if (r == TipoRasgo.CAMINO){
			if(this.camino.getValue()+inc > 10 || this.camino.getValue()+inc <0){
				return false;
			}
			this.camino.setValue(this.camino.getValue()+inc);
		}else if (r == TipoRasgo.MAXSANGRE){
			this.maxSangre +=inc;
			return true;
		}else if (r == TipoRasgo.SANGREACTUAL){
			if(this.sangreActual+inc > this.maxSangre || this.sangreActual+inc < 0){
				return false;
			}
			this.sangreActual +=inc;
			return true;
		}else if(r == TipoRasgo.GENERACION){
			if( this.generacion+inc < 1 ||this.generacion+inc > 13) 
				return false;
			this.generacion+=inc;
			return true;
		}

		if(it != null){
			while(it.hasNext()){
				ras = (Rasgo) it.next();
				if(ras.getName().equals(nom)){
					ras.setValue(ras.getValue()+inc);
				}
			}
		}
		return false;
	}

}
