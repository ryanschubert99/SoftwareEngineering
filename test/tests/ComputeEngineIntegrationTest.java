package tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import src.ComputationCoordinatorImp;
import src.ComputeEngineImp;
import src.DataStorageImp;
import src.ComputeRequest;
import src.ComputeResult;

public class ComputeEngineIntegrationTest {

  private ComputationCoordinatorImp computationCoordinator;
  private DataStorageImp dataStore;
  private ComputeEngineImp computeEngine;

  @Before
  public void setUp() throws IOException {
    ComputeRequest computeRequest = new ComputeRequest();
    dataStore = new DataStorageImp(computeRequest);
    computeEngine = new ComputeEngineImp(dataStore);
    computationCoordinator = new ComputationCoordinatorImp(dataStore, computeEngine);
  }

  @Test
  public void testFullComputationProcess() throws Exception {
    ComputeRequest request = new ComputeRequest();

    ComputeResult result = computationCoordinator.beginComputation(request);

    assertNotNull(result);
    assertEquals("Expected result status", "SUCCESS", result.getStatus());
    assertNotNull(dataStore.getMatrices());
    assertEquals(2, dataStore.getMatrices().size());
  }
}
