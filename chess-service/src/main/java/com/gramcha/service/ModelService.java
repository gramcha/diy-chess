/**
 * @author gramcha
 * 15-Jan-2018 1:42:23 PM
 * 
 */
package com.gramcha.service;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import weka.classifiers.Classifier;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.SparseInstance;
import weka.core.converters.ConverterUtils.DataSource;

@Service
public class ModelService {

	public Classifier classifier = null;
	
	@PostConstruct
	void loadModel() throws Exception {
		loadRandomForestModel();
		System.out.println("Model loaded...");
		System.out.println(classifier);
	}
	
	public void loadRandomForestModel() throws Exception {
		classifier = loadModelFromFile("/Users/gramachandran/shared_folder_vbox/output_1_less_size_rf.model");
	}
	Classifier loadModelFromFile(String filename) throws Exception {
		return (Classifier) weka.core.SerializationHelper.read(filename);
	}
	Instances loadDataset(String fileName) throws Exception {
		Instances dataset = DataSource.read(fileName);
		return dataset;
	}
	public String evaluate() throws Exception {
		Instances testDataset = loadDataset("/Users/gramachandran/shared_folder_vbox/singletestitem.csv");
		testDataset.setClassIndex(1);
		Instance instance = new DenseInstance(testDataset.firstInstance());
		testDataset.add(0,instance);
		instance = testDataset.firstInstance();
//		25	True 	1	0	-1	1	0
		instance.setClassValue(1.0D);
		System.out.println("predict value of 1 - " + instance.stringValue(1));
		instance.setClassValue(0.0D);
		System.out.println("predict value of 0 - " + instance.stringValue(1));
		instance.setValue(0, 25);
		instance.setValue(1, "True");
		instance.setValue(2, 1);
		instance.setValue(3, 0);
		instance.setValue(4, -1);
		instance.setValue(5, 1);
		instance.setValue(6, 0);
		
		System.out.println("testdataset = "+testDataset);
		System.out.println("copied instance = "+testDataset.firstInstance());
		System.out.println("copied instance = "+instance);
		
		double predictedValue = classifier.classifyInstance(instance);
		System.out.println("predicted value " + predictedValue);
		instance.setClassValue(predictedValue);
		System.out.println("predict value - " + instance.stringValue(1));
		return instance.toString();
	}
}
