package src;

public class ComputationCoordinatorImplementation implements ComputationCoordinator{
  private DataStorageComputeImplementation dataStore;
  private ComputeEngineImplementation computeEngine;
 
  public ComputationCoordinatorImplementation(DataStorageCompute dataStore, ComputeEngine computeEngine){
    this.dataStore = dataStore;
    this.computeEngine = computeEngine;
  }
  public ComputationCoordinatorImplementation() {
	// TODO Auto-generated constructor stub
}
public ComputeResult beginComputation() {
	ComputeRequest compute = new ComputeRequest();
    dataStore
    return  null;
  }
}
