package src;

import java.io.IOException;

import src.ComputeResult.ComputeResultStatus;

public class ComputationCoordinatorImp implements ComputationCoordinator {
  private DataStorageImp dataStore;
  private ComputeEngineImp computeEngine;

  public ComputationCoordinatorImp(DataStorageImp dataStore, ComputeEngineImp compute) {
    this.dataStore = dataStore;
    this.computeEngine = compute;
  }

  public ComputationCoordinatorImp() {
  }

  public ComputeResult beginComputation() throws IOException {
    try {
      ComputeRequest compute = new ComputeRequest();
      DataStorageImp dataStorage = new DataStorageImp(compute);
      ComputeEngineImp computeEng = new ComputeEngineImp(dataStorage);
      return null; // Placeholder, return actual ComputeResult here
    } catch (Exception e) {
      //Exception, if anything throws anything
      // Exception handling for any computation errors
      e.printStackTrace();
      //throw new IOException("An error occurred during computation.", e);
      ComputeResultStatus.isFailure();
    }
  }

  @Override
  public ComputeResult beginComputation(ComputeRequest request) {
    // TODO: Implement this method
    return null;
  }
}
