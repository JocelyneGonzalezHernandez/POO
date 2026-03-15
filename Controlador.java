package com.smv.controlador;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import com.smv.modelo.Modelo;
import com.smv.vista.BarChart;
import com.smv.vista.Vista;

/**
 * Esta clase controla la vista del ambiente grafico y mantiene el seguimiento del modelo
 * @author Michelle Perez Aguilar
 * @author Sebastián Méndez villegas
 * @version 20/04/2023
 */
public class Controlador implements ActionListener{
	
	//Campos de la clase
	private Modelo modelo;
	private Vista vista;
	ArrayList <String> archivo = new ArrayList<>();
	ArrayList <String> aClasificar = new ArrayList<>();
	ArrayList <String> palabras = new ArrayList<>();
	ArrayList <Double> valores = new ArrayList<>();
	Modelo mod1 = new Modelo();
	int archivoFlag=0, palabrasFlag=0;
	
	
	
	/**
	 * Constructor de la clase
	 * @param modelo Es un objeto que contiene todos los metodos que contienen la parte logica
	 * @param vista Es un objeto que contiene los paneles, botones, etiquetas y frame de la parte grafica
	 */
	public Controlador(Modelo modelo, Vista vista){
		this.vista = vista;
		this.modelo = modelo;
		vista.panelIzq.bRutaDatos.addActionListener(this);
		vista.panelIzq.bRutaPalabras.addActionListener(this);
		vista.panelIzq.bGenerarGrafica.addActionListener(this);
		vista.panelIzq.bEtiquetado.addActionListener(this);
		vista.panelIzq.bClasificacion.addActionListener(this);
		}//Cierre del Constructor

	
	
	/**
	 * Metodo que desencadena una secuecia de código ante determinado evento
	 * Reaccionando de forma distinta segun el boton precionado
	 * @param e Parametro que contiene qué elemento fue activado
	 */
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == vista.panelIzq.bRutaDatos){
			try {
				String ruta = vista.panelIzq.iRutaDatos.getText();
				if(mod1.objArchivoExiste.existe(ruta)) {
					archivoFlag=1;
					archivo=mod1.objLeerArchivo.leer(ruta);
					archivo=mod1.objLimpiarArchivo.limpia(archivo);
					vista.panelIzq.labelCarita.setText(" ^︠ ᴗ ︡^");
				}else//Ventana de error
					JOptionPane.showMessageDialog(vista, "Entrada invalida", "ERROR", JOptionPane.WARNING_MESSAGE);
			} catch(Exception ex){
				JOptionPane.showMessageDialog(null, "Sin Texto / Dato Incorrecto", "Error de Entrada", JOptionPane.ERROR_MESSAGE);
				}
		}
		
		if (e.getSource() == vista.panelIzq.bRutaPalabras){
			try {
				String ruta = vista.panelIzq.iRutaPalabras.getText();
				if(mod1.objArchivoExiste.existe(ruta)) {
					palabrasFlag=1;
					palabras=mod1.objLeerArchivo.leer(ruta);
					vista.panelIzq.labelCarita.setText("⊂( ͡^ ● ͡^)⊃");
				}else//Ventana de error
					JOptionPane.showMessageDialog(vista, "Entrada invalida", "ERROR", JOptionPane.WARNING_MESSAGE);
			} catch(Exception ex){
				JOptionPane.showMessageDialog(null, "Sin Texto / Dato Incorrecto", "Error de Entrada", JOptionPane.ERROR_MESSAGE);
				}
		}
		
		if (e.getSource() == vista.panelIzq.bGenerarGrafica){
			try {
				if(archivoFlag==1 && palabrasFlag==1) {
				valores=mod1.objContarPalabras.contar(archivo, palabras);
				BarChart grafica = new BarChart("grafica palabras",valores, palabras);
				vista.panelDer.removeAll();
				vista.panelDer.add(grafica.createDemoPanel());
				vista.panelDer.updateUI();
				vista.panelIzq.labelCarita.setText("⊂( ͡^ 👅 ͡^)⊃");
				}
				if(archivoFlag==0 && palabrasFlag==0)
					JOptionPane.showMessageDialog(vista, "Ingrese ruta de archivo y palabras", "ERROR", JOptionPane.WARNING_MESSAGE);
				if(archivoFlag==1 && palabrasFlag==0)
					JOptionPane.showMessageDialog(vista, "Ingrese ruta palabras", "ERROR", JOptionPane.WARNING_MESSAGE);
				if(archivoFlag==0 && palabrasFlag==1)
					JOptionPane.showMessageDialog(vista, "Ingrese ruta de archivo", "ERROR", JOptionPane.WARNING_MESSAGE);
			} catch(Exception ex){
				JOptionPane.showMessageDialog(null, "Sin Texto / Dato Incorrecto", "Error de Entrada", JOptionPane.ERROR_MESSAGE);
				}
		}
		
		if (e.getSource() == vista.panelIzq.bEtiquetado){
			try {
				mod1.objNuevoArchivo.clasificar();
				vista.panelIzq.labelCarita.setText(" ^︠ ෴ ︡^");
			} catch(Exception ex){
				JOptionPane.showMessageDialog(null, "Sin Texto / Dato Incorrecto", "Error de Entrada", JOptionPane.ERROR_MESSAGE);
				}
		}
		
		if (e.getSource() == vista.panelIzq.bClasificacion){
			try {
				String oracion = vista.panelIzq.iClasificacion.getText();
				oracion=mod1.objLimpiarArchivo.limpiaString(oracion);
				if(oracion.length()>0){
					String categoria = mod1.objCategorizador.Algoritmo(oracion);
					JLabel resultado =new JLabel(categoria, SwingConstants.CENTER);
					resultado.setFont(new Font("Serif", Font.BOLD, 30));
					vista.panelDer.removeAll();
					vista.panelDer.add(resultado); //MODIFICAR para actualizar una etiqueta
					vista.panelDer.updateUI();
					//vista.panelDer.labelCategoria.setText(categoria);
					vista.panelIzq.labelCarita.setText("⊂( ͡^ ͜ʖ ͡^)⊃");
				}else {
					JOptionPane.showMessageDialog(vista, "Entrada no valida", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			} catch(Exception ex){
				JOptionPane.showMessageDialog(null, "Sin Texto / Dato Incorrecto", "Error de Entrada", JOptionPane.ERROR_MESSAGE);
				}
		}
	}//Cierre del metodo
}//Cierre de la clase