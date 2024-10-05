package src;

import java.io.IOException;

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
    return null;
	}catch(Exception e){
		  //Exception, if anything throws anything 
		  e.printStackTrace();
		  throw new IOException("An error occurred during computation.", e);
	  }
  }

  @Override
  public ComputeResult beginComputation(ComputeRequest request) {
    // TODO Auto-generated method stub
    return null;
  }
}
