package Varios;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import fichas.FichaMDT;
/**
 * Esta clase contiene varias utilidades de uso general, entre ellas
 * están las siguientes:
 * -readLine: toma un archivo de texto y devuelve el contenido
 * -escribeenArchivo: Escribe un objeto en un archivo
 * -leeArchivo: Lee un objeto de un archivo
 * @author Ismael
 *
 */
public class Utilidades {

	
	/**
	 * Toma un archivo, lee su siguiente línea, devuelve un array de Strings con
	 * el contenido de la línea separada por espacios. Si una palabra contiene _ este 
	 * carácter se sustituye por espacios en blanco 
	 * @param archivo
	 * @return un array de cadenas de caracteres si había una línea que leer en el archivo, null en caso contrario
	 */
	public static String[] readLine(Scanner archivo){
		String[] ret = null;
		
		if(archivo.hasNextLine()){
			//String aux = archivo.nextLine();
			ret =  archivo.nextLine().split(" ");//  aux.split(" ");
			
			for(int i =0;i<ret.length;i++){
				ret[i] = ret[i].replace("_"," ");				
			}
		}

		return ret;
	}
	
	/**
	 * Escribe en un archivo llamado "archivo.bin" el objeto enviado.
	 * Machaca el archivo completamente, diseñado para guardar un
	 * arraylist con todo el contenido
	 * @param o un objeto que debe ser serializable
	 * @return true se se ha podido realizar, false en caso contrario
	 */
	public static boolean escribeEnArchivo(Object o){
		boolean ret = true;
		try {
			/*BufferedWriter bw = new BufferedWriter(new FileWriter("archivo.bin"));
			bw.write("");
			bw.close();*/
			
			FileOutputStream fos = new FileOutputStream("archivo.bin");
			ObjectOutputStream out = new ObjectOutputStream(fos); 
			
			
			
			out.writeObject(o);
			
		} catch (FileNotFoundException e) {
			
			ret = false;
			
			e.printStackTrace();
		} catch (IOException e) {
			
			ret = false;
			
			e.printStackTrace();
		}
		
		return ret;
	}
	/**
	 * Lee del archivo archivo.bin un ArrayList y lo devuelve
	 * @return Un ArrayList<FichaMDT> si tiene éxito, null si no.
	 */
	public static ArrayList<FichaMDT> leeDeArchivo(){
		ArrayList<FichaMDT> ret = null;
		FileInputStream fis;
		try {
			fis = new FileInputStream("archivo.bin");
			ObjectInputStream in = new ObjectInputStream(fis);
			ret = (ArrayList<FichaMDT>) in.readObject();
		} catch (FileNotFoundException e) {
			
			ret = null;
			
			e.printStackTrace();
		} catch (IOException e) {

			ret = null;
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			ret = null;
			
			e.printStackTrace();
		} 
		 
		return ret;
		
	}
}
