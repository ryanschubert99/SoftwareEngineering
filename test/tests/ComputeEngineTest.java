package tests;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import src.ComputeEnginePrototype;
import src.DataStorageCompute;
import src.MatrixAPIInterface;

import static org.mockito.Mockito.mock;

public class ComputeEngineTest {
  @Test
  void testInitializeAction() {
    DataStorageCompute mockDataStorage = Mockito.mock(DataStorageCompute.class);
    MatrixAPIInterface mockMatrixAPI = Mockito.mock(MatrixAPIInterface.class);
    
    ComputeEnginePrototype computeEngine = new ComputeEnginePrototype(mockDataStorage, mockMatrixAPI);
    computeEngine.initializeAction("input.txt", "output.txt", ",");
    
  }
}