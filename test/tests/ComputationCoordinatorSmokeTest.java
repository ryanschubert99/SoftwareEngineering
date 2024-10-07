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

  
  //Sets up the mock objects before each test.
  @BeforeEach
  public void setUp() {
    dataStore = mock(DataStorageImp.class);
    computeEngine = mock(ComputeEngineImp.class);
    computationCoordinator = new ComputationCoordinatorImp(dataStore, computeEngine);
  }


  //Tests the beginComputation method with a ComputeRequest.
  @Test
  public void testBeginComputationWithRequest() throws IOException {
    ComputeRequest request = new ComputeRequest();
    computationCoordinator.beginComputation(request);

    assertNotNull(request);
  }
}
