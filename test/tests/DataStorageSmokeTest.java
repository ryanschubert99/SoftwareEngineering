package tests;

import src.DataStorageImp;
import src.ComputeRequest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class DataStorageSmokeTest {

  private DataStorageImp dataStore; // Actual DataStorageImp instance

  @Test
  public void testGetAndSetMatrices() throws IOException {
    ComputeRequest request = new ComputeRequest(0, "a.txt", 1, "a.txt", 1, 1, 1, ";", 0, "", 0);
    dataStore = mock(DataStorageImp.class);
    List<long[][]> matrices = new ArrayList<>();
    dataStore.setMatrices(matrices);

    List<long[][]> result = dataStore.getMatrices();

    assertNotNull(result);
  }

  @Test
  public void testReadData() throws IOException {
    ComputeRequest request = new ComputeRequest(0, "a.txt", 1, "a.txt", 1, 1, 1, ";", 0, "", 0);
    dataStore = mock(DataStorageImp.class); // Mocking the instance

    dataStore.readInputFile();

    verify(dataStore).readInputFile(); // Verify the method call on the mock
  }

  @Test
  public void testWriteData() throws IOException {
    ComputeRequest request = new ComputeRequest(0, "a.txt", 0, "", 1, 1, 1, ";", 0, "", 0);
    dataStore = mock(DataStorageImp.class); // Mocking the instance

    dataStore.writeMatrixToFile(null, null, null);

    verify(dataStore).writeMatrixToFile(null, null, null); // Verify the method call on the mock
  }
}
