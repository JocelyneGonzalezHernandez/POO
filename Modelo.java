package com.smv.modelo;

/**
 * Esta clase se encarga de llevar la parte logica de las operaciones (leer archivo, buscar incidencias, categorizar)
 * @author Michelle Perez Aguilar
 * @author Sebastián Méndez villegas
 * @version 20/04/2023
 */
public class Modelo {

	/**
	 * Constructor de la clase
	 */
	public Modelo() {
	}
	
	/**
	 * Creación de objetos de otras clases en las cuales estan contenidas distintos metodos para el tratado y analisis de información
	 */
	public ClasificarArchivo objNuevoArchivo = new ClasificarArchivo();
	public LeerArchivo objLeerArchivo = new LeerArchivo();
	public LimpiarArchivo objLimpiarArchivo = new LimpiarArchivo();
	public ContarPalabras objContarPalabras = new ContarPalabras();
	public Categorizador objCategorizador = new Categorizador();
	public ArchivoExiste objArchivoExiste = new ArchivoExiste();
}//Cierre de la clase