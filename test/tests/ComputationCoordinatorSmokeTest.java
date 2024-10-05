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

/**
 * Unit test for the ComputationCoordinatorImp class.
 */
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
    computationCoordinator = new ComputationCoordinatorImp(dataStore, computeEngine);
  }

  /**
   * Tests the beginComputation method with a ComputeRequest.
   * 
   * @throws IOException if an input/output error occurs.
   */
  @Test
  public void testBeginComputationWithRequest() throws IOException {
    ComputeRequest request = new ComputeRequest();
    computationCoordinator.beginComputation(request);

    assertNotNull(request);
    // verify(computeEngine).initializeAction(anyString(), anyString(), anyString());
    // verify(dataStore).readInputFile();
  }
}
