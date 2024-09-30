package tests;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

import src.ComputationCoordinatorImp;  // Correct spelling
import src.ComputeEngine;
import src.ComputeEngineImp;
import src.DataStorageCompute;
import src.DataStorageImp;
import src.ComputeRequest;
import src.ComputeResult;

public class ComputationCoordinatorSmokeTest {
  private ComputationCoordinatorImp computationCoordinator;
  private DataStorageImp dataStore;
  private ComputeEngineImp computeEngine;

  @Before
  public void setUp() {
    dataStore = mock(DataStorageImp.class);
    computeEngine = mock(ComputeEngineImp.class);
    computationCoordinator = new ComputationCoordinatorImp();
  }

  @Test
  public void testCompute() {
    // Arrange
    ComputeRequest request = new ComputeRequest(null, null); 
    
    when(computeEngine.performComputation(any(), any())).thenReturn(new int[][]{{1, 2}, {3, 4}});
    
    ComputeResult result = computationCoordinator.beginComputation(request);
  
    assertNotNull(result);
        
    verify(computeEngine).initializeAction(anyString(), anyString(), anyString());
    
    verify(dataStore).readInput(null);

  }
}
