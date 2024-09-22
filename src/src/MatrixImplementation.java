package src;
import java.util.Random;

public class MatrixImplementation implements MatrixAPIInterface{
  @Override
  public int[][] generateMatrix(int rows, int cols){
    Random random = new Random();
    int[][] matrix = new int[rows][cols];
    for (int i = 0; i < rows; i++){
      for (int j = 0; j < cols; j++){
        matrix[i][j] = random.nextInt(100);
      }
    }
    return matrix;
  }

  @Override
    public int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2){
    int rows1 = matrix1.length;
    int cols1 = matrix1[0].length;
    int cols2 = matrix2[0].length;
    if (cols1 != matrix2.length){
      throw new IllegalArgumentException("Matrix multiplication is not possible due to incompatible dimensions");
    }
    int[][] resultantMatrix = new int[rows1][cols2];
    for (int i = 0; i < rows1; i++){
      for (int j = 0; j < cols2; j++){
        for (int k = 0; k < cols1; k++){
          resultantMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
        }
      }
    }
    return resultantMatrix;
  }

}
