package com.smv.modelo;

import java.io.File;

/**
 * Esta clase evalua si determinada ruta de un archivo es valida o no
 * @author Michelle Perez Aguilar
 * @author Sebastián Méndez villegas
 * @version 24/04/2023
 */
public class ArchivoExiste {
	
	
	
	/**
	 * Este metodo evalua la existencia de un archivo
	 * @param ruta String con la ruta del arhivo
	 * @return True/false según la existencia o no del archivo
	 */
	public boolean existe(String ruta) {
		try {
            File file = new File(ruta);
            
            if (file.exists()) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
		return false;
	}//Cierre del metodo
}//Cierre de la clase
