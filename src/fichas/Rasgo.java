package fichas;

import java.io.Serializable;
/**
 * Un rasgo cualquiera que sirve para prácticamente toda la ficha, 
 * el objetivo será meterlos en listas que indican a qué pertenece.
 * 
 * @author Ismael
 *
 */
public class Rasgo implements Serializable{
	private String name;
	private int value;
	/**
	 * Construye un rasgo con un nombre y el valor a 0
	 * @param name El nombre del rasgo
	 */
	public Rasgo (String name){
		this.name = name;
		this.value = 0;
	}
	/**
	 * Construye un rasgo con un nombre y un valor
	 * @param name
	 * @param value
	 */
	public Rasgo (String name, int value){
		this.name = name;
		if(value <0) 
			value = 0;
		this.value = value;
		
	}
	
	//////////////////////////////////////////////////////
	/**
	 * Devuelve el nombre
	 * @return the name
	 */
	public String getName(){
		return this.name;
	}
	/**
	 * Devuelve el valor del rasgo
	 * @return the value
	 */
	public int getValue(){
		return this.value;
	}
	/**
	 * Asigna un nuevo valor. Si se le pasa un valor negativo, el
	 * valor se queda en 0
	 * @param newValue
	 */
	public void setValue(int newValue){
		if(newValue <0) 
			newValue = 0;
		this.value = newValue;
	}
	
	
	
	/**
	 * Devuelve true si el objeto o es de tipo Rasgo y
	 * su nombre es igual(Case sensitive) y el valor
	 * también lo es.
	 * 
	 * @param o Un objeto cualquiera
	 * @return true si es igual, false si no
	 */
	public boolean equals(Object o){
		if(o.getClass() != Rasgo.class) return false;
		Rasgo r = (Rasgo) o;
		return name.equals(r.name) && value ==r.value;	
	}
	/**
	 * La comparación se basa sólo en los nombres, obviando los valores
	 * @param o on objeto cualquiera
	 * @return la diferencia entre las dos cadenas
	 * @throws Exception si el objeto o no es de tipo Rasgo
	 */
	int compareTo(Object o) throws Exception{
		if (o.getClass() != Rasgo.class) throw new Exception("Error, debe ser un rasgo");
		Rasgo r = (Rasgo) o;
		return this.name.compareTo(r.name);
	}
	/**
	 * Deuelve una cadena de caracteres que contiene:
	 * nombre + ": " + value
	 * @return a String
	 */
	public String toString(){
		return this.name+ ": " + this.value;
	}
	/**
	 * Returns an object that is a copy of this object
	 */
	public Rasgo clone(){
		return new Rasgo(this.name,this.value);
	}
}
