package tests;
import java.util.ArrayList;
import java.util.List;

import src.DataStorageCompute;
public class DataStorageTestOnly implements DataStorageCompute{

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
  public List<int[][]> readInputArrs(String inputSource) {
  // Convert input to an array of integers
    return inputConfig.getInputArray();
  }
  public void writeOutput(int[][] matrix, String outputSource, String delimiter) {
    outputConfig.addOutput(delimiter);
  }
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


