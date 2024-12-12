package tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.InputMismatchException;

import src.ComputationCoordinatorImp;
import src.DataStorageImp;
import src.ComputeEngineImp;
import src.ComputeRequest;
import src.ComputeResult;

public class ComputeEngineIntegrationTest {

  private ComputationCoordinatorImp computationCoordinator;
  private DataStorageImp dataStore;
  private ComputeEngineImp computeEngine;

  // Extracted utility method for setting up input parameters
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
    int multiply =1;
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

  public void setUp() throws Exception {
    ComputeRequest computeRequest = createComputeRequest();
    dataStore = new DataStorageImp(computeRequest, 0);
    computeEngine = new ComputeEngineImp(dataStore);
    computationCoordinator = new ComputationCoordinatorImp();
  }

  @Test
  public void testFullComputationProcess() throws Exception {
    setUp(); // Manually call setup for initializing

    ComputeRequest request = createComputeRequest(); // Reusing input parameters

    // Call begin computation using the ComputationCoordinatorImp
    ComputeResult result = computationCoordinator.beginComputation(request);

    assertNotNull(result);
    assertEquals(ComputeResult.ComputeResultStatus.SUCCESS, result.getStatus()); // Comparing status directly
    assertNotNull(dataStore.getMatrices());
    assertEquals(3, dataStore.getMatrices().size()); // Assuming 3 matrices as in the request
  }
}
