package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MatrixImplementation implements MatrixAPIInterface {

  public int[][] generateMatrix(int rows, int cols) {
    Random random = new Random();
    int[][] matrix = new int[rows][cols];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        matrix[i][j] = random.nextInt(100);
      }
    }
    return matrix;
  }

  @Override
  public List<int[][]> multiplyMatrices(List<int[][]> generatedMatrices) {
	  // Ensure that at least two matrices are provided for multiplication
	  if (generatedMatrices == null || generatedMatrices.size() < 2) {
	    throw new IllegalArgumentException("At least two matrices are required.");
	  }

	  // Initialize the result with the first matrix in the list
	  int[][] result = generatedMatrices.get(0);

	  // Multiply consecutive matrices
	  for (int i = 1; i < generatedMatrices.size(); i++) {
	    int[][] nextMatrix = generatedMatrices.get(i);

	    // Perform matrix multiplication (dot product)
	    result = multiplyTwoMatrices(result, nextMatrix);
	  }

	  // Create a list to return the resultant matrix
	  List<int[][]> resultList = new ArrayList<>();
	  resultList.add(result);

	  // Return the list containing the final resultant matrix
	  return resultList;
	}

	// Helper method to multiply two matrices
	private int[][] multiplyTwoMatrices(int[][] matrix1, int[][] matrix2) {
	  int rows1 = matrix1.length;
	  int cols1 = matrix1[0].length;
	  int cols2 = matrix2[0].length;

	  if (cols1 != matrix2.length) {
	    throw new IllegalArgumentException("Matrix multiplication is not possible due to incompatible dimensions.");
	  }

	  int[][] resultMatrix = new int[rows1][cols2];

	  // Perform matrix multiplication
	  for (int i = 0; i < rows1; i++) {
	    for (int j = 0; j < cols2; j++) {
	      resultMatrix[i][j] = 0;
	      for (int k = 0; k < cols1; k++) {
	        resultMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
	      }
	    }
	  }

	  return resultMatrix;
	}

  public void printMatrix(int[][] m, int rows, int cols) {
    try {
      if (m.length != rows || m[0].length != cols) {
        throw new IllegalArgumentException("The provided dimensions do not match the actual matrix size.");
      }
      for (int i = 0; i < rows; i++) {
        // Start a new line for each row
        System.out.println();
        for (int j = 0; j < cols; j++) {
          System.out.print(m[i][j] + " ");
        }
      }
      System.out.println();
    } catch (IllegalArgumentException e) {
      System.out.print("Error: " + e.getMessage());
      e.printStackTrace();
      throw e;
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.print("Error Out of bounds: " + e.getMessage());
      e.printStackTrace();
      throw e;
    }
  }

@Override
public int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
	// TODO Auto-generated method stub
	return null;
}
}
