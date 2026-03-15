package com.smv.modelo;

import java.util.ArrayList;

/**
 * Esta clase generar un conteo de las veces que aparece un conjunto de palabras dentro de un conjunto de Strings
 * @author Michelle Perez Aguilar
 * @author Sebastián Méndez villegas
 * @version 20/04/2023
 */
public class ContarPalabras {
	
	
	
	/**
	 * Este metodo Genera un arreglo de datos del tipo Double con las cantidades de apariciones del contenido de "palabras" buscadas dentro de "archivo"
	 * @param archivo Conjunto de strings
	 * @param palabras Conjunto de palabras a buscar
	 * @return Un arreglo con los datos de apariciones de cada palabra dentro de "palabras" buscadas dentro de "archivo"
	 */
	public ArrayList <Double> contar(ArrayList <String> archivo, ArrayList <String> palabras){
		ArrayList <Double> valores = new ArrayList<>();
		int a, b;
		
		for(a=0; a<(palabras.size());a++)
			valores.add(Double.valueOf(0.0));
		
		for(a=0; a<(archivo.size());a++) {
			for(b=0; b<(palabras.size());b++) {
				if(archivo.get(a).contains(palabras.get(b)))
					valores.set(b, (valores.get(b))+1);
			}
		}
		return valores;
	}//Cierre del metodo
}//Cierre de la clase
