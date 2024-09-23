package src;

public class ComputeEngineImplemenation implements ComputeEngine {
  @Override
  public void initializeAction(String inputSource, String outputSource, String delimiter) {

  }
  @Override
  public int[][] performComputation(int[][] matrix1, int[][] matrix2) {
    return new int[0][0]; // Return an empty matrix
  }
  @Override
  public void finalizeAction(int[][] resultMatrix, String outputSource, String delimiter) {
	    // No-op
  }
}


