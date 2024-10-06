package tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import src.InputConfigImplementation;

public class InputConfigExceptionTest {

  @Test
  public void testInvalidInputTypeHandling() {
    InputConfigImplementation inputConfig = new InputConfigImplementation();
    inputConfig.setUserInputType(0, null, 3, 3, 3, 0);;

    // Check that only correct values were set to variables
    assertTrue(inputConfig.getInputTypeValue() == 1 || inputConfig.getInputTypeValue() == 0);
    assertTrue(inputConfig.getRows() > 0);
    assertTrue(inputConfig.getColumns() > 0);
    assertTrue(inputConfig.getMultiply() == 1 || inputConfig.getMultiply() == 0);
  }
}
