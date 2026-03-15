package com.smv.modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Esta clase lee un archivo de texto y clasifica las lineas aparecidas ahí, guardando dicha clasificación con cada linea, dentro de un nuevo archivo.
 * Se apoya de otras clases dentro del paquete modelo para dicho proposito
 * @author Michelle Perez Aguilar
 * @author Sebastián Méndez villegas
 * @version 21/04/2023
 */
public class ClasificarArchivo {
	
	//Campos de la clase
	public Categorizador objCategorizador = new Categorizador();
	LeerArchivo objLeerArchivo = new LeerArchivo();
	public LimpiarArchivo objLimpiarArchivo = new LimpiarArchivo();
	ArrayList <String> archivo = new ArrayList<>();
	int a;
	String categoria;
	
	
	
	/**
	 * Este metodo lee un archivo de texto y clasifica sus contenido (usando etiquetas) y guardando el resultado en un nuevo archivo
	 */
	public void clasificar(){
        try {
        	archivo=objLeerArchivo.leer("/home/im21smv/aClasificar.txt");
			archivo=objLimpiarArchivo.limpia(archivo);
            File file = new File("/home/im21smv/aClasificar.txt");
            if (file.exists()) {
            	file.delete();
            }
            PrintWriter writer = new PrintWriter("/home/im21smv/aClasificar.txt", "UTF-8");
    		for(a=0; a<(archivo.size());a++)
    			writer.println(archivo.get(a));
    		writer.close();
        	
        	archivo=objLeerArchivo.leer("/home/im21smv/aClasificar.txt");
        	
            File file2 = new File("/home/im21smv/pruevaPOO.txt");
            if (file2.exists()) {
            	file2.delete();
            }
            PrintWriter writer2 = new PrintWriter("/home/im21smv/pruevaPOO.txt", "UTF-8");
    		for(a=0; a<(archivo.size());a++) {
    			categoria=objCategorizador.Algoritmo(archivo.get(a));
    			writer2.println(categoria + " | "+ archivo.get(a));
    		}
    		writer2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//Cierre del metodo
}//Cierre de la clase
