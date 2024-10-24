package tests;

import java.io.File;
import src.ComputationCoordinatorImp;

public class TestUser {
  private final ComputationCoordinatorImp coordinator;

  public TestUser(ComputationCoordinatorImp coordinator) {
    this.coordinator = coordinator;
  }

  public void run(String outputPath) throws Exception {
    char delimiter = ';';
    String inputPath = "test" + File.separatorChar + "testInputFile.test";

    // Call the appropriate method on the coordinator to run the computation
    coordinator.beginComputation(delimiter, inputPath, delimiter, delimiter, delimiter, delimiter, inputPath, delimiter);
  }
}
