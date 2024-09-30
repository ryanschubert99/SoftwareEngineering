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
	private List<int[][]> Matrices;
	private DataStorageImp data;
	
	public DataStorageImp(ComputeRequest compute) throws IOException {
		this.computeE = compute;
		this.inputFileName = computeE.getInputConfig().getInputFileName();
		this.outputFileName = computeE.getOutputConfig().getOutputFileName();
		Scanner scanner = new Scanner(System.in);
		if(compute.getInputConfig().getInputTypeValue() == 0) {
		  this.amountToGenerate  = compute.getInputConfig().getNumberOfMatrices();
		  
		  ComputeEngineImp computeEng = new ComputeEngineImp(this);
		  
		  System.out.println("Type 1 to Output Matrices or Type 0 to do Computations");
		  if(scanner.nextInt() == 1) {
			  writeOutput(this.outputFileName,";");
		  } else {
			  computeEng.MultiplyMatrix(Matrices);
			  writeOutput(this.outputFileName,";");
		  }
			}
		 else {
			this.Matrices = readInputFile();
			System.out.println("Type 1 to Output Matrices or Type 0 to do Computations");
			if(scanner.nextInt() == 1) {
			writeOutput(this.outputFileName,";");
		} else {
			ComputeEngineImp computeEng = new ComputeEngineImp(this);
			 computeEng.MultiplyMatrix(Matrices);
			  writeOutput(this.outputFileName,";");
		}
		
	}
}
  public List<int[][]> getMatrices() {
		return Matrices;
	}
	public void setMatrices(List<int[][]> matrices) {
		Matrices = matrices;
	}
@Override
  public void writeOutput(String outputFileName, String delimiter) {
	    // Check if the output file name is null
	    

	    int outputTypeValue = computeE.getOutputConfig().getOutputTypeValue();
	    
	    if ((outputTypeValue == 1) && (this.outputFileName == null)) {
	        throw new IllegalArgumentException("Output file name cannot be null");
	    }
	    
	    // If outputTypeValue is 0, write to the console
	    if (outputTypeValue == 0) {
	        System.out.println("Outputting matrices to console:");
	        for (int[][] matrix : Matrices) {
	            printMatrixToConsole(matrix, delimiter);
	        }
	    }
	    // If outputTypeValue is 1, write to the specified output file
	    else if (outputTypeValue == 1) {
	        System.out.println("Writing matrices to file: " + outputFileName);
	        try (FileWriter fileWriter = new FileWriter(outputFileName)) {
	            for (int[][] matrix : Matrices) {
	                writeMatrixToFile(fileWriter, matrix, delimiter);
	            }
	            // Flush is optional as try-with-resources will handle closing automatically
	            fileWriter.flush();
	        } catch (IOException e) {
	            System.out.println("Error writing to file: " + e.getMessage());
	        }
	    } else {
	        System.out.println("Invalid output type value: " + outputTypeValue);
	    }
	}

  // Helper method to print a matrix to the console
  private void printMatrixToConsole(int[][] matrix, String delimiter) {
      for (int[] row : matrix) {
          for (int element : row) {
              System.out.print(element + delimiter);
          }
          System.out.println(); // New line after each row
      }
      System.out.println(); // Blank line between matrices
  }

  // Helper method to write a matrix to a file
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
	    int rows = computeE.getInputConfig().getRows();      // Get predefined number of rows
	    int columns = computeE.getInputConfig().getColumns();  // Get predefined number of columns

	    List<int[][]> matrices = new ArrayList<>();  // List to store the matrices
	    try (BufferedReader br = new BufferedReader(new FileReader(inputFileName))) {
	        String line;

	        // Continuously read matrices until end of file
	        while (true) {
	            int[][] matrix = new int[rows][columns];
	            int currentRow = 0;

	            // Read rows for the current matrix
	            while (currentRow < rows) {
	                line = br.readLine(); // Read a new line

	                // Check if we reached the end of the file
	                if (line == null) {
	                    if (currentRow < rows) {
	                        //throw new IOException("Unexpected end of file. Not enough rows for matrix. Expected " + rows + " rows, but only found " + currentRow + ".");
	                    }
	                    return matrices; // If we filled the matrix, return the list
	                }

	                // Skip any empty lines
	                if (line.trim().isEmpty()) {
	                    continue; // Skip blank lines
	                }

	                System.out.println("Reading line: \"" + line + "\"");

	                // Split the line using multiple delimiters
	                String[] splitLine = line.trim().split("[;,\\s]+"); // Split by ;, space, or comma
	                if (splitLine.length != columns) {
	                    throw new IOException("Incorrect number of columns in row " + (currentRow + 1) + ": Expected " + columns + ", but found " + splitLine.length);
	                }

	                for (int j = 0; j < columns; j++) {
	                    matrix[currentRow][j] = Integer.parseInt(splitLine[j]);
	                }
	                currentRow++; // Increment to the next row after reading
	            }

	            // Add the filled matrix to the list
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
	// TODO Auto-generated method stub
	return null;
}
@Override
public List<int[][]> readInputArrs(List<int[][]> a) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public void writeOutput(int[][] matrix, String outputSource, String delimiter) {
	// TODO Auto-generated method stub
	
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

