package tests;


import src.ComputeEngineImp;
import src.DataStorageImp;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ComputeEngineSmokeTest {

	  private ComputeEngineImp computeEngine;
	  private DataStorageImp dataStore;

	  @Test
	  public void testMatrixGeneration() {
		  dataStore = mock(DataStorageImp.class);
		    computeEngine = new ComputeEngineImp(dataStore);
	    when(dataStore.getAmountToGenerate()).thenReturn(2);
	    when(dataStore.getMatrices()).thenReturn(new ArrayList<>());

	    List<long[][]> matrices = new ArrayList<>();
	    computeEngine.multiplyMatrixFast(matrices);

	    verify(dataStore).getAmountToGenerate();
	    verify(dataStore).getMatrices();
	  }

	  @Test
	  public void testPerformComputation() {
		  dataStore = mock(DataStorageImp.class);
		    computeEngine = new ComputeEngineImp(dataStore);
	    when(dataStore.getMatrices()).thenReturn(new ArrayList<>());

	    Object result = computeEngine.performComputation(new Object(), new Object());

	    assertNull(result);
	  }
	}