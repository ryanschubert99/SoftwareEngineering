package tests;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import src.ComputeEngineImp;
import src.DataStorageCompute;
import src.MatrixAPIInterface;

import static org.mockito.Mockito.mock;

public class ComputeEngineTest {
  @Test
  void testInitializeAction() {
    DataStorageCompute mockDataStorage = Mockito.mock(DataStorageCompute.class);
    MatrixAPIInterface mockMatrixAPI = Mockito.mock(MatrixAPIInterface.class);
    
    ComputeEngineImp computeEngine = new ComputeEngineImp();
    computeEngine.initializeAction("input.txt", "output.txt", ",");
    
  }
}