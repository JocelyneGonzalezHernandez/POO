package prueba;

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

public class BarChart extends ApplicationFrame{

	private static final long serialVersionUID = 1L;
	static int numSi=0;
	static int numNo=0;

// constructor, título ventana, valores a graficar. 
 public BarChart(String applicationTitle, int numSi, int numNo) {
   
  super(applicationTitle);
  BarChart.numSi=numSi;
  BarChart.numNo=numNo;
  // En el constructor se crea objeto de tipo Panel.
  // El método se define más abajo
  JPanel content = createDemoPanel();
  // Dimensiones del panel creado. 
  content.setPreferredSize(new java.awt.Dimension(700, 700));
  getContentPane().add(content);
 }

 // Conjnto de datos, para colocar en la gráfic. 
  private static DefaultCategoryDataset createDataset() {
  
	  DefaultCategoryDataset result = new DefaultCategoryDataset();
                   // valor, identificador, etiqueta
   result.setValue(369, "A", "SI");
   result.setValue(numNo, "B", "NO");
   result.setValue(134, "C", "Data");
   result.setValue(239, "D", "Hola");
   result.setValue(numSi, "E", "Emplea");
    return result;
 }

 // se crea el Panel.
 public static JPanel createDemoPanel() {
 
  JFreeChart chart = ChartFactory.createBarChart3D("Frecuencia", "Palabras buscadas",
    "Numero de ocurrencias", createDataset(), // Aquí están los datos. 
    PlotOrientation.VERTICAL, true,  
    true, false);
  CategoryPlot plot = (CategoryPlot) chart.getPlot();
  CategoryAxis xAxis = (CategoryAxis) plot.getDomainAxis();
  xAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45); // Inclinar 45 grados etiquetas eje X
  plot.setBackgroundAlpha(0.5f);
   
  ChartPanel chartPanel = new ChartPanel(chart);
  // regresa panel con propiedades. 
  return chartPanel;

 }

 
 
 public static void main(String[] args) {
  BarChart demo = new BarChart("Ejemplo gráfica barras MFG 2021",10,15);
  demo.pack();
  demo.setVisible(true);
 }


}