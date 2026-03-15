package com.smv.modelo;

import java.util.ArrayList;

/**
 * Esta clase se encarga recibir un conjunto de Strings y los limpia basados en criterios predefinidos
 * @author Michelle Perez Aguilar
 * @author Sebastián Méndez villegas
 * @version 20/04/2023
 */
public class LimpiarArchivo {
	
	
	
	/**
	 * Este metodo limpia texto de caracteres especiales y numeros esencialmente
	 * @param archivo Conjunto de Strings a limpiar
	 * @return El mismo conjunto de Strings, pero ya "limpiado"
	 */
	public ArrayList <String> limpia(ArrayList <String> archivo) {
		ArrayList <String> archivoLimpio = new ArrayList<>();
		String linea;
		int i;
		for(i=0; i<(archivo.size());i++) {
			linea=archivo.get(i);
			linea = linea.replaceAll("\\d", "");
			linea = linea.replaceAll("[^QWERTYUIOPASDFGHJKLÑZXCVBNMqwertyuiopasdfghjklñzxcvbnm. ]", "");
			linea = linea.replace('á', 'a');
			linea = linea.replace('é', 'e');
			linea = linea.replace('í', 'i');
			linea = linea.replace('ó', 'o');
			linea = linea.replace('ú', 'u');
			linea = linea.replace("\t", "");
			linea = linea.toLowerCase();
			archivoLimpio.add(linea);
		}
		return archivoLimpio;
	}//Cierre del metodo
	
	
	
	/**
	 * Este metodo impia una oración 
	 * @param oracion String a limpiar
	 * @return El string ya limpío
	 */
	public String limpiaString(String oracion) {
		oracion = oracion.replaceAll("\\d", "");
		oracion = oracion.replaceAll("[^QWERTYUIOPASDFGHJKLÑZXCVBNMqwertyuiopasdfghjklñzxcvbnm ]", "");
		oracion = oracion.replace("\t", "");
		oracion = oracion.toLowerCase();
		return oracion;
	}//Cierre del metodo
}//Cierre de la clase
