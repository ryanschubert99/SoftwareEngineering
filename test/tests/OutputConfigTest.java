package tests;

import java.util.ArrayList;
import java.util.List;

public class OutputConfigTest {
  private List<String> outputList = new ArrayList<>();

  public List<String> getOutput() {
    return outputList;
  }
  public void addOutput(String output) {
	  
    outputList.add(output);
  }
}