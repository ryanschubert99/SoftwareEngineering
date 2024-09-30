
package tests;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import src.ComputeEngineImp;

public class ComputeEngineIntegrationTest {

  @Test
  public void testComputeEngineMatrixGeneration() {
  
    ComputeEngineImp compute = new ComputeEngineImp(null, null);
    DataStorageTestOnly data = new DataStorageTestOnly();

    
    int[][] arrays = compute.generateMatrix(1, 10);
        
    assertNotNull(arrays);
    assertEquals(10, arrays.length); 
    assertEquals(10, arrays[0].length); 
        
    assertEquals(1, arrays[0][0]); 

    data.addMatrix(arrays);
  }
}
