package com.smv.prueba;

import com.smv.controlador.Controlador;
import com.smv.modelo.Modelo;
import com.smv.vista.Vista;

/**
 * Esta es la clase principal
 * @author Michelle Perez Aguilar
 * @author Sebastián Méndez villegas
 * @version 28/04/2023
 */
public class PruevaMVC {
	
	
	public static void main(String[] args) 
	{
		Vista vista = new Vista();
		Modelo modelo = new Modelo();
		Controlador controlador = new Controlador (modelo, vista);
		vista.setVisible(true);
	}
}//Cierre de la clase
