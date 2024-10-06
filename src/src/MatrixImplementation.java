package src;

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
    public int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2){
	try {
    int rows1 = matrix1.length;
    int cols1 = matrix1[0].length;
    int cols2 = matrix2[0].length;
    if (cols1 != matrix2.length) {
      throw new IllegalArgumentException("Matrix multiplication is not possible due to incompatible dimensions");
    }
    int[][] resultantMatrix = new int[rows1][cols2];
    for (int i = 0; i < rows1; i++) {
      for (int j = 0; j < cols2; j++) {
        for (int k = 0; k < cols1; k++) {
          resultantMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
        }
      }
    }
    return resultantMatrix;
  }catch(IllegalArgumentException e){
	  System.out.print("Error: " + e.getMessage());
	  e.printStackTrace();
	  // would this errors pass process boundaries? 
	  throw e;
  }	
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
  }catch (IllegalArgumentException e){
	System.out.println("Error: " + e.getMessage());
  } catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Error: Invalid matrix index access.");
  }
  }
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
      System.out.println("Error: " + e.getMessage());
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Error: Invalid matrix index access.");
    }
  }
}
