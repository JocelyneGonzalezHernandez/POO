package com.mfg.classNLP;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
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


public class ExOpenNLP {

	public static void main(String[] args) throws Exception {
		 
		// Calsifica texto en categorías predefinidas. Basado en la máxima entropía. 
		 
		// Archivo con los ejemplo de clasificación. Este es el modelo
		InputStreamFactory inputStreamFactory = new MarkableFileInputStreamFactory(new File("/home/mfg/Documentos/Ibero2022/otono2022/PooOtono2022/ProyClasification/documentcategorizer.txt"));
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
		model.serialize(new File("/home/mfg/Documentos/Ibero2022/otono2022/PooOtono2022/ProyClasification/documentcategorizer.bin"));
 
		
		// Se carga el modelo entrenado
		try (InputStream modelIn = new FileInputStream("/home/mfg/Documentos/Ibero2022/otono2022/PooOtono2022/ProyClasification/documentcategorizer.bin");
				Scanner scanner = new Scanner(System.in);) {
 
			while (true) {
				
				System.out.println("Enter a sentence:");
 
				// categorización
				DocumentCategorizerME myCategorizer = new DocumentCategorizerME(model);
 
				// Frase a categorizar.
				double[] probabilitiesOfOutcomes = myCategorizer.categorize(getTokens(scanner.nextLine()));
 
				// Se obtiene la categoría de la frase ingresada.
				String category = myCategorizer.getBestCategory(probabilitiesOfOutcomes);
				System.out.println("Category: " + category);
 
			}
 
		} catch (Exception e) {
			e.printStackTrace();
		}
 
	}
 

	private static String[] getTokens(String sentence) {
 
		// Use model that was created in earlier tokenizer tutorial
		try (InputStream modelIn = new FileInputStream("/home/mfg/Documentos/Ibero2022/otono2022/PooOtono2022/ProyClasification/tokenizermodel.bin")) {
 
			TokenizerME myCategorizer = new TokenizerME(new TokenizerModel(modelIn));
 
			String[] tokens = myCategorizer.tokenize(sentence);
 
			for (String t : tokens) {
				System.out.println("Tokens: " + t);
			}
			return tokens;
 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
 
	

}
