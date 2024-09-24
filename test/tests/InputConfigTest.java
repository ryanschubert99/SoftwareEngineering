package tests;

import java.util.List;

public class InputConfigTest {
  private List<Integer> inputList;
  private List<int[][]> inputArray;

  public InputConfigTest(List<Integer> inputList) {
    this.inputList = inputList;
  }

  public List<int[][]> getInputArray() {
    return inputArray;
  }
  public List<Integer> getInputInteger() {
    return inputList;
  }
  public void setInput(List<Integer> inputList) {
    this.inputList = inputList;
  }
}
