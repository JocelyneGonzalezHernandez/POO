package com.smv.vista;

import java.awt.Color;

import javax.swing.*;

/**
 * Esta clase declara y organiza distinos elementos (botones, etiquetas, cuadros de texto) dentro de un panel
 * @author Michelle Perez Aguilar
 * @author Sebastián Méndez villegas
 * @version 21/04/2023
 */
public class PanelIzquierdo extends JPanel{

	//Campos de la clase
	private static final long serialVersionUID = 1L;
	public JButton bRutaDatos, bRutaPalabras, bGenerarGrafica, bEtiquetado, bClasificacion;
	public JTextField iRutaDatos, iRutaPalabras, iClasificacion;
	public JLabel labelCarita, imagenIBERO;

	
	
	/**
	 * Constructor de la clase 
	 * Crea objetos (botones, etiquetas, cuadros de texto) y los agrega al panel (declarado aqui mismo)
	 * Modificando de estos objetos sus tamaños, colores y posiciones
	 */
	public PanelIzquierdo() {
		this.setLayout(null);
		int tx=160, ty=25;
		imagenIBERO = new JLabel();
		imagenIBERO.setIcon(new ImageIcon("/home/im21smv/ebrio.png"));
		imagenIBERO.setBounds(30, 5, 330, 140);
		this.add(imagenIBERO);
		
		bRutaDatos = new JButton("Ruta datos");
		bRutaDatos.setBounds(30, 170, tx, ty);
		bRutaDatos.setBackground(new Color(245,124,0));
		this.add(bRutaDatos);
		
		iRutaDatos=new JTextField(15);
		iRutaDatos.setBounds(200, 170, tx, ty);
		this.add(iRutaDatos);
			
		bRutaPalabras = new JButton("Ruta Palabras");
		bRutaPalabras.setBounds(30, 205, tx, ty);
		bRutaPalabras.setBackground(new Color(245,124,0));
		this.add(bRutaPalabras);
		
		iRutaPalabras=new JTextField(15);
		iRutaPalabras.setBounds(200, 205, tx, ty);
		this.add(iRutaPalabras);
		
		bGenerarGrafica = new JButton("Generar gráfica");
		bGenerarGrafica.setBounds(30, 240, 330, ty);
		bGenerarGrafica.setBackground(new Color(244,81,30));
		this.add(bGenerarGrafica);
		
		bEtiquetado = new JButton("Etiquetado");
		bEtiquetado.setBounds(30, 275, tx, ty);
		bEtiquetado.setBackground(new Color(121,85,72));
		this.add(bEtiquetado);
		
		bClasificacion = new JButton("Clasificación");
		bClasificacion.setBounds(30, 310, tx, ty);
		bClasificacion.setBackground(new Color(121,85,72));
		this.add(bClasificacion);
		
		iClasificacion=new JTextField(15);
		iClasificacion.setBounds(200, 310, tx, ty);
		this.add(iClasificacion);
		
		labelCarita=new JLabel("✍( ^︠ ᴗ ︡^)");
		labelCarita.setBounds(30, 345, tx, ty);
		this.add(labelCarita);
	}//Cierre del constructor
}