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


  public void setUp() {
    inputConfig = new InputConfigImplementation();
    outputConfig = new OutputConfigImplementation();
  }
  //@Test
  public void testDefaultConstructor() {

    ComputeRequest request = new ComputeRequest();

    assertNotNull("InputConfig should not be null", request.getInputConfig());
    assertNotNull("OutputConfig should not be null", request.getOutputConfig());
    assertEquals("Delimiter should be the default ';'", ';', request.getDelimiter());
  }

  //@Test
  public void testParameterizedConstructorWithDefaultDelimiter() {
    ComputeRequest request = new ComputeRequest(inputConfig, outputConfig);

    assertEquals("InputConfig should match the one passed", inputConfig, request.getInputConfig());
    assertEquals("OutputConfig should match the one passed", outputConfig, request.getOutputConfig());
    assertEquals("Delimiter should be the default ';'", ';', request.getDelimiter());
  }

  //@Test
  public void testParameterizedConstructorWithCustomDelimiter() {
	  
    char customDelimiter = ',';

    ComputeRequest request = new ComputeRequest(inputConfig, outputConfig, customDelimiter);

    assertEquals("InputConfig should match the one passed", inputConfig, request.getInputConfig());
    assertEquals("OutputConfig should match the one passed", outputConfig, request.getOutputConfig());
    assertEquals("Delimiter should be the custom one", customDelimiter, request.getDelimiter());
  }

  //@Test
  public void testInputConfigAndOutputConfigSetCorrectly() {
	  
    ComputeRequest request = new ComputeRequest(inputConfig, outputConfig);

    InputConfigImplementation resultInputConfig = request.getInputConfig();
    OutputConfigImplementation resultOutputConfig = request.getOutputConfig();

    assertEquals("InputConfig should match", inputConfig, resultInputConfig);
    assertEquals("OutputConfig should match", outputConfig, resultOutputConfig);
    
  }
}
