package tests;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import src.ComputationCoordinatorImplementation;  // Correct spelling
import src.ComputeEngine;
import src.DataStorageCompute;
import src.ComputeRequest;
import src.ComputeResult;

public class ComputationCoordinatorSmokeTest {
  private ComputationCoordinatorImplementation computationCoordinator;
  private DataStorageCompute dataStoreMock;
  private ComputeEngine computeEngineMock;

  @Before
  public void setUp() {
    dataStoreMock = mock(DataStorageCompute.class);
    computeEngineMock = mock(ComputeEngine.class);
    computationCoordinator = new ComputationCoordinatorImplementation(dataStoreMock, computeEngineMock);
  }

  @Test
  public void testCompute() {
    // Arrange
    ComputeRequest request = new ComputeRequest(null, null); 
    
    when(computeEngineMock.performComputation(any(), any())).thenReturn(new int[][]{{1, 2}, {3, 4}});
    
    ComputeResult result = computationCoordinator.compute(request);
  
    assertNotNull(result);
        
    verify(computeEngineMock).initializeAction(anyString(), anyString(), anyString());
    
    verify(dataStoreMock).readInput(anyString());
        // Add more verifications as needed
  }
}
