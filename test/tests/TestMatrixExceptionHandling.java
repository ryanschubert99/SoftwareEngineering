package tests;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import src.MatrixImplementationSlow;

public class TestMatrixExceptionHandling {
 // @Test
  public void testMultiplyMatrices_ThrowsExceptionForIncompatibleDimensions() {
    MatrixImplementationSlow matrixImplementationSlow = new MatrixImplementationSlow();
    
    long[][] matrix1 = {{1, 2}, {3, 4}}; 
    long[][] matrix2 = {{1, 2, 3}};  

	// Expect an IllegalArgumentException due to incompatible dimensions
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
      matrixImplementationSlow.multiplyTwoMatrices(matrix1, matrix2);
    });
     // Verify the exception message
    Assertions.assertEquals("Matrix multiplication is not possible due to incompatible dimensions ", exception.getMessage());
  }
  //@Test
  public void testPrintMatrix_ThrowsExceptionForMismatchedDimensions() {
    MatrixImplementationSlow matrixImplementationSlow = new MatrixImplementationSlow();
		    
    long[][] matrix = {{1, 2}, {3, 4}}; // 2x2 matrix
    // Expect an IllegalArgumentException due to mismatched dimensions (3x3 requested but matrix is 2x2)
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
      matrixImplementationSlow.printMatrix(matrix, 3, 3);
    });		   
    // Verify the exception message
    Assertions.assertEquals("The provided dimensions do not match the actual matrix size.", exception.getMessage());
  }
}

