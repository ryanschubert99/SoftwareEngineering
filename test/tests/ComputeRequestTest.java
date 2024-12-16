package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import src.ComputeRequest;
import src.InputConfigImplementation;
import src.OutputConfigImplementation;

public class ComputeRequestTest {

  private InputConfigImplementation inputConfig;
  private OutputConfigImplementation outputConfig;


  public void beforeEach() {
    inputConfig = new InputConfigImplementation(0, null, 0, 0, 0, ";");
    outputConfig = new OutputConfigImplementation(0, null, 0);
  }
  @Test
  public void testDefaultConstructor() {
    inputConfig = new InputConfigImplementation(0, null, 0, 0, 0, ";");
    outputConfig = new OutputConfigImplementation(0, null, 0);
    ComputeRequest request = new ComputeRequest(inputConfig, outputConfig,";");

    assertNotNull("InputConfig should not be null", request.getInputConfig());
    assertNotNull("OutputConfig should not be null", request.getOutputConfig());
  }

  @Test
  public void testParameterizedConstructorWithDefaultDelimiter() {
    inputConfig = new InputConfigImplementation(0, null, 0, 0, 0, ";");
    outputConfig = new OutputConfigImplementation(0, null, 0);
    ComputeRequest request = new ComputeRequest(inputConfig, outputConfig, ";");

    assertEquals("InputConfig should match the one passed", inputConfig, request.getInputConfig());
    assertEquals("OutputConfig should match the one passed", outputConfig, request.getOutputConfig());
  }

  @Test
  public void testParameterizedConstructor() {
    inputConfig = new InputConfigImplementation(0, "", 0, 0, 0, ";");
    outputConfig = new OutputConfigImplementation(0, "", 0);
   

    ComputeRequest request = new ComputeRequest(inputConfig, outputConfig, ";");

    assertEquals("InputConfig should match the one passed", inputConfig, request.getInputConfig());
    assertEquals("OutputConfig should match the one passed", outputConfig, request.getOutputConfig());
  }

  @Test
  public void testInputConfigAndOutputConfigSetCorrectly() {
    inputConfig = new InputConfigImplementation(0, "", 0, 0, 0, ";");
    outputConfig = new OutputConfigImplementation(0, "", 0);
	   
    ComputeRequest request = new ComputeRequest(inputConfig, outputConfig,";");

    InputConfigImplementation resultInputConfig = request.getInputConfig();
    OutputConfigImplementation resultOutputConfig = request.getOutputConfig();

    assertEquals("InputConfig should match", inputConfig, resultInputConfig);
    assertEquals("OutputConfig should match", outputConfig, resultOutputConfig);
    
  }
}
