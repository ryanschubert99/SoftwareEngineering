package tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import src.ComputationCoordinatorImp;
import src.ComputeEngineImp;
import src.DataStorageImp;
import src.ComputeRequest;

import java.io.IOException;

public class ComputationCoordinatorSmokeTest {

  private ComputationCoordinatorImp computationCoordinator;
  private DataStorageImp dataStore;
  private ComputeEngineImp computeEngine;

  /**
   * Sets up the mock objects before each test.
   */
  @BeforeEach
  public void setUp() {
    dataStore = mock(DataStorageImp.class);
    computeEngine = mock(ComputeEngineImp.class);
    computationCoordinator = new ComputationCoordinatorImp();
  }

  /**
   * Utility method to create a ComputeRequest.
   * 
   * @return a ComputeRequest object with predefined values.
 * @throws IOException 
   */
  private ComputeRequest createComputeRequest() throws IOException {
    // These values simulate what a user might input through a coordinator
	int configType = 0;
	String configFileName = "";
    int inputType = 0; // Example: 0 for user input, 1 for file input
    String inputFileName = "input.txt";
    int numberOfMatrices = 3;
    int rows = 3;
    int columns = 3;
    int outputFileType = 1; // 0 = console output, 1 = file output
    String outputFileName = "output.txt";
    int outputOrComp = 1; // 1 for output, 0 for computation
    int multiply = 1;
    String delimiter= ";";

    return new ComputeRequest(
      configType,
      configFileName,
      inputType, 
      inputFileName, 
      numberOfMatrices, 
      rows, 
      columns, 
      delimiter, 
      outputFileType, 
      outputFileName, 
      outputOrComp
    );
  }

  /**
   * Tests the beginComputation method with a ComputeRequest.
   * 
   * @throws IOException if an input/output error occurs.
   */
  @Test
  public void testBeginComputationWithRequest() throws IOException {
    ComputeRequest request = createComputeRequest();
    computationCoordinator.beginComputation(request);

    assertNotNull(request);
    // verify(computeEngine).initializeAction(anyString(), anyString(), anyString());
    // verify(dataStore).readInputFile();
  }
}
