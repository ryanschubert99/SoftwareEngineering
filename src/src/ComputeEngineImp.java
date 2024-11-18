package src;

import java.util.ArrayList;
import java.util.List;

public class ComputeEngineImp implements ComputeEngine {
  private List<long[][]> matrices = new ArrayList<>();

  public ComputeEngineImp(List<long[][]> matrices, DataStorageImp data) {
	  
    MatrixImplementationSlow matrixCalc = new MatrixImplementationSlow();

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
 //could add ,MatrixAPIInterface matrixAPI
  public ComputeEngineImp(DataStorageImp data) {
    MatrixImplementationSlow matrixCalc = new MatrixImplementationSlow();

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

  public List<long[][]> multiplyMatrixSlow(List<long[][]> matrices) {
    MatrixImplementationSlow matrixCalc = new MatrixImplementationSlow();
    return matrixCalc.multiplyMatricesSlow(matrices);
  }
  public List<long[][]> multiplyMatrixFast(List<long[][]> matrices) {
	    MatrixImplementationSlow matrixCalc = new MatrixImplementationSlow();
	    return matrixCalc.multiplyMatricesFast(matrices);
	  }

  public Object performComputation(Object any, Object any2) {
    // TODO Auto-generated method stub
    return null;
  }
}
