package org.example;

import de.daslaboratorium.machinelearning.classifier.Classifier;
import de.daslaboratorium.machinelearning.classifier.bayes.BayesClassifier;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String pathPositiveTexts = "src\\main\\resources\\positiveTexts.txt";
        String pathNegativeTexts = "src\\main\\resources\\negativeTexts.txt";

    }

    public static List<String> getTexts(String path){
        List<String> listTexts = new ArrayList<>();

        try (BufferedReader bf = new BufferedReader(new FileReader(path))) {
            String line = bf.readLine();

            while (line != null) {

                line = Normalizer.normalize(line, Normalizer.Form.NFD)
                        .replaceAll("[^\\p{ASCII}]", "")
                        .replaceAll("[^a-zA-Z0-9\\s+]", "")
                        .toLowerCase();

                listTexts.add(line);
                line = bf.readLine();
            }

        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        return listTexts;
    }
}