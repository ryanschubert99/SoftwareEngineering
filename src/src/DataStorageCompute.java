package src;

import java.util.List;

public interface DataStorageCompute{
	
  public List<int[][]> readInputArrs(String inputSource);

  public int[][] readInputArr(String inputSource);
	
  public int readInput(String inputSource);
		
  public List<Integer> readInputInts(String inputSource);
  
  public void writeOutput(int[][] matrix, String outputSource, String delimiter);

}
