package src;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class ComputeEngineImplementation implements ComputeEngine {
	
	private String inputSource;
	private String outputSource;
	private String delimiter;
	
  @Override
  public void initializeAction(String inputSource, String outputSource, String delimiter) {
	  this.inputSource = inputSource;
	  this.outputSource = outputSource;
	  this.delimiter = (delimiter != null && !delimiter.isEmpty()) ? delimiter : ",";

  }
  
  
  @Override
  public int[][] performComputation(int[][] matrix1, int[][] matrix2) {
	  int rows1 = matrix1.length;
	  int cols1 = matrix1[0].length;
	  int rows2 = matrix2.length;
	  int cols2 = matrix2[0].length;
	  
	  if (cols1 != rows2)
	  {
		  throw new IllegalArgumentException("Matrix multiplication is not possible with the given dimensions.");
	
	  }
	  
	  int[][] resultantMatrix = new int[rows1][cols2];
	  
	  for (int i = 0; i < rows1; i++)
	  {
		  for (int j = 0; j < cols2; j++)
		  {
			  for (int k = 0; k < cols1; k++)
			  {
				  resultantMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
			  }
		  }
	  }
	  
	  
	  return resultantMatrix;
    //return new int[0][0]; // Return an empty matrix
  }
  
  
  @Override
  public int[][] generateMatrix(int row, int col) {
	  
	  int[][] matrix = new int[row][col];
	  Random random = new Random();
	  
	  for (int i = 0; i < row; i++)
	  {
		  for (int j = 0; j < col; j++)
		  {
			  matrix[i][j] = random.nextInt(100);
		  }
	  }
	  
	  return matrix;
    //return new int[10][10]; // Return an empty matrix
  }
  
  
  @Override
  public void finalizeAction(int[][] resultMatrix, String outputSource, String delimiter) {
	  
	  try (FileWriter writer = new FileWriter(outputSource))
	  {
		  for (int[] row : resultMatrix)
		  {
			  for (int i = 0; i < row.length; i++)
			  {
				  writer.write(row[i] + (i < row.length - 1 ? delimiter : ""));
			  }
			  writer.write(System.lineSeparator());
		  }
	  }
	  
	  catch (IOException e)
	  {
		  e.printStackTrace();
	  }
	  
  }
}


