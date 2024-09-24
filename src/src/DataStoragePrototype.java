package src;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class DataStoragePrototype implements DataStorageCompute		{
  @Override
	public List<int[][]> readInputArrs(String inputSource)	{
    List<int[][]> matrix = null;
    try (BufferedReader reader = new BufferedReader(new FileReader(inputSource))){
      // add in the matrix creation, read the dimensions in and create the matrix
    }catch (IOException e){
      e.printStackTrace();
    }
    return matrix;
  }

  @Override
    public void writeOutput(int[][] matrix, String outputSource, String delimter){
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputSource))){
      for (int[] row : matrix){
        for (int value : row){
          writer.write(value + delimter);
        }
        writer.newLine();
      } 
    
    } catch (IOException e){
      e.printStackTrace();
    }
  }

  @Override
  public List<Integer> readInputInts(String inputSource) {
	
    return null;
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
