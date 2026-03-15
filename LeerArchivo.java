package com.smv.modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Esta clase se encarga abrir un archivo y guardar su contenido en un conjunto de Strings
 * @author Michelle Perez Aguilar
 * @author Sebastián Méndez villegas
 * @version 20/04/2023
 */
public class LeerArchivo {
	
	
	
	/**
	 * Este metodo abre un archivo y guardar su contenido en un conjunto de Strings de forma dinamica (adaptandose al tamaño del archivo)
	 * @param ruta
	 * @return
	 */
	public ArrayList <String> leer(String ruta) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		ArrayList <String> informacion = new ArrayList<>();
		
		try {
			archivo = new File(ruta);
			fr = new FileReader (archivo);
			br = new BufferedReader(fr);
			String linea;
			
			while((linea=br.readLine())!=null) {
				//eliminar vacios
				if(linea.length()>0)
					informacion.add(linea);
			}
			System.out.println("Se leyó el archivo correctamente :)");
			fr.close();
		}
		catch(Exception e) {
			System.out.println("Excepcion leyendo fichero "+ e);
		}
		return informacion;
	}//Cierre del metodo
}//Cierre de la clase
