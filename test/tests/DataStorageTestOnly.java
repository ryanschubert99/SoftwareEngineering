package tests;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import src.DataStorage;
public class DataStorageTestOnly implements DataStorage{

  private InputConfigTest inputConfig;
  private OutputConfigTest outputConfig;
  private ArrayList<int[][]> arrays;

  public DataStorageTestOnly(InputConfigTest inputConfig, OutputConfigTest outputConfig) {
    this.inputConfig = inputConfig;
    this.outputConfig = outputConfig;
  }

  public DataStorageTestOnly() {
    this.inputConfig = inputConfig;
    this.outputConfig = outputConfig;
    arrays = new ArrayList<>();
  }
  public void addMatrix(int[][] arr) {
    ArrayList<int[][]> arrays = new ArrayList<>();
    arrays.add(arr);
  }
  public ArrayList<int[][]> getArrays() {
    return arrays;
  }

  public void writeOutput(int[][] matrix, String outputSource, String delimiter) {
    outputConfig.addOutput(delimiter);
  }


  @Override
  public List<long[][]> readInputFile() throws IOException {
	// TODO Auto-generated method stub
    return null;
  }

  @Override
  public void writeOutput(String outputFileName, String delimiter) {
	// TODO Auto-generated method stub	
  }
}


