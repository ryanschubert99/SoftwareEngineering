package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import src.DataStoragePrototype;

import static org.mockito.Mockito.verify;

class DataStorageTest {
  private DataStoragePrototype dataStorage;
  @BeforeEach
    void setUp() {
    dataStorage = new DataStoragePrototype();
  }
  @Test
    void testWriteOutput() {
    int[][] matrix = {{1, 2}, {3, 4}};
    String outputSource = "output.txt";
    String delimiter = ",";
    dataStorage.writeOutput(matrix, outputSource, delimiter);
  }
}