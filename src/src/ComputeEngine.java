package src;

public interface ComputeEngine  {
  void initializeAction(String inputSource, String outputSource, String delimiter);
  int[][] performComputation(int[][] matrix1, int[][] matrix2);
  void finalizeAction(int[][] resultMatrix, String outputSource, String delimiter);
}
