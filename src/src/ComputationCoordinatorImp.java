package src;

import java.io.IOException;

public class ComputationCoordinatorImp implements ComputationCoordinator {
  private DataStorageImp dataStore;
  private ComputeEngineImp computeEngine;

  private int inputType = 0; // 0 is User Input, and 1 is File Input
  private String inputFileName;
  private int numberOfMatrices;
  private int rows;
  private int multiply;
  private int columns;
  private boolean valid = false;
  private int outputOrCompute;

  public ComputationCoordinatorImp(DataStorageImp dataStore, ComputeEngineImp compute, int inputType, String inputFileName, int numberOfMatrices, int rows, int columns, int outputType, String outputFileName, int outputOrComp) {
    this.dataStore = dataStore;
    this.computeEngine = compute;
    this.inputType = inputType;
    this.inputFileName = inputFileName;
    this.numberOfMatrices = numberOfMatrices;
    this.rows = rows;
    this.columns = columns;
    this.outputOrCompute = outputOrComp;
  }

  public ComputationCoordinatorImp() {}

  public ComputeResult beginComputation(int inputType, String inputFileName, int numberOfMatrices, int rows, int columns, int outputType, String outputFileName, int outputOrComp) throws IOException {
    try {
      this.outputOrCompute = outputOrComp;
      ComputeRequest compute = new ComputeRequest(inputType, inputFileName, numberOfMatrices, rows, columns, outputType, outputFileName);
      DataStorageImp dataStorage = new DataStorageImp(compute, this.outputOrCompute);
      ComputeEngineImp computeEng = new ComputeEngineImp(dataStorage);

      return ComputeResult.SUCCESS;
    } catch (Exception e) {
      e.printStackTrace();
      throw new IOException("An error occurred during computation.", e);
    }
  }

  @Override
  public ComputeResult beginComputation(ComputeRequest request) {
    return null;
  }
}
