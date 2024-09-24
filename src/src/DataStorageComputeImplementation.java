package src;

import java.util.ArrayList;
import java.util.List;

public class DataStorageComputeImplementation implements DataStorageCompute {
  @Override
  public void writeOutput(int[][] matrix, String outputSource, String delimiter) {
	    
  }
  @Override
  public List<int[][]> readInputArrs(String inputSource) {
    return new ArrayList<int[][]>(); // Return an empty matrix
  }
  @Override
  public List<Integer> readInputInts(String inputSource) {
    return new ArrayList<Integer>();
  }
  @Override
  public int readInput(String inputSource) {
    return 0;
  }
  @Override
  public int[][] readInputArr(String inputSource) {
    return null;
  }
}

