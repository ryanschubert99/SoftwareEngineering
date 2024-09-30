package src;

import java.io.IOException;
import java.util.List;

public interface DataStorageCompute{
	
  public List<int[][]> readInputArrs(String inputSource);

  public int[][] readInputArr(String inputSource);
	
  public int readInput(String inputSource);
		
  public List<Integer> readInputInts(String inputSource);
  
  public void writeOutput(int[][] matrix, String outputSource, String delimiter);

  List<int[][]> readInputArrs(List<int[][]> a);

  List<int[][]> readInputFile() throws IOException;

  void writeOutput(String outputFileName, String delimiter);

}
