package tests;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import src.DataStorageImp;
import src.ComputeRequest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataStorageSmokeTest {

  private DataStorageImp dataStore;

  @Before
  public void setUp() throws IOException {
    dataStore = new DataStorageImp(new ComputeRequest(null, null));
  }

  @Test
  public void testGetAndSetMatrices() {
    List<int[][]> matrices = new ArrayList<>();
    dataStore.setMatrices(matrices);

    List<int[][]> result = dataStore.getMatrices();

    assertNotNull(result);
  }

  @Test
  public void testReadData() throws IOException {
    dataStore.readInputFile();

    verify(dataStore).readInputFile();
  }

  @Test
  public void testWriteData() throws IOException {
    dataStore.readInputFile();

    verify(dataStore).readInputFile();
  }
}
