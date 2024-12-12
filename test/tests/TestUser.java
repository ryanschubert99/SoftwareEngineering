package tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import src.ComputationCoordinatorImp;

public class TestUser {
  private final ComputationCoordinatorImp coordinator;

  public TestUser(ComputationCoordinatorImp coordinator) {
    this.coordinator = coordinator;
  }

  public void run(String outputPath) throws Exception {
    // Correct the path to match where your CSV file is located
    String configPath = "test" + File.separatorChar + "tests" + File.separatorChar + "testInputFile.csv"; // Updated path
    String delimiter = ";" ;

    // Read configuration values from the CSV file
    try (BufferedReader br = new BufferedReader(new FileReader(configPath))) {
      br.readLine(); // Skip header row if there is one
      String line;
      if ((line = br.readLine()) != null) {
        String[] config = line.split(",");

        // Parse values from CSV line
        int inputType = Integer.parseInt(config[2].trim());
        String inputFile = config[1].trim();
        int numGenerate = Integer.parseInt(config[2].trim());
        int numRows = Integer.parseInt(config[3].trim());
        int numCols = Integer.parseInt(config[4].trim());
        int outputType = Integer.parseInt(config[5].trim());
        String outputFileName = config[6].trim();
        int outOrCompute = Integer.parseInt(config[7].trim());

        // Print parsed values to console for verification
        System.out.println("Parsed Configuration Values:");
        System.out.println("Input Type: " + inputType);
        System.out.println("Output File: " + inputFile);
        System.out.println("Number to Generate: " + numGenerate);
        System.out.println("Number of Rows: " + numRows);
        System.out.println("Number of Columns: " + numCols);
        System.out.println("Output Type: " + outputType);
        System.out.println("Output File Name: " + outputFileName);
        System.out.println("Out or Compute: " + outOrCompute);

        // Call the computation method with parsed values
        coordinator.beginComputationSingleSlow(0,"",inputType, inputFile, numGenerate, numRows, numCols, delimiter, outputType, outputPath, outOrCompute);
        //int inputType, String inputFileName, int numberOfMatrices, int rows, int columns,String delimiter, int outputType, String outputFileName, int outputOrComp
      }
    } catch (IOException e) {
      e.printStackTrace();
      System.err.println("Error reading configuration file: " + configPath);
    }
  }
}
