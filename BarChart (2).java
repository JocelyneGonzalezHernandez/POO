package com.smv.vista;

import java.util.ArrayList;

import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

/**
 * Esta clase genera una grafica de forma dinamica (con los parametros que sus metodos reciben) y la inserta dentro de un panel
 * @author Michelle Perez Aguilar
 * @author Sebastián Méndez villegas
 * @version 28/04/2023
 */
public class BarChart extends ApplicationFrame{

	//Campos de la clase
	private static final long serialVersionUID = 1L;
	static int numSi=0;
	static int numNo=0;
	static ArrayList <Double> valores = new ArrayList <>();
	static ArrayList <String> palabras = new ArrayList <>();

	
	
	/**
	 * Constructor de la clase
	 * @param applicationTitle Parametro que contiene el titulo de la grafica
	 * @param valores Parametro que contiene los valores numerico del numero de repeticiones de determinadas palabras dentro de un archivo
	 * @param palabras Parametro que contiene las palabras buscadas dentro de algun archivo dado
	 */
	public BarChart(String applicationTitle, ArrayList <Double> valores, ArrayList <String> palabras) {
		 super(applicationTitle);
		 this.valores=valores;
		 this.palabras=palabras;
		 JPanel content = createDemoPanel(); 
		 content.setPreferredSize(new java.awt.Dimension(375, 200));
		 getContentPane().add(content);
	 }//Cierre del constructor
	
	
	
	 // Conjnto de datos, para colocar en la gráfic. 
	/**
	 * 
	 * @return
	 */
	  private static DefaultCategoryDataset createDataset() {
		  DefaultCategoryDataset result = new DefaultCategoryDataset();
		  int a;
		  for(a=0; a<(palabras.size());a++)
			  result.setValue(valores.get(a), valores.get(a), palabras.get(a));
	
		  return result;
	 }//Cierre del metodo
	
	  
	  
	 /**
	  * Metodo que crea el panel donde irá la grafica
	  * @return El panel con la grafica
	  */
	 public static JPanel createDemoPanel() {
		 JFreeChart chart = ChartFactory.createBarChart3D("Frecuencia", "Palabras buscadas","Numero de ocurrencias", createDataset(), // Aquí están los datos. 
		 PlotOrientation.VERTICAL, true,true, false);
		 CategoryPlot plot = (CategoryPlot) chart.getPlot();
		 CategoryAxis xAxis = (CategoryAxis) plot.getDomainAxis();
		 xAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
		 plot.setBackgroundAlpha(0.5f);
		 ChartPanel chartPanel = new ChartPanel(chart);
		 return chartPanel;
	 }//Cierre del metodo


}