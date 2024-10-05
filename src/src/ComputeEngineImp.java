package src;

import java.util.ArrayList;
import java.util.List;

public class ComputeEngineImp implements ComputeEngine {

  public ComputeEngineImp (List<int[][]> matrices, DataStorageImp data) {
    MatrixImplementation matrixCalc = new MatrixImplementation();
    List<int[][]> generatedMatrices = new ArrayList<>();

    // Check if we need to generate any matrices
    if (data.getAmountToGenerate() != 0) {
      // Generate the specified number of matrices
      for (int i = 0; i < data.getAmountToGenerate(); i++) {
        // Generate a matrix with the specified rows and columns
        int[][] matrix = matrixCalc.generateMatrix(
            data.getComputeE().getInputConfig().getRows(),
            data.getComputeE().getInputConfig().getColumns()
        );

        // Add the generated matrix to the ArrayList
        generatedMatrices.add(matrix);
      }
      data.setMatrices(generatedMatrices);
    }
  }

  public ComputeEngineImp(DataStorageImp data) {
    MatrixImplementation matrixCalc = new MatrixImplementation();
    List<int[][]> generatedMatrices = new ArrayList<>();

    // Check if we need to generate any matrices
    if (data.getAmountToGenerate() != 0) {
      // Generate the specified number of matrices
      for (int i = 0; i < data.getAmountToGenerate(); i++) {
        // Generate a matrix with the specified rows and columns
        int[][] matrix = matrixCalc.generateMatrix(
            data.getComputeE().getInputConfig().getRows(),
            data.getComputeE().getInputConfig().getColumns()
        );

        // Add the generated matrix to the ArrayList
        generatedMatrices.add(matrix);
        data.setMatrices(generatedMatrices);
      }
    }
  }

  @Override
  public void finalizeAction(int[][] resultMatrix, String outputSource, String delimiter) {
    // No-op
  }

  @Override
  public void initializeAction(String inputSource, String outputSource, String delimiter) {
    // TODO Auto-generated method stub
  }

  public void multiplyMatrix(List<int[][]> matrices) {
    // TODO Auto-generated method stub
  }

  public Object performComputation(Object any, Object any2) {
	// TODO Auto-generated method stub
    return null;
  }
}
