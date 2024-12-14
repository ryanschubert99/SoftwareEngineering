package tests;


import src.DataStorageImp;
import src.ComputeRequest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class DataStorageSmokeTest {

  private DataStorageImp dataStore;

  
  @Test
  public void testGetAndSetMatrices() throws IOException {
    dataStore = new DataStorageImp(new ComputeRequest(null, null, null), 0);
    List<long[][]> matrices = new ArrayList<>();
    dataStore.setMatrices(matrices);

    List<long[][]> result = dataStore.getMatrices();

    assertNotNull(result);
  }

  @Test
  public void testReadData() throws IOException {
	dataStore = new DataStorageImp(new ComputeRequest(null, null, null), 0);
    dataStore.readInputFile();

    verify(dataStore).readInputFile();
  }

  @Test
  public void testWriteData() throws IOException {
	dataStore = new DataStorageImp(new ComputeRequest(null, null, null), 0);
    dataStore.readInputFile();

    verify(dataStore).readInputFile();
  }
}
