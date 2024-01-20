package com.demo.voiture.models.message;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Base64;


public class FileToBase64StringConversionUnitTest {
    private String inputFilePath = "/home/hasinjara/z_mael/etude/Doc_S5/Others/test1.jpeg";
    private String outputFilePath = "/home/hasinjara/z_mael/etude/Doc_S5/Others/test_image_copy.jpg";


    public void fileToBase64StringConversion() throws IOException {

        // load file from /src/test/resources
        try {
          ClassLoader classLoader = getClass().getClassLoader();
          System.out.println(inputFilePath);
          File inputFile = new File(inputFilePath);

        byte[] fileContent = FileUtils.readFileToByteArray(inputFile);
        String encodedString = Base64
          .getEncoder()
          .encodeToString(fileContent);
        System.out.println("Ok OK 1");



        // create output file
        // File outputFile = new File(inputFile
        //   .getParentFile()
        //   .getAbsolutePath() + File.pathSeparator + outputFilePath);
          
        File outputFile = new File(outputFilePath);
        System.out.println("Ok OK 2 "+outputFile.getAbsolutePath());

        // decode the string and write to file
        byte[] decodedBytes = Base64
          .getDecoder()
          .decode(encodedString);
        FileUtils.writeByteArrayToFile(outputFile, decodedBytes);
        } catch (Exception e) {
          // TODO: handle exception
          throw e;
        }
        
    }
}
