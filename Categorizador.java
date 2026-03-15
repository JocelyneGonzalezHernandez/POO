package com.smv.modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

import opennlp.tools.doccat.BagOfWordsFeatureGenerator;
import opennlp.tools.doccat.DoccatFactory;
import opennlp.tools.doccat.DoccatModel;
import opennlp.tools.doccat.DocumentCategorizerME;
import opennlp.tools.doccat.DocumentSample;
import opennlp.tools.doccat.DocumentSampleStream;
import opennlp.tools.doccat.FeatureGenerator;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.InputStreamFactory;
import opennlp.tools.util.MarkableFileInputStreamFactory;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;
import opennlp.tools.util.TrainingParameters;
import opennlp.tools.util.model.ModelUtil;

/**
 * Esta clase 
 * @author Michelle Perez Aguilar
 * @author Sebastián Méndez villegas
 * @version 21/04/2023
 */
public class Categorizador {
	
	//Campos de la clase
	ArrayList <String> archivo = new ArrayList<>();
	public LeerArchivo objLeerArchivo = new LeerArchivo();
	public LimpiarArchivo objLimpiarArchivo = new LimpiarArchivo();
	int a;
	
	
	
	/**
	 * 
	 * @param oracion String de la linea a categorizar o etiquetar
	 * @return Resultado de la etiqueta designada
	 * @throws Exception
	 */
	public String Algoritmo(String oracion) throws Exception {	 
		// Calsifica texto en categorías predefinidas. Basado en la máxima entropía. 	 
		// Archivo con los ejemplo de clasificación. Este es el modelo
		ReescribirArchivo();
		InputStreamFactory inputStreamFactory = new MarkableFileInputStreamFactory(new File("/home/im21smv/categorizador.txt"));
		ObjectStream<String> lineStream = new PlainTextByLineStream(inputStreamFactory, StandardCharsets.UTF_8);
		ObjectStream<DocumentSample> sampleStream = new DocumentSampleStream(lineStream);
		// CUT_OFF, como 0, se utilizan pocas muestras. 
		// BagOfWordsFeatureGenerator Utiliza las palabras del model
		TrainingParameters params = ModelUtil.createDefaultTrainingParameters();
		params.put(TrainingParameters.CUTOFF_PARAM, 0);
		DoccatFactory factory = new DoccatFactory(new FeatureGenerator[] { new BagOfWordsFeatureGenerator() });
		// Aquí comienza el entrenamiento del modelo. 
		DoccatModel model = DocumentCategorizerME.train("en", sampleStream, params, factory);
		// Archivo que se carga directamente al modelo, se reutiliza. 
		model.serialize(new File("/home/im21smv/documentcategorizer.bin"));
 
		// Se carga el modelo entrenado
		try (InputStream modelIn = new FileInputStream("/home/im21smv/documentcategorizer.bin");
				Scanner scanner = new Scanner(System.in);) {
				// categorización
				DocumentCategorizerME myCategorizer = new DocumentCategorizerME(model);
				// Frase a categorizar.
				double[] probabilitiesOfOutcomes = myCategorizer.categorize(getTokens(oracion));
				// Se obtiene la categoría de la frase ingresada.
				String category = myCategorizer.getBestCategory(probabilitiesOfOutcomes);
				System.out.println("Category: " + category);
				return category;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}//Cierre del metodo
	
	
	
	/**
	 * 
	 * @param sentence Es la linea a categorizar
	 * @return
	 */
	public String[] getTokens(String sentence) {
		 
		// Use model that was created in earlier tokenizer tutorial
		try (InputStream modelIn = new FileInputStream("/home/im21smv/tokenizermodel.bin")) {
			TokenizerME myCategorizer = new TokenizerME(new TokenizerModel(modelIn));
			String[] tokens = myCategorizer.tokenize(sentence);
			/*for (String t : tokens) {
				System.out.println("Tokens: " + t);
			}*/
			return tokens;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}//Cierre del metodo

	
	
	/**
	 * Este metodo lee y reescribe lo que hay en el archivo "/home/im21smv/categorizador.txt" limpiandolo
	 */
	public void ReescribirArchivo() {
		try {
			archivo=objLeerArchivo.leer("/home/im21smv/categorizador.txt");
			archivo=objLimpiarArchivo.limpia(archivo);
            File file = new File("/home/im21smv/categorizador.txt");
            if (file.exists()) {
            	file.delete();
            }
            PrintWriter writer = new PrintWriter("/home/im21smv/categorizador.txt", "UTF-8");
    		for(a=0; a<(archivo.size());a++)
    			writer.println(archivo.get(a));
    		writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}//Cierre del metodo
}//Cierre de la clase
