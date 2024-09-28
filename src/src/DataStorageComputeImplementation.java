package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataStorageComputeImplementation implements DataStorageCompute {
	
	private ComputeRequest computeE;
	private String inputFileName;
	private String outputFileName;
	private int amountToGenerate;
	private List<int[][]> Matrices;
	
	public DataStorageComputeImplementation(ComputeRequest compute) throws IOException {
		this.computeE = compute;
		this.inputFileName = compute.getInputConfig().getInputFileName();
		
		Scanner scanner = new Scanner(System.in);
		if(compute.getInputConfig().getInputTypeValue() == 0) {
		  this.amountToGenerate  = compute.getInputConfig().getNumberOfMatrices();
			}
		 else {
			this.Matrices = readInputFile();
		}
		
	}
  @Override
  public void writeOutput(int[][] matrix, String outputSource, String delimiter) {
	    
  }
  @Override
  public List<int[][]> readInputFile() throws IOException {
      int rows = computeE.getInputConfig().getRows();      // Get predefined number of rows
      int columns = computeE.getInputConfig().getColumns();  // Get predefined number of columns

      List<int[][]> matrices = new ArrayList<>();  // List to store the matrices

      try (BufferedReader br = new BufferedReader(new FileReader(inputFileName))) {
          String line;
          while ((line = br.readLine()) != null) {
              // Create a new 2D array for each matrix
              int[][] matrix = new int[rows][columns];

              for (int i = 0; i < rows; i++) {
                  line = br.readLine();  // Read each row
                  if (line == null) {
                      throw new IOException("Unexpected end of file. Not enough rows for matrix.");
                  }

                  String[] splitLine = line.trim().split("\\s+");
                  if (splitLine.length != columns) {
                      throw new IOException("Incorrect number of columns in row: " + (i + 1));
                  }

                  for (int j = 0; j < columns; j++) {
                      matrix[i][j] = Integer.parseInt(splitLine[j]);
                  }
              }

              // Add the matrix to the list of matrices
              matrices.add(matrix);
          }
      }

      return matrices;
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
	// TODO Auto-generated method stub
	return null;
}
@Override
public List<int[][]> readInputArrs(List<int[][]> a) {
	// TODO Auto-generated method stub
	return null;
}
}

