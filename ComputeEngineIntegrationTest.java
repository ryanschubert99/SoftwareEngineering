
package tests;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import src.ComputeEngineImplementation;

public class ComputeEngineIntegrationTest {

  @Test
  public void testComputeEngineMatrixGeneration() {
  
    ComputeEngineImplementation compute = new ComputeEngineImplementation();
    DataStorageTestOnly data = new DataStorageTestOnly();

    
    int[][] arrays = compute.generateMatrix(1, 10);
    
        
    assertNotNull(arrays);
    assertEquals(1, arrays.length); 
    assertEquals(10, arrays[0].length);
    
    assertTrue(arrays[0][0] >= 0 && arrays[0][0] < 100);
        
    //assertEquals(0, arrays[0][0]); 

    data.addMatrix(arrays);
  }
}
