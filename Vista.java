package com.smv.vista;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;

/**
 * Esta clase controla y organiza la vista del ambiente grafico
 * @author Michelle Perez Aguilar
 * @author Sebastián Méndez villegas
 * @version 20/04/2023
 */
public class Vista extends JFrame{
	
	//Campos de la clase
	private static final long serialVersionUID = 1L;
	public PanelIzquierdo panelIzq;
	public PanelDerecho panelDer;
	
	
	
	/**
	 * Constructor de la clase 
	 * Crea objetos de otras clases (paneles) y los agrega al frame (declarado aqui mismo)
	 */
	public Vista() {
		super("VENTANA PRINCIPAL");
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1300, 480);
		
		setLayout(new GridLayout(1,2));
		
		panelIzq = new PanelIzquierdo();
		panelDer = new PanelDerecho();
		panelDer.setBackground(new Color(255, 255, 255));
		panelIzq.setBackground(new Color(255, 255, 255));
		
		this.add(panelIzq);
		this.add(panelDer);
	}//Cierre del constructor
}//Cierre de la clase
