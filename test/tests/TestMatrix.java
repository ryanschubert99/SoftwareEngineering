package tests;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import src.MatrixImplementation;

public class TestMatrix {

  //@Rule 
  public MockitoRule rule = MockitoJUnit.rule();

  //@Test
  public void testMatrixImplementation() {
    MatrixImplementation matrixImplementation = new MatrixImplementation();

    long[][] matrix1 = {{1, 2}, {3, 4}};
    long[][] matrix2 = {{5, 6}, {7, 8}};

    long[][] resultantMatrix = matrixImplementation.multiplyMatrices(matrix1, matrix2);

    assertNotNull(resultantMatrix);
    assertEquals(19, resultantMatrix[0][0]);
    assertEquals(50, resultantMatrix[1][1]);

    verify(matrixImplementation).multiplyMatrices(matrix1, matrix2);
  }
}
