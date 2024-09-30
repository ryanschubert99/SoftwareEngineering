package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataStorageImp implements DataStorageCompute {

  private ComputeRequest computeE;
  private String inputFileName;
  private String outputFileName;
  private int amountToGenerate;
  private List<int[][]> matrices;
  private DataStorageImp data;

  public DataStorageImp(ComputeRequest compute) throws IOException {
    this.computeE = compute;
    this.inputFileName = computeE.getInputConfig().getInputFileName();
    this.outputFileName = computeE.getOutputConfig().getOutputFileName();
    Scanner scanner = new Scanner(System.in);
    if (compute.getInputConfig().getInputTypeValue() == 0) {
      this.amountToGenerate = compute.getInputConfig().getNumberOfMatrices();
      ComputeEngineImp computeEng = new ComputeEngineImp(this);
      System.out.println("Type 1 to Output Matrices or Type 0 to do Computations");
      if (scanner.nextInt() == 1) {
        writeOutput(this.outputFileName, ";");
      } else {
        computeEng.multiplyMatrix(matrices);
        writeOutput(this.outputFileName, ";");
      }
    } else {
      this.matrices = readInputFile();
      System.out.println("Type 1 to Output Matrices or Type 0 to do Computations");
      if (scanner.nextInt() == 1) {
        writeOutput(this.outputFileName, ";");
      } else {
        ComputeEngineImp computeEng = new ComputeEngineImp(this);
        computeEng.multiplyMatrix(matrices);
        writeOutput(this.outputFileName, ";");
      }
    }
  }

  public List<int[][]> getMatrices() {
    return matrices;
  }

  public void setMatrices(List<int[][]> matrices) {
    matrices = matrices;
  }

  @Override
  public void writeOutput(String outputFileName, String delimiter) {
    int outputTypeValue = computeE.getOutputConfig().getOutputTypeValue();

    if ((outputTypeValue == 1) && (this.outputFileName == null)) {
      throw new IllegalArgumentException("Output file name cannot be null");
    }

    if (outputTypeValue == 0) {
      System.out.println("Outputting matrices to console:");
      for (int[][] matrix : matrices) {
        printMatrixToConsole(matrix, delimiter);
      }
    } else if (outputTypeValue == 1) {
      System.out.println("Writing matrices to file: " + outputFileName);
      try (FileWriter fileWriter = new FileWriter(outputFileName)) {
        for (int[][] matrix : matrices) {
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

  private void printMatrixToConsole(int[][] matrix, String delimiter) {
    for (int[] row : matrix) {
      for (int element : row) {
        System.out.print(element + delimiter);
      }
      System.out.println(); // New line after each row
    }
    System.out.println(); // Blank line between matrices
  }

  private void writeMatrixToFile(FileWriter fileWriter, int[][] matrix, String delimiter) throws IOException {
    for (int[] row : matrix) {
      for (int element : row) {
        fileWriter.write(element + delimiter);
      }
      fileWriter.write("\n"); // New line after each row
    }
    fileWriter.write("\n"); // Blank line between matrices
  }

  @Override
  public List<int[][]> readInputFile() throws IOException {
    int rows = computeE.getInputConfig().getRows(); // Get predefined number of rows
    int columns = computeE.getInputConfig().getColumns(); // Get predefined number of columns

    List<int[][]> matrices = new ArrayList<>(); // List to store the matrices
    try (BufferedReader br = new BufferedReader(new FileReader(inputFileName))) {
      String line;

      while (true) {
        int[][] matrix = new int[rows][columns];
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

          String[] splitLine = line.trim().split("[;,\\s]+"); // Split by ;, space, or comma
          if (splitLine.length != columns) {
            throw new IOException(
              "Incorrect number of columns in row " + (currentRow + 1) + ": Expected " + columns + ", but found " + splitLine.length
            );
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

  @Override
  public List<Integer> readInputInts(String inputSource) {
    return new ArrayList<Integer>();
  }

  @Override
  public int readInput(String inputSource) {
    return 0;
  }

  @Override
  public int[][] readInputArr(String inputSource) {
    return null;
  }

  @Override
  public List<int[][]> readInputArrs(String inputSource) {
    return null;
  }

  @Override
  public List<int[][]> readInputArrs(List<int[][]> a) {
    return null;
  }

  @Override
  public void writeOutput(int[][] matrix, String outputSource, String delimiter) {}

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
