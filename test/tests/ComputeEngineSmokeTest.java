package tests;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import src.ComputeEngineImp;
import src.DataStorageImp;

import java.util.ArrayList;
import java.util.List;

public class ComputeEngineSmokeTest {

  private ComputeEngineImp computeEngine;
  private DataStorageImp dataStore;

  @Before
  public void setUp() {
    dataStore = mock(DataStorageImp.class);
    computeEngine = new ComputeEngineImp(dataStore);
  }

  @Test
  public void testMatrixGeneration() {
    when(dataStore.getAmountToGenerate()).thenReturn(2);
    when(dataStore.getMatrices()).thenReturn(new ArrayList<>());

    List<long[][]> matrices = new ArrayList<>();
    computeEngine.multiplyMatrix(matrices);

    verify(dataStore).getAmountToGenerate();
    verify(dataStore).getMatrices();
  }

  @Test
  public void testPerformComputation() {
    when(dataStore.getMatrices()).thenReturn(new ArrayList<>());

    Object result = computeEngine.performComputation(new Object(), new Object());

    assertNotNull(result);
  }
}
