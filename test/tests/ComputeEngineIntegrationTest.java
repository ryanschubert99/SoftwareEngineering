package tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
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
    private ComputeRequest createComputeRequest() {
        // These values simulate what a user might input through a coordinator
        int inputType = 0; // Example: 0 for user input, 1 for file input
        String inputFileName = "input.txt";
        int numberOfMatrices = 3;
        int rows = 3;
        int columns = 3;
        int outputFileType = 1; // 0 = console output, 1 = file output
        String outputFileName = "output.txt";
        int outputOrComp = 1; // 1 for output, 0 for computation

        return new ComputeRequest(inputType, inputFileName, numberOfMatrices, rows, columns, outputFileType, outputFileName, outputOrComp);
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
        assertEquals(1000, dataStore.getMatrices().size()); // Assuming 2 matrices as in the request
    }
}
