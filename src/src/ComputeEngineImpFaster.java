package src;

import java.util.ArrayList;
import java.util.List;

public class ComputeEngineImpFaster implements ComputeEngine {
  private List<long[][]> matrices = new ArrayList<>();

  public ComputeEngineImpFaster(List<long[][]> matrices, DataStorageImpFaster data) {
    MatrixImplementationSlow matrixCalc = new MatrixImplementationSlow();
    //List<long[][]> generatedMatrices = new ArrayList<>();

    // Check if we need to generate any matrices
    if (data.getAmountToGenerate() != 0) {
      for (int i = 0; i < data.getAmountToGenerate(); i++) {
        // Generate a matrix with the specified rows and columns
        long[][] matrix = matrixCalc.generateMatrix(
            data.getComputeE().getInputConfig().getRows(),
            data.getComputeE().getInputConfig().getColumns()
        );

        // Add the generated matrix to the ArrayList
        this.matrices.add(matrix);
      }
      data.setMatrices(matrices);
    }
  }

  public ComputeEngineImpFaster(DataStorageImpFaster data) {
    MatrixImplementationFast matrixCalc = new MatrixImplementationFast();
	    //List<long[][]> generatedMatrices = new ArrayList<>();

	    // Check if we need to generate any matrices
	    if (data.getAmountToGenerate() != 0) {
	      // Generate the specified number of matrices
	      for (int i = 0; i < data.getAmountToGenerate(); i++) {
	        // Generate a matrix with the specified rows and columns
	        long[][] matrix = matrixCalc.generateMatrix(
	            data.getComputeE().getInputConfig().getRows(),
	            data.getComputeE().getInputConfig().getColumns()
	        );

	        // Add the generated matrix to the ArrayList
	        this.matrices.add(matrix);
	      }
	      data.setMatrices(matrices);
	    }
	  }

  @Override
  public void finalizeAction(long[][] resultMatrix, String outputSource, String delimiter) {
    // No-op
  }

  @Override
  public void initializeAction(String inputSource, String outputSource, String delimiter) {
    // TODO Auto-generated method stub
  }

  public List<long[][]> multiplyMatrix(List<long[][]> matrices) {
    MatrixImplementationSlow matrixCalc = new MatrixImplementationSlow();
    return matrixCalc.multiplyMatrices(matrices);
  }

  public Object performComputation(Object any, Object any2) {
	// TODO Auto-generated method stub
    return null;
  }
}
