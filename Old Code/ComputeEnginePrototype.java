package src;
public class ComputeEnginePrototype extends MatrixImplementation implements ComputeEngine{
  private DataStorageCompute dataStorage;
  private MatrixAPIInterface matrixAPI;
  public ComputeEnginePrototype(DataStorageCompute dataStorage, MatrixAPIInterface matrixAPI){
    this.dataStorage = dataStorage;
    this.matrixAPI = matrixAPI;
  }
  @Override
    public void initializeAction(String inputSource, String outputSource, String delimiter){
    System.out.println("Initializing Compute Engine");
    //read input from the input source
    int[][] matrix1 = dataStorage.readInputArr(inputSource);
    
    int[][] matrix2 = dataStorage.readInputArr(inputSource);
    //computation
    int[][] resultantMatrix = performComputation(matrix1, matrix2);
    //write result to output file
    finalizeAction(resultantMatrix, outputSource, delimiter);
  }
  @Override
    public int[][] performComputation(int[][] matrix1, int[][] matrix2){
	  
    System.out.println("Performing Computation: Multiplying The Matrices.");
    
    return matrixAPI.multiplyMatrices(matrix1, matrix2);
  }
  @Override
    public void finalizeAction(int[][] resultantMatrix, String outputSource, String delimiter){
	  
    System.out.println("Finalizing computation and writing the resultant matrix to the output destination.");
    
    dataStorage.writeOutput(resultantMatrix, outputSource, delimiter);
  }
}
