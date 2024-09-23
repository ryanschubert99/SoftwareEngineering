
package tests;

import org.junit.Test;
import static org.junit.Assert.*;

import src.ComputeEngineImplementation;

public class ComputeEngineIntegrationTest {

    @Test
    public void testComputeEngineMatrixGeneration() {
        // Arrange: Setup compute engine and test data storage
        ComputeEngineImplementation compute = new ComputeEngineImplementation();
        DataStorageTestOnly data = new DataStorageTestOnly(); // Assuming this stores output

        //Generate a matrix using the compute engine with input 1 and 10
        int[][] arrays = compute.generateMatrix(1, 10);
        
        assertNotNull(arrays);
        assertEquals(10, arrays.length); 
        assertEquals(10, arrays[0].length); 
        
        assertEquals(1, arrays[0][0]); 

        data.addMatrix(arrays);
    }
}
