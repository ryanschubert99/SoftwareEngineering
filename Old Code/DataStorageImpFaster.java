package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import src.ComputeResult;
import src.ComputeResult.ComputeResultStatus;

public class DataStorageImpFaster implements DataStorage{

  private ComputeRequest computeE;
  private String inputFileName;
  private String outputFileName;
  private int amountToGenerate;
  private List<long[][]> matrices;
  private boolean valid = false;
  private int input;
  private int outputOrCompute;
  
 // public DataStorageImp() {}

  public DataStorageImpFaster(ComputeRequest compute, int outputOrComp) throws IOException {
    this.computeE = compute;
    this.outputOrCompute = outputOrComp;
    this.inputFileName = computeE.getInputConfig().getInputFileName();
    this.outputFileName = computeE.getOutputConfig().getOutputFileName();

    if (compute.getInputConfig().getInputTypeValue() == 0) {
      this.amountToGenerate = compute.getInputConfig().getNumberOfMatrices();
      ComputeEngineImpFaster computeEng = new ComputeEngineImpFaster(this);

      if (outputOrCompute == 1) {
        writeOutput(this.outputFileName, ";");
      } else {
        this.matrices = computeEng.multiplyMatrix(matrices);
        writeOutput(this.outputFileName, ";");
      }
    } else {
      this.matrices = readInputFile();
      
      if (outputOrCompute == 1) {
        writeOutput(this.outputFileName, ";");
      } else {
        ComputeEngineImpFaster computeEng = new ComputeEngineImpFaster(this);
        this.matrices = computeEng.multiplyMatrix(matrices);
        writeOutput(this.outputFileName, ";");
      }
    }

    // Signal that computation succeeded
    signalComputationSuccess();
  }

  private void signalComputationSuccess() {
    System.out.println("Computation completed successfully");
  }

  public List<long[][]> getMatrices() {
    return matrices;
  }

  public void setMatrices(List<long[][]> genMatrix) {
    this.matrices = genMatrix;
  }

  @Override
  public void writeOutput(String outputFileName, String delimiter) {
    int outputTypeValue = computeE.getOutputConfig().getOutputTypeValue();
// add return type of other enum 
    if ((outputTypeValue == 1) && (this.outputFileName == null)) {
      throw new IllegalArgumentException("Output file name cannot be null");
    }

    if (outputTypeValue == 0) {
      System.out.println("Outputting matrices to console:");
      for (long[][] matrix : matrices) {// this is null 
        printMatrixToConsole(matrix, delimiter);
      }
    } else if (outputTypeValue == 1) {
      System.out.println("Writing matrices to file: " + outputFileName);
      try (FileWriter fileWriter = new FileWriter(outputFileName)) {
        for (long[][] matrix : matrices) {
          writeMatrixToFile(fileWriter, matrix, delimiter);
        }
        fileWriter.flush();
      } catch (IOException e) {
        System.out.println("Error writing to file: " + e.getMessage());
      }
    } else {
      System.out.println("Invalid output type value: " + outputTypeValue);
    }
  }

  private void printMatrixToConsole(long[][] matrix, String delimiter) {
    for (long[] row : matrix) {
      for (long element : row) {
        System.out.print(element + delimiter);
      }
      System.out.println(); // New line after each row
    }
    System.out.println(); // Blank line between matrices
  }

  private void writeMatrixToFile(FileWriter fileWriter, long[][] matrix, String delimiter) throws IOException {
    for (long[] row : matrix) {
      for (long element : row) {
        fileWriter.write(element + delimiter);
      }
      fileWriter.write("\n"); // New line after each row
    }
    fileWriter.write("\n"); // Blank line between matrices
  }

  @Override
  //std::pair<Value, error_code>
  // either return to throw the result or an error code 
  public List<long[][]> readInputFile() throws IOException {
    String[] splitLine = null;
    int rows = computeE.getInputConfig().getRows(); // Get predefined number of rows
    int columns = computeE.getInputConfig().getColumns(); // Get predefined number of columns

    List<long[][]> matrices = new ArrayList<>(); // List to store the matrices
    try (BufferedReader br = new BufferedReader(new FileReader(inputFileName))) {
      String line;

      while (true) {
        long[][] matrix = new long[rows][columns];
        int currentRow = 0;

        while (currentRow < rows) {
          line = br.readLine(); // Read a new line

          if (line == null) {
            return matrices; // If we filled the matrix, return the list
          }

          if (line.trim().isEmpty()) {
            continue; // Skip blank lines
          }

          System.out.println("Reading line: \"" + line + "\"");
          try {
            splitLine = line.trim().split("[;,\\s]+"); // Split by ;, space, or comma
            if (splitLine.length != columns) {
              throw new IOException(
                "Incorrect number of columns in row " + (currentRow + 1) + ": Expected " + columns + ", but found " + splitLine.length
              );
            }
          } catch (IOException e) {
            System.out.println("Invalid Input: " + e.getMessage());
          }

          for (int j = 0; j < columns; j++) {
            matrix[currentRow][j] = Integer.parseInt(splitLine[j]);
          }
          currentRow++; // Increment to the next row after reading
        }

        matrices.add(matrix);
      }
    }
  }

  public ComputeRequest getComputeE() {
    return computeE;
  }

  public void setComputeE(ComputeRequest computeE) {
    this.computeE = computeE;
  }

  public int getAmountToGenerate() {
    return amountToGenerate;
  }

  public void setAmountToGenerate(int amountToGenerate) {
    this.amountToGenerate = amountToGenerate;
  }
}
