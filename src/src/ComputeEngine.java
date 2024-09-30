package src;

public interface ComputeEngine  {
  void initializeAction(String inputSource, String outputSource, String delimiter);
  
  void finalizeAction(int[][] resultMatrix, String outputSource, String delimiter);

}
