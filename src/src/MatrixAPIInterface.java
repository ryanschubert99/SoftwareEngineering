package src;

import java.util.List;

public interface MatrixAPIInterface{
  int[][] generateMatrix(int rows, int cols);

  int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2);

List<int[][]> multiplyMatrices(List<int[][]> generatedMatrices);
}
