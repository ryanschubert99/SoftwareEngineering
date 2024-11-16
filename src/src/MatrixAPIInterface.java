package src;

import java.util.List;

public interface MatrixAPIInterface{
  long[][] generateMatrix(int rows, int cols);

  long[][] multiplyMatrices(long[][] matrix1, long[][] matrix2);

  List<long[][]> multiplyMatrices(List<long[][]> generatedMatrices);
}
