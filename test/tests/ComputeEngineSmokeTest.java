package tests;

import src.ComputeEngineImp;
import src.DataStorageImp;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ComputeEngineSmokeTest {

  private ComputeEngineImp computeEngine;
  private DataStorageImp dataStore;

  @Test
  public void testMatrixGeneration() {
    // Mock DataStorageImp
    dataStore = mock(DataStorageImp.class);

    // Initialize ComputeEngineImp with the mocked DataStorageImp
    computeEngine = new ComputeEngineImp(dataStore);

    // Mock the responses
    when(dataStore.getAmountToGenerate()).thenReturn(2);

    // Create mock matrices for testing
    List<long[][]> mockMatrices = new ArrayList<>();
    mockMatrices.add(new long[][]{{1, 2}, {3, 4}});  // Add a 2x2 matrix
    mockMatrices.add(new long[][]{{5, 6}, {7, 8}});  // Add another 2x2 matrix
    when(dataStore.getMatrices()).thenReturn(mockMatrices);

    // Call the method you want to test on ComputeEngineImp
    List<long[][]> matrices = dataStore.getMatrices();
    computeEngine.multiplyMatrixFast(matrices);

    // Verify that the mocked methods were called
    verify(dataStore).getAmountToGenerate();
    verify(dataStore).getMatrices();
  }

  @Test
  public void testPerformComputation() {
    // Mock DataStorageImp
    dataStore = mock(DataStorageImp.class);
    computeEngine = new ComputeEngineImp(dataStore);

    // Mock the response for getMatrices method
    when(dataStore.getMatrices()).thenReturn(new ArrayList<>());

    // Perform computation with mocked data
    Object result = computeEngine.performComputation(new Object(), new Object());

    // Assert that the result is null
    assertNull(result);
  }
}
