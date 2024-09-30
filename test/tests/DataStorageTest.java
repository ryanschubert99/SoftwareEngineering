package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import src.DataStorageImp;

import static org.mockito.Mockito.verify;

import java.io.IOException;

class DataStorageTest {
  private DataStorageImp dataStorage;
  @BeforeEach
    void setUp() throws IOException {
    dataStorage = new DataStorageImp(null);
  }
  @Test
    void testWriteOutput() {
    int[][] matrix = {{1, 2}, {3, 4}};
    String outputSource = "output.txt";
    String delimiter = ",";
    dataStorage.writeOutput(matrix, outputSource, delimiter);
  }
}