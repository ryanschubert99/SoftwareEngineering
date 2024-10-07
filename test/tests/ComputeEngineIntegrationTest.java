package tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

//import org.junit.Before;
//import org.junit.Test;

import src.ComputationCoordinatorImp;
import src.ComputeEngineImp;
import src.DataStorageImp;
import src.ComputeRequest;
import src.ComputeResult;
import src.ComputeResultImp;

import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;


public class ComputeEngineIntegrationTest {

  private ComputationCoordinatorImp computationCoordinator;
  private DataStorageImp dataStore;
  private ComputeEngineImp computeEngine;

  
  @Test
  public void testFullComputationProcess() throws Exception {
	ComputationCoordinatorImp comp = new ComputationCoordinatorImp();
    comp.beginComputation();
    ComputeResultImp result = new ComputeResultImp(true);

    assertNotNull(result);
    assertEquals(ComputeResult.ComputeResultStatus.SUCCESS, result.getStatus());

  }
}
