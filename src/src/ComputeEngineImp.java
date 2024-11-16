package src;

import java.util.ArrayList;
import java.util.List;

public class ComputeEngineImp implements ComputeEngine {

  public ComputeEngineImp(List<long[][]> matrices, DataStorageImp data) {
    MatrixImplementation matrixCalc = new MatrixImplementation();
    List<long[][]> generatedMatrices = new ArrayList<>();

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
        generatedMatrices.add(matrix);
      }
      if(data.getComputeE().getInputConfig().getMultiply() == 0) {
        data.setMatrices(generatedMatrices);
      }
      else {
        data.setMatrices(matrixCalc.multiplyMatrices(generatedMatrices));
      }
    }
  }

  public ComputeEngineImp(DataStorageImp data) {
	  MatrixImplementation matrixCalc = new MatrixImplementation();
	    List<long[][]> generatedMatrices = new ArrayList<>();

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
	        generatedMatrices.add(matrix);
	      }
	      if(data.getComputeE().getInputConfig().getMultiply() == 0) {
	        data.setMatrices(generatedMatrices);
	      }
	      else {
	        data.setMatrices(matrixCalc.multiplyMatrices(generatedMatrices));
	      }
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
	MatrixImplementation matrixCalc = new MatrixImplementation();
    return matrixCalc.multiplyMatrices(matrices);
  }

  public Object performComputation(Object any, Object any2) {
	// TODO Auto-generated method stub
    return null;
  }
}
