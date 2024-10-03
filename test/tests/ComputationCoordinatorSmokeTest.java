package tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;


import org.junit.jupiter.api.Test;




import src.ComputationCoordinatorImp;
import src.ComputeEngineImp;
import src.DataStorageImp;
import src.MatrixImplementation;
import src.ComputeRequest;
import src.ComputeResult;

public class ComputationCoordinatorSmokeTest {

  private ComputationCoordinatorImp computationCoordinator;
  private DataStorageImp dataStore;
  private ComputeEngineImp computeEngine;
  private MatrixImplementation matrixCompute;

  
  public void setUp() {
    dataStore = mock(DataStorageImp.class);
    computeEngine = mock(ComputeEngineImp.class);
    computationCoordinator = new ComputationCoordinatorImp(dataStore, computeEngine);
  }

  @Test
  public void testBeginComputationWithRequest() throws IOException {
	  ComputeRequest request = new ComputeRequest();
	  computationCoordinator.beginComputation(request);
	 

    assertNotNull(request);
   //verify(computeEngine).initializeAction(anyString(), anyString(), anyString());
    //verify(dataStore).readInputFile();
  }
}
